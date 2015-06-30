package jurassic.park

class DinosaurType {
    Long id
    String name

    static constraints = {
        name nullable: false
    }
}
