package salud

class LugarDolor {

    String torso

    String parteEspecifica

    Date fechaCreacion

    static belongsTo = [ usuario: Usuario ]

    static constraints = {

        torso inList: ['Superior: cabeza', 'Medio: pecho, abdomen', 'Inferior: piernas, pies']


    }

}
