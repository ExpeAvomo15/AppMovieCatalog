package dominio;

import java.util.Objects;

public class Pelicula {
	//ATRIBUTOS
	private String nombre;
	
	//CONSTRUCTOR VACIO
	public Pelicula () {}
	
	//CONSTRUCTOR PARAMETRIZADO
	public Pelicula(String nombre) {
		this.nombre = nombre;
	}
	
	//GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
//MÉTODOS EQUALS Y HASCODE -> Ya que vamos a agregar elementos a una lista, estos métodos dan a cada elemento un identificador único.
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
//TOSTRING
	@Override
	public String toString() {
		return this.nombre;
	}
	
	
	
	/*public static void main(String[] args) {
		var peli1 = new Pelicula("John Wick");
		var peli2 = new Pelicula("Cats");
		
		System.out.println(peli1);
		System.out.println(peli2);
	};*/
	
	
}
