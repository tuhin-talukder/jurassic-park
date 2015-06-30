package jurassic.park

import grails.converters.JSON

class DinosaurController {

//    private processOutput(def output){
//        if(output instanceof Dinosaur){
//            render {"name": output.name, "maxCapacity": output.maxCapacity} as JSON
//        }
//    }

    def index() {
        def d = Dinosaur.findAll()
        render d as JSON
    }
    def create() {
        def dinosaur = new Dinosaur()

        dinosaur.name = params.name
        dinosaur.species = Species.get(params.species);
        dinosaur.cage = Cage.get(params.cage)

        dinosaur.save()
        render dinosaur as JSON
    }
    def show() {
        Dinosaur dinosaur = Dinosaur.get(params.id);
        render dinosaur as JSON
    }
    def update() {
        try{
            Dinosaur dinosaur = Dinosaur.get(params.id)
            dinosaur.name = params.name ?: dinosaur.name;
            render dinosaur as JSON
        }catch (Exception e){
            render e as JSON;
        };

    }
    def delete(){
        Dinosaur dinosaur = Dinosaur.get(params.id);
        dinosaur.delete()
        render dinosaur as JSON
    }
}
