package jurassic.park

import grails.converters.JSON

class ApplicationController {

    def error() {
        Exception exception = request.exception.getCause() ?: request.exception
        render exception as JSON
    }
}
