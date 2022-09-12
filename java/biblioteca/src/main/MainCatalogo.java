package main;

import datos.Libro;
import catalogo.Catalogo;

/**
* La clase {@code MainCatalogo} implementa una aplicación simple para mostrar el uso de {@code Catalogo} junto con {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see catalogo.Catalogo
* @see datos.Libro
* @version 1.0
*/
public class MainCatalogo {

	/**
	* Experimenta con {@code Catalogo}, agregar libros, buscar, y mostrar el {@code Catalogo}.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov, ", "The Caves of Steel, ", 42);
		Libro libro2 = new Libro("Isaac Asimov, ", "The Naked Sun, ", 47);
		Libro libro3 = new Libro("Fernando Torrer, ", "Las torres de Babel, ", 89);
		Libro libro4 = new Libro("Agustin  Laje, ", "El libro negro de la nueva izquierda, ", 48);
		Catalogo catalogo = new Catalogo(10);
	    catalogo.agregarLibro(libro1);
		catalogo.agregarLibro(libro3);
		catalogo.agregarLibro(libro2);
		/*
		System.out.println(libro1);
		System.out.println(libro2);
		System.out.println(libro3);
		*/
		String libroNuevo = libro2.titulo();

		System.out.println("El catalogo es: \n" + catalogo.toString());
		System.out.println("\n El libro " + libro2.titulo() + " esta en catalogo?: \t" + catalogo.buscarPorTitulo(libroNuevo));

		String libroNuevo2 = libro4.titulo();
		System.out.println("\n El libro " + libro4.titulo() + "esta en el catalogo?" );
		if (catalogo.buscarPorTitulo(libroNuevo2) == null){
			System.out.println("Respuesta: No esta");
		} else {
			System.out.println("Respuesta: Si esta");
		}
		
		
	} 

}
