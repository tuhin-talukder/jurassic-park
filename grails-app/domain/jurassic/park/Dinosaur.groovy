package jurassic.park

class Dinosaur {

    Long id
    String name

    Species species

    static belongsTo = [
        cage: Cage
    ]

    static constraints = {
        name nullable: false
    }

    public void setCage(Cage cage){
        if(cage.powerStatus == "DOWN"){
            throw new Exception("Power of Cage is Down");
        }
        if(cage.dinosaurs && cage.dinosaurs.size()>=cage.maxCapacity)
        {
            throw new Exception("Cage is full");
        }
        if(cage.dinosaurs && (cage.dinosaurs[0].species.dinosaurType.name == "Carnivore" || this.species.dinosaurType.name == "Carnivore")){
            if(cage.dinosaurs[0].species.id != this.species.id){
                throw new Exception("Carnivorecan not be assigned in same cage with other species")
            }
        }
        this.@cage=cage;
    }
}
