package Videojuego;

public class Consumible extends Item {
	private int cantidad;
	
	Consumible(){
		
		super();	
		this.cantidad=0;

	}

	Consumible(Consumible consumible){
		this.cantidad=consumible.cantidad;
		this.accion = new Habilidad[5];
		for (int i = 0; i< this.accion.length; i++)
		{
				this.accion[i] = consumible.accion[i];
		}
		
	}
	
	Consumible (String nombre,int valor,Habilidad[] acciones,int cantidad){
		
		this.nombre=nombre;
		this.valor=valor;
		this.cantidad=cantidad;
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
		
		System.out.println("****  Consumible ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Cantidad:" + armadura);
		
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
		
		System.out.println("****  Consumible ******");
		System.out.println("Nombre:" + nombre);
		System.out.println("Valor : " + valor);
		System.out.println("Cantidad: " + cantidad);
		
	}
	
}
