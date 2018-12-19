package salud

class Tema {

    String titulo

    String descripcion

    static hasOne = [dolor:Dolor, usuario: Usuario]

    static constraints = {

        titulo min: 5, max: 200
        descripcion min: 50


    }
}
