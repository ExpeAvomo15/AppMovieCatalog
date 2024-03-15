package servicio;

import java.util.ArrayList;
import java.util.List;

import dominio.Pelicula;

public class ServicioPeliculasLista implements IServicioPeliculas {
   //ATRIBUTOS
	private final List<Pelicula> peliculas;
	
	//CONSTRUCTOR VACIO
	public ServicioPeliculasLista() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	@Override
	public void listarPeliculas() {
		// TODO Auto-generated method stub
		System.out.println("Listado de peliculas...");
		peliculas.forEach(System.out::println);
		
	}

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculas.add(pelicula);
		System.out.println("Se agrego la pelicula: "+pelicula);
	}

	@Override
	public void buscarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		//Devuelve le indice de la pelicula, se existe, en la lista
		var indice = peliculas.indexOf(pelicula);
		if(indice == -1) {
			System.out.println("No encontro la pelicula buscada: "+pelicula);
		}
		
		else {
			System.out.println("Se encontro la pelicula en el índice: "+indice);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		//Creamosobjetos de tipo pelicula
		var peli1 = new Pelicula("Batman");
		var peli2 =new Pelicula("Superman");
		
		//Ceamos el servicio (patron de disenio service)
		IServicioPeliculas  servicioPeliculas = new ServicioPeliculasLista();
		//Agragamos las peliculas a la lista
		servicioPeliculas.agregarPelicula(peli1);
		servicioPeliculas.agregarPelicula(peli2);
		//Listamos las peliculas
		servicioPeliculas.listarPeliculas();
		//Buscamos una pelicula
		//Se debeimplementar el metodo equals y hashcode
		servicioPeliculas.buscarPelicula(new Pelicula("La Tormenta"));
	}

}
