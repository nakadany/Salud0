package salud

class Usuario {

    String email

    String comprobacionEmail

    String usuario

    String contraseña

    Date ultimoAcceso

    int cantidadIntentosAcceso

    static hasMany = [tema: Tema]


    static constraints = {


        tema nullable: true
        cantidadIntentosAcceso nullable: true
        ultimoAcceso nullable: true
        usuario size: 5..20, blank: false, nullable: false
        contraseña size: 5..15, blank: false, nullable: false
        email email: true, blank: false, unique: true, nullable: false


    }
}
