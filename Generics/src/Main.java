import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//CLASE 1: COLECCIONES(LIST, SET Y MAP), EQUALS Y HASHCODE

public class Main {

	public static void main(String[] args) {

		//Ejemplo 1: List (Importa el orden, se pueden repetir objetos)
		
		List<String> lista = new ArrayList<String>();
		
		lista.add("Uno");
		lista.add("Uno");
		lista.add("Uno");
		
		System.out.println("Cantidad de elementos: " + lista.size());
		
		lista.forEach(valor -> {
			System.out.println(valor);
		});
		
		//Set(No se permiten duplicados)
		//Ejemplo 2: HashSet(Es como una caja en la que tiro cosas, no me interesa el orden, no se permiten duplicados)
		//La clase String tiene hecho el override al equals y al hashcode, por eso funciona de una perfectamente
		
		/*Diferencia entre '==' y equals()
		La principal diferencia es que el '==' compara direcciones de memoria, y el equals compara valores, y ambos
		muestran el mismo resultado(true) ya que la clase String automaticamente, al instanciar un elemento String si
		este tiene el valor de algun elemento String anterior, apunta al mismo valor de la String pool*/
		
		/*Esta mal usar '==' ya que si alguna version de Java cambia la clase String, tendre que cambiar el '==' por
		 equals() en todos mis proyectos*/
		
		/*
		 String ejemplo1 = "valor";
		 String ejemplo2 = "valor";
		 
		 //Mal
		 if(ejemplo1 == ejemplo2) System.out.println("hola1");
		 
		 //Bien
		 if(ejemplo1.equals(ejemplo2)) System.out.println("hola2");
		 */
		
		Set<String> conjunto = new HashSet<String>();
		
		conjunto.add("Uno");
		conjunto.add("Uno");
		conjunto.add("Dos");
		
		System.out.println("Cantidad de elementos: " + conjunto.size());
		
		conjunto.forEach(valor -> {
			System.out.println(valor);
		});
		
		/*Ejemplo 3: Set con Objetos *Con todas las colecciones con 'Hash'*: (Si quiero que no se repitan los objetos,  
		tengo que hacer un override al equals y al hashcode) Ya que el hashcode de la clase Object genera un codigo 
		diferente siempre por defecto, aunque los objetos sean iguales, y el equals no va a servir de nada si no se hace
		override al hashcode, ya que los hashcodes seran diferentes aunque los objetos sean iguales*/
		
		
		Set<Persona> personas = new HashSet<Persona>();
		
		Persona a = new Persona("12345","Enzo","Roselli",21);
		Persona b = new Persona("43210","Tomas","Abras",24);
		Persona c = new Persona("12345","Enzo","Roselli",21);
		
		personas.add(a);
		personas.add(b);
		personas.add(c);
		
		System.out.println(personas.contains(a));
		
		System.out.println(a.equals(c));
		
		System.out.println("PersonaA.hashCode():  " + a.hashCode()
        + "  PersonaC.hashCode():" + c.hashCode());

		System.out.println("Cantidad de elementos: " + personas.size());
		
		personas.forEach(valor -> {
			System.out.println(valor);
		});
		
		
		//GUIA DE EJERCICIOS UNIDAD 5(TIPOS GENERICOS)
		//1) Y 2)
		
		Generics<Integer> prueba = new Generics<Integer>();
		
		prueba.add(5);
		prueba.add(7);
		prueba.add(8);
		
		if(prueba.exists(4)) {
			System.out.println("Fracaso");
		}
		
		if(prueba.exists(5)) {
			System.out.println("Exito");
		}
		
		prueba.add(2);
		
		System.out.println("Maximo: " + prueba.getMax());
		System.out.println("Minimo: "+ prueba.getMin());
		
		
		
		Generics<Persona> prueba2 = new Generics<Persona>();
		
		prueba2.add(new Persona("123", "Enzo", "Rose", 21));
		prueba2.add(new Persona("456", "Liliana", "Yan", 53));
		prueba2.add(new Persona("789", "Abril", "Rose", 12));
		
		if(prueba2.exists(new Persona("12", "Enzo", "Rose", 21))) {
			System.out.println("Fracaso Persona");
		}
		
		if(prueba2.exists(new Persona("456", "Liliana", "Yan", 53))) {
			System.out.println("Exito Persona");
		}
		
		System.out.println("Maximo Persona: " + prueba2.getMax());
		System.out.println("Minimo Persona: "+ prueba2.getMin());
		
		
		//3)
		
		Pila<String> prueba3 = new Pila<String>();
		
		prueba3.push("Hola");
		prueba3.push("Mundo");
		prueba3.push("Buenas");
		
		System.out.println("Tama�o: " + prueba3.size());
		System.out.println("Elemento base: " + prueba3.pop());
		
		
	}

}
