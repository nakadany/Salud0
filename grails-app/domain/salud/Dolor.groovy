package salud

class Dolor {

    String nivelDolor

    String lugarDolor

    static constraints = {

        nivelDolor inList: ['Leve', 'Moderado', 'Fuerte']

        lugarDolor inList: ['Inferior: Cintura para abajo', 'Central: Cintura hasta cuello', 'Superior: Cuello y cabeza']



    }
}
