package jurassic.park

import grails.converters.JSON
import grails.rest.RestfulController

class CageController extends RestfulController<Cage>{

    def index() {
        def c = Cage.findAll()
        render c as JSON
    }
    def create() {
        def cage = new Cage()

        cage.maxCapacity=params.int("maxCapacity")
        cage.powerStatus = params.powerStatus

        cage.save()
        render cage as JSON
    }
    def show() {
        Cage cage = Cage.get(params.id);
        render cage as JSON
    }
    def update() {
        Cage cage = Cage.get(params.id);
        cage.powerStatus = params.powerStatus ?: cage.powerStatus;
        cage.maxCapacity = params.maxCapacity ?: cage.maxCapacity;
        render cage as JSON
    }
    def delete(){
        Cage cage = Cage.get(params.id);
        cage.delete()
        render cage as JSON
    }
}
