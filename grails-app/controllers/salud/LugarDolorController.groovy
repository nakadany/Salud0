package salud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LugarDolorController {

    LugarDolorService lugarDolorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lugarDolorService.list(params), model:[lugarDolorCount: lugarDolorService.count()]
    }

    def show(Long id) {
        respond lugarDolorService.get(id)
    }

    def create() {
        respond new LugarDolor(params)
    }

    def save(LugarDolor lugarDolor) {
        if (lugarDolor == null) {
            notFound()
            return
        }

        try {
            lugarDolorService.save(lugarDolor)
        } catch (ValidationException e) {
            respond lugarDolor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lugarDolor.label', default: 'LugarDolor'), lugarDolor.id])
                redirect lugarDolor
            }
            '*' { respond lugarDolor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond lugarDolorService.get(id)
    }

    def update(LugarDolor lugarDolor) {
        if (lugarDolor == null) {
            notFound()
            return
        }

        try {
            lugarDolorService.save(lugarDolor)
        } catch (ValidationException e) {
            respond lugarDolor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lugarDolor.label', default: 'LugarDolor'), lugarDolor.id])
                redirect lugarDolor
            }
            '*'{ respond lugarDolor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        lugarDolorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lugarDolor.label', default: 'LugarDolor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lugarDolor.label', default: 'LugarDolor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
