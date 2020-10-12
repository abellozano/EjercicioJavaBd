package Videojuego;

public class Habilidad {
	//GETS Y SETS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//VARIABLES
	private String nombre;
	private int vida;
	private int energia;
	private String tipo;
	
	//CONSTRUCTOR POR DEFECTO
	Habilidad(){
		nombre="";
		vida=0;
		energia=0;
		tipo="";
		
	}
	//cONSTRUCTOR SOBRECARGADO
	Habilidad(String nombre, int vida,int energia, String tipo){
		this.nombre=nombre;
		this.vida=vida;
		this.energia=energia;
		this.tipo=tipo;
		
	}
	//CONSTRUCTOR DE COPIA
	Habilidad(Habilidad habilidad){
		this.nombre=habilidad.nombre;
		this.vida=habilidad.vida;
		this.energia=habilidad.energia;
		this.tipo=habilidad.tipo;
	}
	//COMPROBAR SI SON IGUALES
	public boolean esIgual(Habilidad habilidad) {
		
		boolean salida = false;
		 if( this.nombre.equals(habilidad.nombre)) {
			 salida = true;
		 }
		 return salida;
	}
	@Override
    public boolean equals(Object objeto) {

        boolean salida = false ; 

        Habilidad habilidad = (Habilidad) objeto;

        if(this.nombre.equals(habilidad.nombre))
            salida = true;

        return salida;

    }
	//TO STRING
	@Override
	public  String toString()
	{
	    String salida;
	    salida = nombre+";"+vida+";"+energia+";"+tipo+"\n";
	    return salida;
	}
	//VISUALIZAR HABILIDAD
	void visualizar() {
		System.out.println("////HABILIDAD/////");
		System.out.println("Nombre: " + nombre);
		System.out.println("Vida: " + vida);
		System.out.println("Energia: " + energia);
		System.out.println("Tipo: " + tipo );
	}
}
