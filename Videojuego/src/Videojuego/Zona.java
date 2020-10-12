package Videojuego;

public class Zona {

		//VARIABLES
		String nombre;
		int nivel;
		Personaje[] npcs;
		int numpj;
		
		

		//CONSTRUCTOR POR DEFECTO
		Zona(){
			nombre="";
			nivel=0;

			npcs = new Personaje[10];
			numpj= 0;
		}
		
		//CONTRUCTOR SOBRECARGADO
		Zona(String nombre,int nivel,Personaje[] npcs){
			this.nombre=nombre;
			this.nivel=nivel;
			this.npcs = new Personaje[10];
			
			for (int i = 0; i< npcs.length; i++)
			{
				if(npcs[i]!=null && !this.existe(npcs[i]))
				{
					this.npcs[numpj] = npcs[i];
					this.numpj++;
					
				}
				
			}
			
		}
		
		//CONSTRUCTOR DE COPIA
		Zona(Zona zona){
			this.nombre=zona.nombre;
			this.nivel=zona.nivel;
			
			for (int i = 0; i< npcs.length; i++)
			{
				if(npcs[i]!=null && !this.existe(npcs[i]))
				{
					this.npcs[numpj] = zona.npcs[i];
					this.numpj++;
				}
				
			}
		}
		//COMPROBAMOS SI ES IGUAL EL NOMBRE DE LA ZONA
		boolean esIgual(Zona zona) {
			boolean salida = false;
			 if(this.nombre.equals(zona.nombre))
			 salida = true;
			 return salida;
		}
		
		//VISUALIZAR
		public void visualizar(){
			System.out.println("Nombre: " + nombre);
			System.out.println("Nivel: " + nivel);
			for (int i = 0; i< this.npcs.length; i++)
			{
				if(npcs[i]!=null)
				{
					npcs[i].visualizar();
				}
			}
			System.out.println("-----------------------------------------");
		}
		public void visualizarBasico(){
			System.out.println("Nombre: " + nombre);
			System.out.println("Nivel: " + nivel);
			System.out.println("-----------------------------------------");
		}
		
		//Fuincion para comprobar si el npc ya existe.
		boolean existe(Personaje personaje)
		{
			boolean salida = false;
			for(int i=0; i<this.npcs.length; i++)
			{
				if(this.npcs[i]!=null && this.npcs[i].esIgual(personaje))
					salida=true;
			}
			return salida;
		}
		
	
		
		

		//GETS Y SETS
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getNivel() {
			return nivel;
		}

		public void setNivel(int nivel) {
			this.nivel = nivel;
		}

		public Personaje[] getNpcs() {
			return npcs;
		}

		public void setNpcs(Personaje[] npcs) {
			this.npcs = npcs;
		}

		public int getNumpj() {
			return numpj;
		}

		public void setNumpj(int numpj) {
			this.numpj = numpj;
		}
		
}
