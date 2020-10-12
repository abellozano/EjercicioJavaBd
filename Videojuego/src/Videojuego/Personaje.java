package Videojuego;

public class Personaje {
	
	
	//VARIABLES
	private String nombre;
	private String clase;
	private int vida_max;
	private int energia_max;
	private int vida_actual;
	private int energia_actual;
	private int monedas;
	private Habilidad[] habilidades;
	private Item[] equipos;
	private boolean npc;
	private boolean hostil;
	private int numitem;
	private int numhab;
	
	//CONSTRUCTOR POR DEFECTO
	Personaje(){
		 nombre= "default";
		 clase="default";
		 vida_max= 0;
		 energia_max= 0;
		 vida_actual= 0;
		 energia_actual=0;
		 monedas= 0;
		 npc= false;
		 hostil= false;
		 habilidades= new Habilidad[5];
		 equipos= new Item[5];
		 numitem = 0;
		 numhab = 0;
		
	}
	
	//CONSTRUCTOR SOBRECARGADO
	Personaje(String nombre, String clase, int vida_max, int energia_max, int vida_actual,int energia_actual, int monedas,Habilidad habilidades[], Item equipos[],boolean npc, boolean hostil){
		 this.nombre= nombre;
		 this. clase=clase;
		 this.vida_max=vida_max ;
		 this.energia_max=energia_max ;
		 this.vida_actual= vida_actual;
		 this.energia_actual=energia_actual;
		 this.monedas= monedas;
		 this.npc= npc;
		 this.hostil= hostil;
		 this.habilidades = new Habilidad [5];
		 this.numitem = 0;
		 this.numhab = 0;
		 for (int i = 0; i< habilidades.length; i++)
			{
				if(habilidades[i]!=null && !this.tiene(habilidades[i]))
				{
					this.habilidades[numhab] = habilidades[i];
					this.numhab++;
				}
			
			}
		 this.equipos = new Item [5];
		 for (int i = 0; i< equipos.length; i++)
			{
				if(equipos[i]!=null && !this.tiene(equipos[i]))
				{
					this.equipos[numitem] = equipos[i];
					this.numitem++;
				}
				
			}
		 
	}
	
	//CONSTRUCTOR DE COPIA
	Personaje( Personaje personaje){
		 this.nombre= personaje.nombre;
		 this. clase=personaje.clase;
		 this.vida_max=personaje.vida_max ;
		 this.energia_max=personaje.energia_max ;
		 this.vida_actual= personaje.vida_actual;
		 this.energia_actual=personaje.energia_actual;
		 this.monedas= personaje.monedas;
		 this.npc= personaje.npc;
		 this.hostil= personaje.hostil;
		 for (int i = 0; i< habilidades.length; i++)
			{
				if(habilidades[i]!=null && !this.tiene(habilidades[i]))
				{
					this.habilidades[numhab] = personaje.habilidades[i];
					
					this.numhab++;
				}
				
			}
		
		 for (int i = 0; i< equipos.length; i++)
			{
				if(equipos[i]!=null && !this.tiene(equipos[i]))
				{
					this.equipos[numitem] = personaje.equipos[i];
					this.numitem++;
				}
				
			}
		
	}
	
	//COMPROBAMOS QUE NO TENGAN EL MISMO NOMBRE
	Boolean esIgual(Personaje personaje) {
		boolean salida = false;
		 if(this.nombre.equals(personaje.nombre))
		 salida = true;
		 return salida;
	}
	
	//Visualizamos los personajes 
	void visualizar(){
		System.out.println("/////PERSONAJE///////");
		System.out.println("**-----------------------**");
		System.out.println("Nombre: " + nombre);
		System.out.println("Clase: "+ clase) ;
		System.out.println("Vida máxima: " + vida_max); 
		System.out.println("Energía máxima: " + energia_max); 
		System.out.println("Vida actual: "+ vida_actual); 
		System.out.println("Energia actual: "+ energia_actual); 
		System.out.println("Monedas: " + monedas); 
		System.out.println("Numero de habilidades del  PJ: " + numhab);
		System.out.println("Numero de items del  PJ: " + numitem);
		
		if( npc = true) {
			System.out.println("Es un NPC");
		}else {
			System.out.println("No es un NPC");
		}
		if(hostil = true) {
			System.out.println("**HOSTIL**");
		}else {
			
			System.out.println("**NEUTRAL**");
		}
		System.out.println("**-----------------------**");

	}
	
