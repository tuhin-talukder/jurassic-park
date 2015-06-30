package jurassic.park

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Species {
    Long id
    String name

    DinosaurType dinosaurType

    static constraints = {
        name nullable: false
    }
}
