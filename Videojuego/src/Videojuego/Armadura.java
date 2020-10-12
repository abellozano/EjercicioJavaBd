package Videojuego;

public class  Armadura extends Item{
	private int armadura;
	private int peso;
	
	
	Armadura(){
		
		super();	
		this.armadura=0;
		this.peso=0;
		
			
		
	}

	Armadura(Armadura armadura){
		this.numhabi=0;
		this.numhabi = armadura.numhabi;
		this.nombre=armadura.nombre;
		this.valor = armadura.valor;
		this.accion = new Habilidad[5];
		for (int i = 0; i< this.accion.length; i++)
		{
				this.accion[i] = armadura.accion[i];
		}
		this.armadura=armadura.armadura;
		this.peso=armadura.peso;
		
	}
	
	Armadura (String nombre,int valor,Habilidad[] acciones,int armadura,int peso){
		
		this.nombre=nombre;
		this.valor=valor;
		this.armadura=armadura;
		this.peso=peso;
		this.accion = new Habilidad[5];
		for (int i = 0; i< acciones.length; i++)
		{
			if(acciones[i]!=null && !this.tiene(acciones[i]))
			{
				this.accion[numhabi] = acciones[i];
				this.numhabi++;
			}
				
		}
		
		
	}
	
	
	

	public void visualizar() {
		
		System.out.println("****  Armadura ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Armadura:" + armadura);
		System.out.println("Peso : "+ peso);
		
		for (int i = 0; i< this.accion.length; i++)
		{
			if(accion[i]!=null)
			{
				System.out.println();
				System.out.println("Accion" + (i+1));
				accion[i].visualizar();
			}
		}
		
	}
	
	public void visualizarBasico() {
		
		System.out.println("****  Armadura ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Armadura:" + armadura);
		System.out.println("Peso : "+ peso);	
		
	}
	//gets y sets
	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
		
}
