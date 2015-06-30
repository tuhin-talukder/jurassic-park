package jurassic.park

class Cage {
    Long id
    Integer maxCapacity
    String powerStatus

    static hasMany = [
        dinosaurs: Dinosaur
    ]

    static constraints = {
        maxCapacity nullable: false
        powerStatus nullable: false
    }
    public void setPowerStatus(String powerStatus){
        if(dinosaurs && dinosaurs.size()>0 && powerStatus == "DOWN")
        {
            throw new Exception("Power Status cant be down with Dino inside");
        }

        this.@powerStatus = powerStatus
    }
//
//    public Integer getDinosaurContained(){
//        return dinosaurs ? dinosaurs.size() : 0
//    }
}
