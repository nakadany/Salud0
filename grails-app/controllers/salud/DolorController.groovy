package salud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DolorController {

    DolorService dolorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dolorService.list(params), model:[dolorCount: dolorService.count()]
    }

    def show(Long id) {
        respond dolorService.get(id)
    }

    def create() {
        respond new Dolor(params)
    }

    def save(Dolor dolor) {
        if (dolor == null) {
            notFound()
            return
        }

        try {
            dolorService.save(dolor)
        } catch (ValidationException e) {
            respond dolor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dolor.label', default: 'Dolor'), dolor.id])
                redirect dolor
            }
            '*' { respond dolor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dolorService.get(id)
    }

    def update(Dolor dolor) {
        if (dolor == null) {
            notFound()
            return
        }

        try {
            dolorService.save(dolor)
        } catch (ValidationException e) {
            respond dolor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dolor.label', default: 'Dolor'), dolor.id])
                redirect dolor
            }
            '*'{ respond dolor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dolorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dolor.label', default: 'Dolor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dolor.label', default: 'Dolor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
