package salud

import grails.gorm.services.Service

@Service(LugarDolor)
interface LugarDolorService {

    LugarDolor get(Serializable id)

    List<LugarDolor> list(Map args)

    Long count()

    void delete(Serializable id)

    LugarDolor save(LugarDolor lugarDolor)

}