	public void visualizarBasico(){
		System.out.println("/////PERSONAJE///////");
		System.out.println("**-----------------------**");
		System.out.println("Nombre: " + nombre);
		System.out.println("Clase: "+ clase) ;
		System.out.println("Vida máxima: " + vida_max); 
		System.out.println("Energía máxima: " + energia_max); 
		System.out.println("Vida actual: "+ vida_actual); 
		System.out.println("Energia actual: "+ energia_actual); 
		System.out.println("Monedas: " + monedas); 
		System.out.println("Numero de habilidades del  PJ: " + numhab);
		System.out.println("Numero de items del  PJ: " + numitem);
		if( npc = true) {
			System.out.println("Es un NPC");
		}else {
			System.out.println("No es un NPC");
		}
		if(hostil = true) {
			System.out.println("**HOSTIL**");
		}else {
			
			System.out.println("**NEUTRAL**");
		}
		System.out.println("**-----------------------**");
	}
	//FUNCION TIENE, donde comprobamos si el personaje ya tiene la HABILIDAD
	boolean tiene(Habilidad habilidad)
	{
		
		boolean salida = false;
		for(int i=0; i<this.habilidades.length; i++)
		{
			if(this.habilidades[i]!=null && this.habilidades[i].esIgual(habilidad))
				salida=true;
		}
		return salida;
	}
	
	@Override
    public boolean equals(Object objeto) {

        boolean salida = false ; 

        Personaje personaje = (Personaje) objeto;

        if(this.nombre.equals(personaje.nombre))
            salida = true;

        return salida;

    }
	
	//TOSTRING
	@Override
    public  String toString()
    {

        String salida;
        salida = nombre+";"+clase+";"+vida_max+";"+energia_max+";"+vida_actual+";"+energia_actual+";"+monedas+";"+npc+";"+hostil+";";

        for (int i = 0; i< this.habilidades.length; i++)
        {
            if(habilidades[i]!=null)
            {
                if(i<numhab-1)
                {
                salida +=habilidades[i].getNombre().toString()+",";

                }else {

                    salida +=habilidades[i].getNombre().toString();
                }
            }


        }
        return salida;
    }
	
	//FUNCION TIENE, donde comprobamos si el personaje ya tiene el ITEM
	boolean tiene(Item equipos)
	{
		
		boolean salida = false;
		for(int i=0; i<this.equipos.length; i++)
		{
			if(this.equipos[i]!=null && this.equipos[i].esIgual(equipos))
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
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public int getVida_max() {
		return vida_max;
	}
	public void setVida_max(int vida_max) {
		this.vida_max = vida_max;
	}
	public int getEnergia_max() {
		return energia_max;
	}
	public void setEnergia_max(int energia_max) {
		this.energia_max = energia_max;
	}
	public int getVida_actual() {
		return vida_actual;
	}
	public void setVida_actual(int vida_actual) {
		this.vida_actual = vida_actual;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	public Habilidad[] getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Habilidad[] habilidades) {
		this.habilidades = habilidades;
	}
	public Item[] getEquipos() {
		return equipos;
	}
	public void setEquipos(Item[] equipos) {
		this.equipos = equipos;
	}
	public boolean isNpc() {
		return npc;
	}
	public void setNpc(boolean npc) {
		this.npc = npc;
	}
	public boolean isHostil() {
		return hostil;
	}
	public void setHostil(boolean hostil) {
		this.hostil = hostil;
	}
	public int getEnergia_actual() {
		return energia_actual;
	}

	public void setEnergia_actual(int energia_actual) {
		this.energia_actual = energia_actual;
	}

	public int getNumitem() {
		return numitem;
	}

	public void setNumitem(int numitem) {
		this.numitem = numitem;
	}

	public int getNumhab() {
		return numhab;
	}

	public void setNumhab(int numhab) {
		this.numhab = numhab;
	}
}
