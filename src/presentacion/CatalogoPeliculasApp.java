package presentacion;

import java.util.Scanner;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

public class CatalogoPeliculasApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var salir = false;
		var consola = new Scanner(System.in);
		//Agregamos la implementacion del servicio
		//IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
		IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
		
		while (!salir) {
			
			try {
				
				mostrarMenu();
				salir = ejecutarOpciones(consola, servicioPeliculas);
				
			}//Fin tray
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error: "+e.getMessage());
			}//fin catch
			System.out.println();
			
		}//fin while
		
	}
	
	private static void mostrarMenu() {
		System.out.print("""
				*** Catalogo de Peliculas ***
				1. Agragar pelicula
				2. Listar peliculas
				3.Buscar pelicula
				4. Salir
				Elige una opcion:
				""");
		
	}
	
	private static boolean ejecutarOpciones (Scanner consola, 
						IServicioPeliculas servicioPeliculas) {
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		
		switch (opcion) {
		case 1 -> {
			System.out.println("Introduce el nombre de la pelicula: ");
			var nombrePelicula = consola.nextLine();
			servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
			
		}//fin case1
		case 2 ->{
			servicioPeliculas.listarPeliculas();
		}//fin case2
		
		case 3 ->{
			System.out.println("Introduce la pelicula a buscar: ");
			var nombrePelicula = consola.nextLine();
			servicioPeliculas.buscarPelicula(new Pelicula(nombrePelicula));
			
		}//fin case3
		
		case 4 ->{
			System.out.println("Hasta pronto...");
			salir = true;
			
		}//fin case3
		
		default -> System.out.println("Opcion no reconocida: "+opcion);
		
		}//fin switch
		
		
		return salir;
	}

}
