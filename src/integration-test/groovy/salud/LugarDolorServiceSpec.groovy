package salud

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LugarDolorServiceSpec extends Specification {

    LugarDolorService lugarDolorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LugarDolor(...).save(flush: true, failOnError: true)
        //new LugarDolor(...).save(flush: true, failOnError: true)
        //LugarDolor lugarDolor = new LugarDolor(...).save(flush: true, failOnError: true)
        //new LugarDolor(...).save(flush: true, failOnError: true)
        //new LugarDolor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //lugarDolor.id
    }

    void "test get"() {
        setupData()

        expect:
        lugarDolorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LugarDolor> lugarDolorList = lugarDolorService.list(max: 2, offset: 2)

        then:
        lugarDolorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        lugarDolorService.count() == 5
    }

    void "test delete"() {
        Long lugarDolorId = setupData()

        expect:
        lugarDolorService.count() == 5

        when:
        lugarDolorService.delete(lugarDolorId)
        sessionFactory.currentSession.flush()

        then:
        lugarDolorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LugarDolor lugarDolor = new LugarDolor()
        lugarDolorService.save(lugarDolor)

        then:
        lugarDolor.id != null
    }
}
