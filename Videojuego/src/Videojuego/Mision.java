package Videojuego;

public class Mision {
	

	//VARIABLES
	private String nombre;
	private int nivel;
	private Personaje objetivo;
	private Zona zona;
	private Item recompensa;
	private int monedas;
	private int numobj;
	private int numzona;
	private int numitem;
	
	
	//CONSTRUCTOR POR DEFECTO 
	Mision(){
		nombre="";
		nivel=0;
		objetivo=new Personaje();
		zona=new Zona();
		recompensa=new Consumible();
		monedas=0;
		numobj=0;
		numzona=0;
		numitem=0;
		
	}
	
	//CONSTRUCTOR SOBRECARGADO
	Mision(String nombre,int nivel,Personaje objetivo,Zona zona,Item recompensa,int monedas){
		this.nombre=nombre;
		this.nivel=nivel;
		this.objetivo=objetivo;
		this.zona=zona;
		this.recompensa=recompensa;
		this.monedas=monedas;
		this.numobj=numobj;
		numobj++;
	}
	

	//CONSTRUCTR DE COPIA
	Mision(Mision mision){
		this.nombre=mision.nombre;
		this.nivel=mision.nivel;
		this.objetivo=mision.objetivo;
		this.zona=mision.zona;
		this.recompensa=mision.recompensa;
		this.monedas=mision.monedas;
	}
	
	//COMPROBAMOS SI LA MISION ES IGUAL A UNA EXISTENTE 
	boolean esIgual(Mision mision) {
		boolean salida = false;
		 if(this.nombre==mision.nombre) {
			salida = true;
		 }
		 return salida;
	}
	
	//VISUALIZAMOS LAS MISIONES
	public void visualizar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Nivel: " +nivel );
		System.out.println("Numero de personajes: " + numobj);
		System.out.println("Numero de Zona: " + numzona);
		System.out.println("Numero de recompensas: " + numitem);
		System.out.println("Monedas: " + monedas);
	}
	public void visualizarBasico() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Nivel: " +nivel );
		
	
		System.out.println("Monedas: " + monedas);
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
	public Personaje getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Personaje objetivo) {
		this.objetivo = objetivo;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public Item getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Item recompensa) {
		this.recompensa = recompensa;
	}
	
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
}

