import grails.converters.JSON
import jurassic.park.DinosaurType
import jurassic.park.Species

class BootStrap {

    def init = { servletContext ->
        if (DinosaurType.count() == 0) {
            new DinosaurType(name: 'Carnivore').save()
            new DinosaurType(name: 'Harvbivore').save()
        }
        if (Species.count() == 0) {
            new Species(name: 'Tyrannosaurus',dinosaurType:DinosaurType.proxy(1)).save()
            new Species(name: 'Velociraptor',dinosaurType:DinosaurType.proxy(1)).save()
            new Species(name: 'Spinosaurus',dinosaurType:DinosaurType.proxy(1)).save()
            new Species(name: 'Megalosaurus',dinosaurType:DinosaurType.proxy(1)).save()


            new Species(name: 'Brachiosaurus',dinosaurType:DinosaurType.proxy(2)).save()
            new Species(name: 'Stegosaurus',dinosaurType:DinosaurType.proxy(2)).save()
            new Species(name: 'Ankylosaurus',dinosaurType:DinosaurType.proxy(2)).save()
            new Species(name: 'Triceratops',dinosaurType:DinosaurType.proxy(2)).save()
        }
    }
    def destroy = {
    }
}
