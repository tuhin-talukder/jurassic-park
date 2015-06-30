import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.exceptions.ConverterException
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller
import org.codehaus.groovy.grails.web.json.JSONWriter

import java.beans.PropertyDescriptor
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Created by christina on 6/30/15.
 */
class CustomObjectMarshaller implements ObjectMarshaller<JSON> {

    String[] excludedProperties = ['metaClass']

    public boolean supports(Object object) {
        return object instanceof GroovyObject;
    }

    public void marshalObject(Object o, JSON json) throws ConverterException {
        JSONWriter writer = json.getWriter();
        try {
            writer.object();
            for (PropertyDescriptor property : BeanUtils.getPropertyDescriptors(o.getClass())) {
                String name = property.getName();
                Method readMethod = property.getReadMethod();
                if (readMethod != null && !(name in excludedProperties)) {
                    Object value = readMethod.invoke(o, (Object[]) null);
                    if (value != null) {
                        writer.key(name);
                        json.convertAnother(value);
                    }
                }
            }
            for (Field field : o.getClass().getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) && !(Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers))) {
                    writer.key(field.getName());
                    json.convertAnother(field.get(o));
                }
            }
            writer.endObject();
        }
        catch (ConverterException ce) {
            throw ce;
        }
        catch (Exception e) {
            throw new ConverterException("Error converting Bean with class " + o.getClass().getName(), e);
        }
    }
}
