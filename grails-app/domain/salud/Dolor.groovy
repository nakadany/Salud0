package salud

class Dolor {

    String nivelDolor

    String lugarDolor

    Tema tema


    static constraints = {

        nivelDolor inList: ['Leve', 'Moderado', 'Fuerte'], nullable: false

        lugarDolor inList: ['Superior: cabeza', 'Medio: pecho, abdomen', 'Inferior: piernas, pies']




    }
}
