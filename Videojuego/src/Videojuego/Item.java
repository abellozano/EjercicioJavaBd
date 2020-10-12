package Videojuego;

public abstract class  Item {
	
	//Variables
	String nombre;
	int peso;
	String tipo;
	int valor;
	int agravio;
	int armadura;
	Habilidad[] accion;
	int numitem;
	int numhabi;
	//Constructor por defecto
	
	Item(){
		nombre="default";
		peso= 0;
		tipo="default";
		valor=0;
		agravio=0;
		armadura=0;
		accion = new Habilidad[5];	
	}
	//Constructor sobrecargado
	Item(	String nombre,int peso,String tipo,int valor,int agresivo,int armadura,Habilidad [] accion){
		this.nombre=nombre;
		this.peso= peso;
		this.tipo=tipo;
		this.valor=valor;
		this.agravio=agresivo;
		this.armadura=armadura;
		this.accion= accion;
		this.numitem = 0;
		for (int i = 0; i< accion.length; i++)
		{
			if(accion[i]!=null && !this.tiene(accion[i]))
			{
				this.accion[numitem] = accion[i];
				this.numitem++;
			}
		
		}
		
	}
	//Constructor de copia
	Item(Item item){
		this.nombre=item.nombre;
		this.peso= item.peso;
		this.tipo=item.tipo;
		this.valor=item.valor;
		this.agravio=item.agravio;
		this.armadura=item.armadura;
		this.accion = new Habilidad[10];
		for (int i = 0; i< this.accion.length; i++)
		{
			this.accion[i] = item.accion[i];
		}
	}
	
	//Funcion de visualizar 
	void visualizar(){
		System.out.println("/////ITEM///////");
		System.out.println("Nombre del Item: " + nombre);
		System.out.println("Peso del Item:"+ peso) ;
		System.out.println("Tipo del Item:" + tipo); 
		System.out.println("Valor del Item:" + valor); 
		System.out.println("Agravio del Item:"+ agravio); 
		System.out.println("Armadura del Item:" + armadura); 
		//mostrar habilidades
		for (int i = 0; i< this.accion.length; i++)
		{
			if(accion[i]!=null)
			{
				System.out.println();
				System.out.println("Accion " + (i+1));
				accion[i].visualizar();
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	void visualizarBasico(){
		System.out.println("/////ITEM///////");
		System.out.println("Nombre del Item: " + nombre);
		System.out.println("Peso del Item:"+ peso) ;
		System.out.println("Tipo del Item:" + tipo); 
		System.out.println("Valor del Item:" + valor); 
		System.out.println("Agravio del Item:"+ agravio); 
		System.out.println("Armadura del Item:" + armadura); 
		//mostrar habilidades
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	
	//Funcion de es igual
	boolean esIgual(Item item)
	{
		boolean salida = true;

		if(this.nombre.equals(item.nombre) &&
				this.tipo.equals(item.tipo))
		{
			if(this.numhabi==item.numhabi)
			{
				for(int i = 0; i<item.numhabi;i++)
				{
					if(!this.tiene(item.accion[i]))
					{
						salida=false;
					}
				}
			}
			else
				salida =false;
		}
		else
			salida =false;
		return salida;
	}
	@Override
    public boolean equals(Object objeto) {

        boolean salida = false ; 

        Item item = (Item) objeto;

        if(this.nombre.equals(item.nombre))
            salida = true;

        return salida;

    }
	//Comprobar existe la habilidad en el array de habilidades 
	boolean tiene(Habilidad habilidad)
	{
		
		boolean salida = false;
		for(int i=0; i<this.accion.length; i++)
		{
			if(this.accion[i]!=null && this.accion[i].esIgual(habilidad))
				salida=true;
		}
		return salida;
	}
	
	//Añadir habilidad
	 boolean addHabilidad(Habilidad habilidad){
		boolean salida = false;
		habilidad.visualizar();
		System.out.println("Introduce una Habilidad");
		
		//TERMINAR
		
		return salida= true;
	}
	 
	
	//Gets y Sets
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getPeso() {
			return peso;
		}
		public void setPeso(int peso) {
			this.peso = peso;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		public int getAgresivo() {
			return agravio;
		}
		public void setAgresivo(int agresivo) {
			this.agravio = agresivo;
		}
		public int getArmadura() {
			return armadura;
		}
		public void setArmadura(int armadura) {
			this.armadura = armadura;
		}
		public Habilidad[] getAccion() {
			return accion;
		}
		public void setAccion(Habilidad[] accion) {
			this.accion = accion;
		}
}	
