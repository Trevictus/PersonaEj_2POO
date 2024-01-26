/*Crear una clase Persona que tenga nombre, peso (en kg con decimales), altura (en metros con decimales) y su imc.

Crear un constructor primario con todos los atributos, excepto nombre e imc. Este último atributo se calcula en función del peso y la altura. Por tanto no se debe poder modificar, pero si consultar.

Crear un constructor secundario que también incluya el nombre de la persona cómo parámetro.

Implementa el método toString, representación del objeto en forma de String: override fun toString() = "". (Pulsa Ctrl+o)

En el main() a) crear 3 personas diferentes (la primera sin nombre) utilizando el constructor primario y secundario y b) mostrarlas por consola. A continuación, realizar lo siguiente:

Sobre la persona 1: a) modificar su nombre y para ello debes solicitarlo al usuario por consola. No puede ser nulo o vacio. b) Mostrar por consola sólo el nombre, peso y altura.
Sobre la persona 3: a) Mostrar el peso, altura y imc. b) Modificar la altura, por ejemplo a 1.80 c) Mostrar el peso, altura y imc.
Sobre la persona 2; a) Modificar la altura para que tenga el mismo valor que la persona 3. b) Mostrar la persona 2 y persona 3. c) Comparar si las dos personas son iguales, y mostrar el resultado. d) Implementa el método equals():boolean (Pulsa Ctrl+o). e) Ejecutar la comparación.*/

class Persona(var peso: Double, var altura: Double){
    var nombre: String = "Sin nombre"

    val imc: Double
        get() = calcularImc()


    init {
        require(nombre.isNotBlank()) {"Nombre no vacio"}
        require(peso > 0 && altura >0) {"El peso y/o la altura deben ser mayor que 0."}
    }

    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura) {
        this.nombre = nombre
    }

    private fun calcularImc() = this.peso/(this.altura * this.altura)


    override fun toString(): String {
        return "${this.nombre} con el peso de ${this.peso}kg y la altura de ${this.altura}m, tiene un imc de ${this.imc}\n"
    }
}

fun main(){
    val persona1 = Persona(57.0, 1.81)
    val persona2 = Persona("Víctor", 79.0, 1.61)
    val persona3 = Persona("David", 73.0, 1.71)

    println("Introduce el nombre de la persona 1.")
    val pedirNombre = readln()
    if (pedirNombre.isNotEmpty()){
        persona1.nombre = pedirNombre
    }
    println(persona1)

    println("Introduce la altura de la persona 3.")
    val pedirAltura: Double = readln().toDouble()
    if (pedirAltura > 0){
        persona3.altura = pedirAltura
    }
    println(persona2)

    persona2.altura = persona3.altura
    println("${persona2}${persona3}")

    val comparacion = persona2.equals(persona3)

    println(comparacion)
}