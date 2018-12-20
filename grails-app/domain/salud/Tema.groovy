package salud

class Tema {

    String titulo

    String descripcion

    static hasOne = [dolor:Dolor, usuario: Usuario]

    static constraints = {




    }
}
