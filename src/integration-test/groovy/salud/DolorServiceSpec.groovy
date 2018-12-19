package salud

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DolorServiceSpec extends Specification {

    DolorService dolorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dolor(...).save(flush: true, failOnError: true)
        //new Dolor(...).save(flush: true, failOnError: true)
        //Dolor dolor = new Dolor(...).save(flush: true, failOnError: true)
        //new Dolor(...).save(flush: true, failOnError: true)
        //new Dolor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dolor.id
    }

    void "test get"() {
        setupData()

        expect:
        dolorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dolor> dolorList = dolorService.list(max: 2, offset: 2)

        then:
        dolorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dolorService.count() == 5
    }

    void "test delete"() {
        Long dolorId = setupData()

        expect:
        dolorService.count() == 5

        when:
        dolorService.delete(dolorId)
        sessionFactory.currentSession.flush()

        then:
        dolorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dolor dolor = new Dolor()
        dolorService.save(dolor)

        then:
        dolor.id != null
    }
}
