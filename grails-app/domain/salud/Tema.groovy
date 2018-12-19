package salud

class Tema {

    String titulo

    Dolor dolor

    String descripcion

    static constraints = {

        titulo min: 5, max: 200
        descripcion min: 50
        var

    }
}
