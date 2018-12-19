package salud

import grails.gorm.services.Service

@Service(Dolor)
interface DolorService {

    Dolor get(Serializable id)

    List<Dolor> list(Map args)

    Long count()

    void delete(Serializable id)

    Dolor save(Dolor dolor)

}