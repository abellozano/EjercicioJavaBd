package Videojuego;

public class Arma extends Item{
	private int agravio;
	private int peso;
	
	
	Arma(){
		
		super();	
		this.agravio=0;
		this.peso=0;
		
	}

	Arma(Arma arma){
		
		
		this.nombre=arma.nombre;
		this.valor = arma.valor;
		this.accion = new Habilidad[5];
		for (int i = 0; i< this.accion.length; i++)
		{
				this.accion[i] = arma.accion[i];
		}
		this.agravio=arma.agravio;
		this.peso=arma.peso;
		
	}
	
	Arma (String nombre,int valor,Habilidad[] acciones,int agravio,int peso){
		
		this.nombre=nombre;
		this.valor=valor;
		this.agravio=agravio;
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
		
		System.out.println("****  Arma ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Agravio:" + agravio);
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
		
		System.out.println("****  Arma ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Agravio:" + agravio);
		System.out.println("Peso : "+ peso);	
		
	}
}
