package Videojuego;

public class Usuario {
	//GET Y SETS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//VARIABLES
	private String nombre;
	private String nick;
	private String email;
	private String dni;
	private String pass;
	private String tipo;
	//CONSTRUCTOR POR DEFECTO
	Usuario(){
		nombre="";
		nick="";
		email="";
		dni="";
		pass="";
		tipo="";
	
	}
	//CONSTRUCTOR SOBRECARGADO
	Usuario( String nombre,String nick,String email,String dni,String pass,String tipo){
		this.nombre=nombre;
		this.nick=nick;
		this.email=email;
		this.dni=dni;
		this.pass=pass;
		this.tipo=tipo;
		
	}
	//Constructor de copia
	Usuario(Usuario usuarios){
		this.nombre=usuarios.nombre;
		this.nick=usuarios.nick;
		this.email=usuarios.email;
		this.dni=usuarios.dni;
		this.pass=usuarios.pass;
		this.tipo=usuarios.tipo;
		
	}
	//Comprobar si son iguales
	boolean EsIgual(Usuario usuarios) {
		boolean salida = false;
		 if(this.nombre==usuarios.nombre &&
			this.nick==usuarios.nick &&
			this.email==usuarios.email &&
			this.dni==usuarios.dni  &&
			this.pass==usuarios.pass &&
			this.tipo==usuarios.tipo)
		 salida = true;
		 return salida;
	}
	//MÉTODO PARA VISUALIZAR 
	void visualizar() {
		System.out.println("//////USUARIO///////");
		System.out.println("Nombre: " + nombre);
		System.out.println("Nick: " + nick);
		System.out.println("Email: " + email);
		System.out.println("DNI: " + dni);
		System.out.println("Pass: " + pass);
		System.out.println("Tipo: " + tipo);
	}
	
}
