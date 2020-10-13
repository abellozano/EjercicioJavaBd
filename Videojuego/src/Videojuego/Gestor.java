package Videojuego;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Gestor {
	
	// Declaramos y definimos variables
		public ArrayList<Habilidad> habilidades;
		public ArrayList<Item> items;
		public ArrayList<Personaje> personajes;
		
		public Mision[] misiones;
		public Zona[] zonas;
		private int numhab;//numero de habilidades en nuestro array de habilidades
		private int numitem; // numero de items en nuestro array de items
		private int numpj; //numero de personajes en nuestro array de personajes
		private int nummision; //numero de misiones en nuestro array de misiones
		private int numzona; //numero de zonas en nuestro array de zonas
		private Scanner teclado = new Scanner(System.in);
		
		// Damos valor a los arrays y las variables
		public Gestor()
		{
			habilidades = new ArrayList<Habilidad>();
			items = new ArrayList<Item>();
			personajes = new ArrayList<Personaje>();
			misiones = new Mision[50];
			zonas = new Zona[50];
			numhab = 0;
			numitem = 0;
			numpj = 0;
			nummision = 0;
			numzona = 0;
			//leerDeFichero();
			
		}
		
		
		
		// Mostramos el menú
		public void menu()
		{
			int opcion;
			
			System.out.println("Bienvenido al gestor del videojuego:");
			do {
				//MENU
				System.out.println("Selecciona la opción deseada");
				System.out.println("Opcion 1: Añadir Habilidad  ");
				System.out.println("Opcion 2: Mostrar Habilidades ");
				System.out.println("Opcion 3: Eliminar Habilidad");
				System.out.println("Opcion 4: Añadir Item ");
				System.out.println("Opcion 5: Añadir Habilidades al Item");
				System.out.println("Opcion 6: Eliminar Habilidades al Item");
				System.out.println("Opcion 7: Mostrar Item ");
				System.out.println("Opcion 8: Eliminar Item");
				System.out.println("Opcion 9: Añadir Zona ");
				System.out.println("Opcion 10: Mostrar Zona ");
				System.out.println("Opcion 11: Añadir Personaje a la Zona");
				System.out.println("Opcion 12: Eliminar Personaje a la Zona");
				System.out.println("Opcion 13: Eliminar Zona");
				System.out.println("Opcion 14: Añadir Personaje");
				System.out.println("Opcion 15: Mostrar Personaje ");
				System.out.println("Opcion 16: Modificar los Items del Personaje");
				System.out.println("Opcion 17: Modificamos las Habilidades del Personaje");
				System.out.println("Opcion 18: Eliminar personaje");
				System.out.println("Opcion 19: Añadir Mision ");
				System.out.println("Opcion 20: Mostrar Mision ");
				System.out.println("Opcion 21: Eliminar Mision");
				System.out.println("Opcion 22: Guardar en fichero");
				System.out.println("Opcion 23: Leer fichero");
				System.out.println("Opcion 24: Leer Habilidades");
				System.out.println("Opcion 25  Leer Personajes");
				System.out.println("Opcion 26  Guardar en la Base de Datos");
				System.out.println("Opcion 0: Salir");
				opcion= teclado.nextInt();
				teclado.nextLine();
				
				switch (opcion)
				{
					case 1:
						anyadirHabilidad();
						break;
					case 2:
						mostrarHabilidades();
						break;
					case 3:
						eliminarHabilidad();
						break;
					case 4:
						anyadirItem();
						break;
					case 5:
						asigHabItem();
						break;
					case 6:
						eliminarHabItem();
						break;
					case 7:
						mostrarItems();
						break;
					case 8:
						eliminarItem();
						break;
					case 9:
						anyadirZona();
						break;
					case 10:
						mostrarZonas();
						break;
					case 11:
						addPersonajeAZona();
						break;
					case 12:
						eliminarPersonajeAZona();
						break;
					case 13:
						eliminarZona();
						break;
					case 14:
						anyadirPersonaje();
						break;
					case 15:
						mostrarPersonajes();
						break;
					case 16:
						modEquipo();
						break;
					case 17:
						modHabPer();
						break;
					case 18:
						eliminarPersonaje();
						break;
					case 19:
						anyadirMision();
						break;
					case 20:
						mostrarMisiones();
						break;
					case 21:
						eliminarMision();
						break;
					case 22:
						guardarEnFichero();
						break;
					case 23:
						leerDeFichero();
						break;
					case 24:
						LeerBDHabilidades();
						break;
					case 25:
						LeerBDPersonaje();
						break;
					case 26:
						Insertar();
						break;
					case 0:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("No es una opción admitida");
						break;
						
						
				}
			}while(opcion!=0);
		}
		
	//-------------------------------------------------------------------------------------------------------------------//
	// ---------------------------                       FUNCIONES                    -----------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//
	
	// ----------------------                           FICHEROS                    ----------------------------------//

	
			
			public void leerDeFichero()
			{	//Habilidades
				File archivo;
				FileReader fr;
			    BufferedReader br;
			    String linea;
			    //Personajes
			    File archivopj;
				FileReader frpj;
			    BufferedReader brpj;
			    String lineapj;
			    
			   //ponemos los arrays vacíos
			   habilidades.clear();
			   items.clear();
			   personajes.clear();
			   for(int i=0;i<50;i++) {
				   zonas[i]=null;
				   misiones[i]=null;
				   
			   }
			    numhab = 0;
				numitem = 0;
				numpj = 0;
				nummision = 0;
				numzona = 0;
			      try {
			    	  
			    	  //-------------------Hab------------------------------
			         // Apertura del fichero y creacion de BufferedReader
			         archivo = new File ("C:\\DAM\\habilidades.txt");
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);

			         // Lectura del fichero
			         
			         while((linea=br.readLine())!=null) {
			        	 //con el split separmos las habilidades , indicando que el separador es el ;
			         	String []datos = linea.split(";");
			         	
			         	if(datos.length > 1 && datos !=null ) {
				         	String Nombre = datos[0];//posicion 0 será el nombre
				         	int vida = Integer.parseInt(datos[1]); //posición 1 sera la vida
				         	int energia = Integer.parseInt(datos[2]);//posición 2 sera la energía
				         	String tipo = datos[3];//posición 3 será el tipo
				         	
				         	Habilidad aux = new Habilidad(Nombre, vida, energia,tipo);
			         	anyadirHabilidad(aux);
			         	}
			         }
			         
			         //-----------------PJ------------------------
			         
			         // Apertura del fichero y creacion de BufferedReader
			         archivopj = new File ("C:\\DAM\\personajes.txt");
			         frpj = new FileReader (archivopj);
			         brpj = new BufferedReader(frpj);
			         
			         while((lineapj=brpj.readLine())!=null) {
			        	 //separamos pj mediante ; 
				         	String []datospj = lineapj.split(";");
				         	
				         	if(datospj.length > 1 && datospj !=null ) {
				         		//damos valor a cada campo
					         	String Nombre = datospj[0];
					         	String Clase = datospj[1];
					         	int vida_max = Integer.parseInt(datospj[2]);
					         	int energia_max = Integer.parseInt(datospj[3]);
					         	int vida_actual = Integer.parseInt(datospj[4]);
					         	int energia_actual = Integer.parseInt(datospj[5]);
					         	int monedas = Integer.parseInt(datospj[6]);
					         	boolean npc = Boolean.parseBoolean(datospj[7]);
					         	boolean hostil = Boolean.parseBoolean(datospj[8]);
					         	Habilidad aux[] = new Habilidad[5];
					         	Item itemaux[] = new Item[5];
					         
					         	
					         	Personaje auxpj = new Personaje(Nombre, Clase,vida_max, energia_max,vida_actual,energia_actual,monedas,aux,itemaux,npc,hostil);
					         	anyadirPersonaje(auxpj);
					         	
					         	if(datospj.length>9) {
					         		//separamos las habilidades del pj mediante ,
									String habpj[] = datospj[9].split(",");
						         	for(int i= 0;i<habpj.length;i++) {
						         		String Nombrehab = habpj[i];
						         		Habilidad auxhabi = new Habilidad(Nombrehab,0,0,"");
						         		modHabPer(auxpj,auxhabi,true);
						         	}

					         	}
					         }
				         }
			         
			      }
			      catch(Exception e){ 
			         e.printStackTrace();
			      }	      
			}
			
		
		public void guardarEnFichero() {
		
			FileWriter habilidadestxt;
			FileWriter personajestxt;
			
			try {
				//Guardar Fichero en 
				habilidadestxt = new FileWriter("C:\\DAM\\habilidades.txt",false);
				BufferedWriter out = new BufferedWriter(habilidadestxt);
				
				personajestxt = new FileWriter("C:\\DAM\\personajes.txt",false);
				BufferedWriter outp = new BufferedWriter(personajestxt);
				
				
				
				out.close();
				habilidadestxt.close();
				outp.close();
				personajestxt.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				
			}
			
		}
		public void Insertar() {
			try {
				//Creamos la conexión con la base de datos
				Connection conexion;

	            String basedatos = "videojuego";
	            String host = "localhost";
	            String port = "3306";
	            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	            String user = "dennis";
	            String pwd = "Huayllas1";

	            conexion = DriverManager.getConnection(urlConnection, user, pwd);

	            // Hace commit automaticamente
	            conexion.setAutoCommit(true);
	            
	            // Inserto un personaje
	            

	            Statement sentencia=conexion.createStatement();
	            String nombre="";
	            int vida =0;
	            int energia =0;
	            String tipo = "";
	            ResultSet rs = sentencia.executeQuery("SELECT id_habilidad FROM habilidades ORDER BY id_habilidad DESC LIMIT 1");
	            int id=0;
	            while(rs.next()) {
	            	 id=rs.getInt("id_habilidad");
		            id++;
	            }
	            
	            for(int i=0; i<habilidades.size();i++) {
	        	   
	        	  nombre = habilidades.get(i).getNombre();
	        	  vida = habilidades.get(i).getVida();
	        	  energia = habilidades.get(i).getEnergia();
	        	  tipo = habilidades.get(i).getTipo();
	        	  sentencia.executeUpdate("INSERT INTO habilidades (id_habilidad,nombrehab,energia,vida,tipo) VALUES("+id+",'"+ nombre +"'," + vida + ","+ energia +",'"+tipo+"')");
	        	  id++;
	        	  
	           }
	           Statement sentenciaPersonaje=conexion.createStatement();
	           String nombrePj="";
	           String clasePj="";
	           int vida_Max=0;
	           int vida_Actual=0;
	           int energia_Max=0;
	           int energia_Actual=0;
	           int monedas=0;
	           boolean hostil=false;
	           boolean npc=false;
	           
	           ResultSet rsPj = sentencia.executeQuery("SELECT id_personaje FROM personajes ORDER BY id_personaje DESC LIMIT 1");
	            int idPj=0;
	            while(rsPj.next()) {
	            	 idPj=rsPj.getInt("id_personaje");
		            idPj++;
	            }
	            for(int i=0;i<personajes.size();i++) {
	            	
	            	nombrePj=personajes.get(i).getNombre();
	            	clasePj=personajes.get(i).getClase();
	            	vida_Max=personajes.get(i).getVida_max();
	            	vida_Actual=personajes.get(i).getVida_actual();
	            	energia_Max=personajes.get(i).getEnergia_max();
	            	energia_Actual=personajes.get(i).getEnergia_actual();
	            	monedas=personajes.get(i).getMonedas();
	            	hostil=personajes.get(i).isHostil();
	            	npc=personajes.get(i).isNpc();	    
	            	sentenciaPersonaje.executeUpdate("INSERT INTO personajes(id_personaje,nombre,clase,vida_max,vida_actual,energia_max,energia_actual,monedas,hostil,npc)"+
	            	"VALUES("+idPj+",'"+nombrePj+"','"+clasePj+"',"+vida_Max+","+vida_Actual+","+energia_Max+","+energia_Actual+","+monedas+","+hostil+","+npc+")");
	            	idPj++;
	            }
	          

	            // Cierro todo
	            sentencia.close();
	            sentenciaPersonaje.close();
	            conexion.close();

	            
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
		}
		
		public void LeerBDHabilidades() {
			try {
	            Connection conexion;

	            String basedatos = "videojuego";
	            String host = "localhost";
	            String port = "3306";
	            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	            String user = "dennis";
	            String pwd = "Huayllas1";

	            conexion = DriverManager.getConnection(urlConnection, user, pwd);

	            // Hace commit automaticamente
	            conexion.setAutoCommit(true);

	            // Creo la sentencia
	            Statement sentencia = conexion.createStatement();

	            // Formo el SQL
	            String SQL = "";
	            SQL += "SELECT h.id_habilidad, h.nombrehab, h.energia, h.vida, h.tipo ";
	            SQL += "FROM habilidades h";
	          
	            
	            // Ejecuto el SQL y devuelvo los datos
	            ResultSet rs = sentencia.executeQuery(SQL);

	            // Recorro los datos
	            while (rs.next()) {

	                // Obtengo y muestro los datos de cada atributo
	            	System.out.println("|||||||||||||||||||Habilidades "+ rs.getInt("id_habilidad")+"|||||||||||||||||||");
	                System.out.println("Nombre:" + rs.getString("nombrehab"));
	                System.out.println("Energia:" + rs.getString("energia"));
	                System.out.println("Vida:" + rs.getString("vida"));
	                System.out.println("Tipo:" + rs.getString("tipo"));
	                System.out.println("");
	            }

	            // Cierro el resultset, la sentencia y la conexion
	            rs.close();
	            sentencia.close();
	            conexion.close();

	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
		
		public void LeerBDPersonaje() {
			try {
	            Connection conexion;

	            String basedatos = "videojuego";
	            String host = "localhost";
	            String port = "3306";
	            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	            String user = "dennis";
	            String pwd = "Huayllas1";

	            conexion = DriverManager.getConnection(urlConnection, user, pwd);

	            // Hace commit automaticamente
	            conexion.setAutoCommit(true);

	            // Creo la sentencia
	            Statement sentencia = conexion.createStatement();

	            // Formo el SQL
	            String SQL = "";
	            SQL += "SELECT p.id_personaje,p.nombre, p.clase, p.vida_max, p.vida_actual,p.energia_max,p.energia_actual,p.monedas,p.hostil,p.npc ";
	            SQL += "FROM personajes p";
	          
	            
	            // Ejecuto el SQL y devuelvo los datos
	            ResultSet rs = sentencia.executeQuery(SQL);
	            
	            // Recorro los datos
	            while (rs.next()) {

	                // Obtengo y muestro los datos de cada atributo
	            	System.out.println("|||||||||||||||||||Personajes "+ rs.getInt("id_personaje")+"|||||||||||||||||||");
	                System.out.println("Nombre:" + rs.getString("nombre"));
	                System.out.println("Clase:" + rs.getString("clase"));
	                System.out.println("Vida Maxima:" + rs.getInt("vida_max"));
	                System.out.println("Vida Actual:" + rs.getInt("vida_actual"));
	                System.out.println("Energia Maxima:" + rs.getInt("energia_max"));
	                System.out.println("Enrgia Actual:" + rs.getInt("energia_actual"));
	                System.out.println("Monedas" + rs.getInt("monedas"));
	                 if(rs.getInt("hostil")==1) {
	                	 
	                	  System.out.println("El personaje es hostil");
	                	 
	                 }else {
	                	 System.out.println("El personaje no es hostil");
	                	 
	                 }
	                 
	                 if(rs.getInt("npc")==1) {
	                	 
	                	  System.out.println("El personaje un NPC");
	                	 
	                 }else {
	                	 System.out.println("El personaje no es un NPC");
	                	 
	                 }
	                
	                System.out.println("");
	            }

	            // Cierro el resultset, la sentencia y la conexion
	            rs.close();
	            sentencia.close();
	            conexion.close();

	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }

		}
	// ----------------------                           HABILIDADES                    ----------------------------------//
		
		// AÑADIR una nueva Habilidad
		
		public boolean anyadirHabilidad()
		{
			boolean salida=false;
			//Pedimos los datos por consola
			System.out.println("Introduce el nombre de la habilidad");
			String nombre = teclado.nextLine();
			System.out.println("Introduce la vida");
			int vida = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce la energía");
			int energia = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce el tipo de la habilidad");
			String tipo = teclado.nextLine();
			
			//Creamos un array auxiliar para guardar los valores pedidos
			Habilidad aux = new Habilidad(nombre, vida, energia, tipo);
			salida = anyadirHabilidad(aux);	 //Igualamos la salida a la función de anyadirHab
			return salida;
		}
		
			public boolean anyadirHabilidad(Habilidad aux) {
			
				boolean encontrado = false;
				boolean salida = false;
				//recorremos el array de habilidades
				for(int i=0;i<habilidades.size();i++)
				{
					//Comprobamos si en el array de habilidades es diferente de nulo y es igual que la habilidad 
					//Ponemos la variable a encontrado y salimos del bucle
					if(habilidades.get(i)!=null && habilidades.get(i).esIgual(aux))
					{
						encontrado = true;
						i=habilidades.size();//salimos del bucle
					}
				}
				
				if(!encontrado)//Si no se ha encontrado añadimos la habilidad y hacemos numhab++
				{
						habilidades.add(aux);//Añadimos
						numhab++;//Aumentamos el numero de habilidades 
						salida =true;
					
					
				}
				
				
				
				
			return salida;
		}
		
		// MOSTRAR habilidades
		public void mostrarHabilidades()
		{
			//recorremos el array de habilidades del gestor
			for(int i =0; i<habilidades.size(); i++)
			{	
				//comprobamos que las posiciones sean diferentes de nulo
				if(habilidades.get(i) != null) {
					habilidades.get(i).visualizar();//visualizamos
				}
			}
		}
		
		//ASIGNAR HABILIDAD A ITEM
		
		public boolean asigHabItem() {
			boolean salida = false;
			//Preguntamos la posición del item al que le vamos a asignar la habildad
			System.out.println("Introduce la posicion del Item al que vamos a asignar una habilidad.");
			mostrarItems();
			//Guardamos la posición
			int pos = teclado.nextInt();
			teclado.nextLine();
			//Si la posición es diferente de -1 (osea que no existe) y menor que numitem (el numero de items generados) 
			if(pos>-1 && pos<numitem)
			{
				//Si el item introducido existe mostramos las habilidades
				System.out.println("Elige la habilidad a introducir");
				mostrarHabilidades();
				String nombrehabilidad = teclado.nextLine();//guardamos el nombre
				Habilidad auxhab = new Habilidad(nombrehabilidad,0,0,"");//Creamos un array aux con ese nombre
				
				int poshab = habilidades.indexOf(auxhab);//Buscamos la posición de la habilidad
				//Si la posición existe y es menor que el numero de habilidades creadas 
				if(poshab != -1 && poshab < numhab) {
					//igualamos salida a la funcion de asignar habilidad en item.
					//le pasamos la posición de la habilidad y la posicion del item a introducir
					salida = asigHabItem(habilidades.get(poshab),items.get(pos));
				}else {
					System.out.println("Posición no encontrada");
				}
			}
			return salida;
		
		}
		
		//Asignar habilidadItem pasando los parametros
		public boolean asigHabItem(Habilidad aux,Item itemaux ) {
			boolean salida = false;
			int pos = items.indexOf(itemaux);//obtenemos la posición de nuestro item
			if(pos != -1) {
				int poshab = habilidades.indexOf(aux);//obtenemos la posición de nuestra habilidad
				if(poshab!= -1) {
					//Creamos un array auxiliar con las habilidades de ese item
					Habilidad habitems[] = items.get(pos).getAccion();
					int poshabitem = obtenerPosHabEnItem(aux,habitems);
					//si el item existe
					if(poshabitem ==-1) {
						for(int i=0;i<habitems.length;i++) {//recorremos las habilidades
							if(habitems[i]==null) {//Si la posición es igual a nulo
								habitems[i] = habilidades.get(poshab);//Añadimos la habilidad
								i=habitems.length; //salimos del bucle
								salida=true;
							}
						}
					}else {
						//error no insertamos hab
					}
				}
			}
			
			return salida;
		}
		//Obtener posición de una habilidad en un item
		public int obtenerPosHabEnItem(Habilidad aux,Habilidad[] aux2) {
			int salida = -1;
			
				for(int i=0;i<aux2.length;i++) {//recorremos aux 2
					//si es diferente de null y igual a la habilidad pasada a la funcion
					if(aux2[i] != null && aux2[i].esIgual(aux) ) {
						//La salida es igual a la posición de la habilidad en items
						salida=i;
					}
				}
			return salida;
		}
		//ELIMINAR
		
		public boolean eliminarHabilidad() {
			boolean salida = false;
			//Pedimos el nombre de la habilidad
			System.out.println("Introduce el nombre de la habilidad a eliminar.");
			mostrarHabilidades();
			String nombrehabilidad = teclado.nextLine();
			//creamos un array auxiliar con el nombre de esa habilidad
			Habilidad auxhab = new Habilidad(nombrehabilidad,0,0,"");
			int pos = habilidades.indexOf(auxhab);//obtenemos la posición de esa habilidad
			
			if(pos != -1 && pos <= numhab) {//si la posicion es diferente de -1(no existe) y menor que el numero de habilidades 
				salida = eliminarHabilidad(habilidades.get(pos));//Eliminamos
			}else {
				System.out.println("Posición no encontrada");//No eliminamos
			}
			
			
			return salida;
		}
		
		public boolean eliminarHabilidad(Habilidad aux) {
			boolean salida = false;
			int pos = habilidades.indexOf(aux);
			
			if(pos !=-1) {//si el item existe
				habilidades.remove(aux);//de habilidades eliminamos aux
				salida = true;
				numhab--;//Contador Habilidades -1
				}
				
			if(salida==false) {
				}

			return salida;	
		}
		
		//ELIMINAR HABILIDAD DE ITEM
		public boolean eliminarHabItem() {
			boolean salida = false;
			System.out.println("Introduce la posicion del Item al que vamos a eliminar una habilidad.");
			mostrarItems();
			int pos = teclado.nextInt();
			teclado.nextLine();
			//si encontramos el item
			if(pos>-1 && pos<numitem)
			{
				//pedimos la habilidad y creamos un array de habilidad con ese nombre
				System.out.println("Elige la habilidad a eliminar");
				mostrarHabilidades();
				String nombrehabilidad = teclado.nextLine();
				Habilidad auxhab = new Habilidad(nombrehabilidad,0,0,"");
				int poshab = habilidades.indexOf(auxhab);//obtenemos posición
				
				if(poshab != -1 && poshab <= numhab) {//si existe 
					
					salida = eliminarHabItem(habilidades.get(poshab),items.get(pos));
					//igualamos salida a eliminar habildiad
				}else {
				}
			}
			return salida;
		}
		
		public boolean eliminarHabItem(Habilidad aux,Item itemaux ) {
			boolean salida = false;
			int pos = items.indexOf(itemaux);//obtenemos pos item
			if(pos != -1) {//si existe
				int poshab = habilidades.indexOf(aux);//obtenemos pos hab
				if(poshab!= -1) {//si existe
					Habilidad habitems[] = items.get(pos).getAccion();//Metemos en un array las acciones de ese item
					int poshabitem = obtenerPosHabEnItem(aux,habitems);//Obtenemos la posicion de la habilidad en el item
					System.out.println(poshabitem);
					if(poshabitem >-1) {//si existe
						for(int i=poshabitem;i<habitems.length;i++) {//recorremos las acciones de ese item
							if(habitems!=null) {//mientras tenga valor
							
							for(int x=poshabitem; x<habitems.length-1 ; x++) {//reorganizamos las habilidades
								if(habitems[x]!=null) {//
									habitems[x]=habitems[x+1];
									salida=true;
									}
								}
									
							habitems[poshabitem] = null;
							i=habitems.length;
							}
						}
						
					}
				}
			}
			return salida;
		}
		
		
		
		
		
		
		
	//-----------------------------------------------------------------------------------------------------------
		
		// --------------------------                      ITEMS                    -----------------------------
		
		// AÑADIMOS un nuevo Item
		public boolean anyadirItem()
		
		{
			
			System.out.println("Añadiendo ITEM");
			boolean salida = false;
			System.out.println("Que tipo de item desea añadir,1.Arma, 2 Consumible, 3 Armadura");
			int opcion =teclado.nextInt();
			teclado.nextLine();
			
			
			switch(opcion) {
				case 1:
					System.out.println("Creando Arma");
					System.out.println("Introduce del nombre");
					String nombre = teclado.nextLine();
					System.out.println("Introduce el peso");
					int peso = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduce el valor");
					int valor = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduce el agravio");
					int agravio = teclado.nextInt();
					teclado.nextLine();
			
					
					//Creamos nuetra array aux de items
					Habilidad acciones[] = new Habilidad[10];
					int numhabenitem=0; //numero de habilidades que se han añadido al item
					
					String nombrehab;//Nombre de la habilidad que insertaremos al item
					do {
						System.out.println("Elige la habilidad a introducir");
						for(int i = 0; i<numhab;i++)
						{
							habilidades.get(i).visualizar();
						}
						System.out.println("Introduce el nombre de la habilidad, \"\" para no añadir ninguna");
						nombrehab = teclado.nextLine();
						if(!nombrehab.equals("")) 
						{
							Habilidad auxhab = new Habilidad(nombrehab,0,0,"");
							int pos = habilidades.indexOf(auxhab);
							if(pos!=-1)
							{
								acciones[numhabenitem]=habilidades.get(pos);
								numhabenitem++;
							}
						}
					}while(!nombrehab.equals("") && numhabenitem<10);
					
					// Comprobamos si la ITEM creada ya existe en el array de misiones
					Item aux = new Arma(nombre,valor,acciones, agravio,peso);
					salida = anyadirItem(aux);
					
					
				break;
				case 2:
					
					System.out.println("Creando Consumible");
					System.out.println("Introduce del nombre");
					String nombreC = teclado.nextLine();
					
					
					System.out.println("Introduce el valor");
					int valorC = teclado.nextInt();
					teclado.nextLine();
					
					System.out.println("Introduce la cantidada");
					int cantidadC = teclado.nextInt();
					teclado.nextLine();
					
					//Creamos nuetra array aux de items
					Habilidad accionesC[] = new Habilidad[10];
					int numhabenitemC=0; //numero de habilidades que se han añadido al item
					
				
					do {
						System.out.println("Elige la habilidad a introducir");
						for(int i = 0; i<numhab;i++)
						{
							habilidades.get(i).visualizar();
						}
						System.out.println("Introduce el nombre de la habilidad, \"\" para no añadir ninguna");
						nombrehab = teclado.nextLine();
						if(!nombrehab.equals("")) 
						{
							Habilidad auxhab = new Habilidad(nombrehab,0,0,"");
							int pos = habilidades.indexOf(auxhab);
							if(pos!=-1)
							{
								accionesC[numhabenitemC]=habilidades.get(pos);
								numhabenitemC++;
							}
						}
					}while(!nombrehab.equals("") && numhabenitemC<10);
					
					// Comprobamos si la ITEM creada ya existe en el array de misiones
					Item auxC = new Consumible(nombreC,valorC, accionesC,cantidadC);
					salida = anyadirItem(auxC);
					
					
					
				break;
				case 3:
					System.out.println("Creando Armadura");
					System.out.println("Introduce del nombre");
					String nombreA = teclado.nextLine();
					System.out.println("Introduce el peso");
					int pesoA = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduce el valor");
					int valorA = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Introduce el armadura");
					int armaduraA = teclado.nextInt();
					teclado.nextLine();

					
					//Creamos nuetra array aux de items
					Habilidad accionesA[] = new Habilidad[10];
					int numhabenitemA=0; //numero de habilidades que se han añadido al item
					
					
					do {
						System.out.println("Elige la habilidad a introducir");
						for(int i = 0; i<numhab;i++)
						{
							habilidades.get(i).visualizar();
						}
						System.out.println("Introduce el nombre de la habilidad, \"\" para no añadir ninguna");
						nombrehab = teclado.nextLine();
						if(!nombrehab.equals("")) 
						{
							
							Habilidad auxhab = new Habilidad(nombrehab,0,0,"");
							int pos = habilidades.indexOf(auxhab);
							if(pos!=-1)
							{
								accionesA[numhabenitemA]=habilidades.get(pos);
								numhabenitemA++;
							}
						}
					}while(!nombrehab.equals("") && numhabenitemA<10);
					
					// Comprobamos si la ITEM creada ya existe en el array de misiones
					Item auxA = new Armadura(nombreA,valorA, accionesA,armaduraA, pesoA);
					salida = anyadirItem(auxA);
					
				
				break;
				default:
					System.out.println("Has introducido una opcion incorrecta");
				break;
				
				
			}
			return salida;
			
		}
			//Añadir
			public boolean anyadirItem(Item aux) {
			boolean encontrado = false;
			boolean salida = false;
			for(int i=0;i<items.size();i++)
			{
				if(items.get(i)!=null && items.get(i).esIgual(aux))
				{
					encontrado = true;
					i=50;
				}
			}
			
			if(!encontrado)
			{	
				
					items.add(aux);
					numitem++;
					salida =true;
			}
	
			else
			{
				
			}
			
			
			
			return salida;
		}
		// MOSTRAR las características de todos nuestros Items
		public void mostrarItems()
		{
			for(int i =0; i<items.size(); i++)
			{
				if(items.get(i) !=null) {
				items.get(i).visualizar();
				}
			}
		}
		
		
		
		
		
		
		
		//ELIMINAR
		public boolean eliminarItem() {
			boolean salida = false;
			
			System.out.println("Introduce la posicion del item a eliminar");
			mostrarItems();
			int positem = teclado.nextInt();
			teclado.nextLine();
			
			if(positem !=-1 && positem<=numitem)
			{
				eliminarItem(items.get(positem));
				
			}else {
				System.out.println("El item no existe");
			}
			
			return salida;
		}
		
		public boolean eliminarItem(Item aux) {
			boolean salida = false;
			int pos = items.indexOf(aux);
			
			System.out.println(pos);
			if(pos != -1 ) {
				items.remove(aux);
				numitem--;
				
				
			}
			
			return salida;
		}
		

	//-------------------------------------------------------------------------------------------------------------------
		//---------------------------------------            ZONA            ------------------------------------------
		
		// Mostramos las características de todas las Zonas
		public void mostrarZonas()
			{
				for(int i =0; i<numzona; i++)
				{
					if(zonas[i] != null)
					zonas[i].visualizar();
				}
			}
			
		// Añadimos nueva zona
		public boolean anyadirZona()
		{
			boolean salida=false;
			
			// Damos valor a las variables
			System.out.println("Introduce el nombre de la zona");
			String nombre = teclado.nextLine();
			System.out.println("Introduce el nivel");
			int nivel = teclado.nextInt();
					teclado.nextLine();
			
			Personaje[] npcsZona = new Personaje[10];
			int numNpcsEnZona=0; //numero de npcs que se han añadido a la zona
			String nombreNpcs;
			
			do {
				System.out.println("Elige el personaje a introducir");
				for(int j = 0; j<numpj;j++)
				{
					mostrarPersonajes();
				}
				
				System.out.println("Introduce el nombre del personaje npc, \"\" para no añadir ninguna");
				nombreNpcs = teclado.nextLine();
				
					if(!nombreNpcs.equals(""))
					{
						int pos = obtenerPosNpcsEnZona(nombreNpcs);
						if(pos!=-1)
						{
							npcsZona[numNpcsEnZona]=personajes.get(pos);
							System.out.println("Personaje Introducido en la Zona.");
							numNpcsEnZona++;
						}else {
						System.out.println("EL PERSONAJE NO EXISTE.");
						}
					}
			}while(!nombreNpcs.equals("") && numNpcsEnZona<10);
			
			// Comprobamos si la ZONA creada ya existe en el array de zonas
			Zona aux = new Zona(nombre, nivel, npcsZona);
			salida= anyadirZona(aux);
			return salida;
			
			
		}
		
		//Añadir Zona pasandole una zona
				public boolean anyadirZona(Zona zonaaux) {
					boolean salida=false;
					boolean encontrado = false;
					for(int i=0;i<50;i++)
					{
						if(zonas[i]!=null && ( zonas[i].esIgual(zonaaux)))
						{
							encontrado = true;
							i=50;
						}
					}
					
					if(!encontrado)
					{
						if(numzona<50)
						{
							zonas[numzona]=zonaaux;
							numzona++;
							salida =true;
						}
						else
						{
							System.out.println("El array está lleno");
						}
					}
					else
					{
						
					}
					
					
					return salida;
				}
		
		// Comprobamos la posición de un npc en el array de npcs de la Zona
		private int obtenerPosNpcsEnZona(String nombre)
		{
			int salida = -1;
			Habilidad habilidadesaux[]  = new Habilidad[5];
			Item itemaux[] = new Item[5];
			Personaje aux = new Personaje(nombre,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
			
			for(int i = 0; i<numpj; i++)
			{
				if(personajes.get(i).esIgual(aux) && personajes.get(i) != null)
				{
					salida =i;
				}
			}
			return salida;
		}
		public boolean eliminarZona() {
			boolean salida = false;
			
			System.out.println("Introduce el nombre de una zona a eliminar.");
			mostrarZonas();
			String nomzona = teclado.nextLine();
			int pos = obtenerPosZona(nomzona);
			if (pos !=-1 && pos <=numzona) {
				salida = eliminarZona(zonas[pos]);
			}
			
			return salida;
		}
		
		public boolean eliminarZona(Zona aux) {
			boolean salida = false;
				int pos = obtenerPosZona(aux.getNombre());
				if (pos !=-1) {
					zonas[pos]=null;
					for(int i = pos; i<numzona-1;i++) {
						zonas[i] = zonas[i+1];
						
					}numzona--;
					salida=true;
				}
			return salida;
		}
		
		private int obtenerPosZona(String nombre)
		{
			int salida = -1;
			
			Personaje personajeaux[] = new Personaje[10];
			
			Zona aux = new Zona(nombre,0, personajeaux);
			
			for(int i = 0; i<numzona; i++)
			{
				if(zonas[i].esIgual(aux) && zonas[i] != null)
				{
					salida =i;
				}
			}
			return salida;
		}
		
	//-------------------------------------------------------------------------------------------------------------------
		// ----------------------------------------   PERSONAJE ---------------------------------------------------------
		
		// Mostramos las características de todos nuestros Personajes
			public void mostrarPersonajes()
			{
				for(int i =0; i<personajes.size(); i++)
				{
					personajes.get(i).visualizar();
				}
			}
			
			
		// Añadimos nuevo personaje
		public boolean anyadirPersonaje()
		{
			boolean salida=false;
			
			// Damos valor a las variables
			System.out.println("Introduce el nombre del personaje");
			String nombre = teclado.nextLine();
			System.out.println("Introduce la clase");
			String clase = teclado.nextLine();
			System.out.println("Introduce la vida máxima");
			int vida_max = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce la energía máxima");
			int energia_max = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce la vida actual");
			int vida_actual = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce la energía actual");
			int energia_actual = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduce el número de monedas");
			int monedas = teclado.nextInt();
			teclado.nextLine();
			
			// Damos valor a los arrays
			System.out.println("Introduce las habilidades del personaje");
			Habilidad habilidadesPj[] = new Habilidad[5];
			int numhabenpj=0; //numero de habilidades que se han añadido al personaje
			
			String nombrehab;
			do {
				System.out.println("Elige la habilidad a introducir");
				
					mostrarHabilidades();
				
				System.out.println("Introduce el nombre de la habilidad, \"\" para no añadir ninguna");
				nombrehab = teclado.nextLine();
				if(!nombrehab.equals(""))
				{
					int poshab = obtenerPosHabilidadEnPj(nombrehab);
					
					if(poshab!=-1)
					{
						habilidadesPj[numhabenpj]=habilidades.get(poshab);
						numhabenpj++;
						
					}
				}
			}while(!nombrehab.equals("") && numhabenpj<5);
			
			System.out.println("Introduce items (equipo) del personaje");
			Item itemsPj[] = new Item[10];
			int numitemenpj=0; //numero de items que se han añadido al personaje
			
			int positem;
			do {
				System.out.println("Elige el item a introducir");
				for(int j = 0; j<numitem;j++)
				{
					System.out.println("Nº Item" + (numitem));
					mostrarItems();
				}
				System.out.println("Introduce la posicion del item, -1 para no añadir ninguna");
				positem = teclado.nextInt();
				teclado.nextLine();
				if(positem !=-1)
				{
					int pos = obtenerPosItem(items.get(positem).getNombre(),items.get(positem).getAccion());
					if(pos!=-1)
					{
						itemsPj[numitemenpj]=items.get(pos);
						numitemenpj++;
						System.out.println(numitemenpj);
					}
				}
			}while(positem != -1 && numitem<10);
				
			// Damos valor a los booleanos
			boolean npc = false;
			System.out.println("Decide si sera un 'npc' o un personaje de Usuario (pulse 0 para npc y 1 para Usuario)");
			int opcionNpc = teclado.nextInt();
			if (opcionNpc == 0) {
				npc = true;
				System.out.println("El personaje es un npc");
			}
				else if (opcionNpc == 1) {
				npc = false;
				System.out.println("El personaje es un Usuario");
			}
			
			boolean hostil = false;
			System.out.println("Decide si sera un personaje hostil o enemigo (pulse 0 para hostil y 1 para enemigo)");
			int opcionHostil = teclado.nextInt();
			if (opcionHostil == 0) {
				hostil = true;
				System.out.println("El personaje es hostil");
			}
			else if (opcionHostil == 1) {
				hostil = false;
				System.out.println("El personaje es un enemigo");
			}
			
			// Comprobamos si el PERSONAJE creado ya existe en el array de personajes
			
			Personaje aux = new Personaje(nombre,clase,vida_max,energia_max,vida_actual,energia_actual,monedas,habilidadesPj,itemsPj,npc,hostil);
			salida = anyadirPersonaje(aux);
			return salida;
			
			
			
			
			
		}
		
		
		//Personaje que le pasamos personaje
		public boolean anyadirPersonaje(Personaje aux) {
			boolean salida=false;
			boolean encontrado = false;
			for(int i=0;i<personajes.size();i++)
			{
				if(personajes.get(i)!=null && ( personajes.get(i).esIgual(aux)))
				{
					encontrado = true;
					i=50;
				}
			}
			
			if(!encontrado)
			{
				
					personajes.add(aux);
					
					numpj++;
					salida =true;
				
				
			}
			else
			{
				
			}
			return salida;
		}
		
		// Comprobamos la posición de una habilidad en el array de habilidades del Personaje
		private int obtenerPosHabilidadEnPj(String nombre)
		{
			int salida = -1;
			Habilidad aux = new Habilidad(nombre,0,0,"");
			
			for(int i = 0; i<numhab; i++)
			{
				if(habilidades.get(i)!= null) {
					if(habilidades.get(i).esIgual(aux))
					{
						salida =i;
					}
				}
			}
			return salida;
		}
		
		private int obtenerPosHabilidadEnPj(Habilidad [] habaux, Habilidad aux)
		{
			int salida = -1;
		
			
			for(int i = 0; i<habaux.length; i++)
			{
				if(habaux[i]!= null) {
					if(habaux[i].esIgual(aux))
					{
						salida =i;
					}
				}
			}
			return salida;
		}
		private int ObtenerPosItemEnPersonaje(Item [] itemaux, Item aux) {
			int salida = -1;
			for(int i = 0; i<itemaux.length; i++)
			{
				if(itemaux[i]!= null) {
					if(itemaux[i].esIgual(aux))
					{
						salida =i;
					}
				}
			}
			return salida;
		}
		
		
			
		// Comprobamos la posición de un item en el array de items del Personaje
		private int obtenerPosItem(String nombre, Habilidad habitemaux[])
		{
			int salida = -1;
			Item aux = new Consumible(nombre,  0,habitemaux,0);
				
			for(int i = 0; i<numitem; i++)
			{
				if(items.get(i).esIgual(aux) && items.get(i)!=null)
				{
					salida =i;
				}
			}
			return salida;
		}
		
		//ELIMINAR
		public boolean eliminarPersonaje() {
			boolean salida = false;
			System.out.println("Introduce el nombre del personaje a eliminar");
			mostrarPersonajes();
			String nombrepj = teclado.nextLine();
			Habilidad habilidadesaux[]  = new Habilidad[5];
			Item itemaux[] = new Item[5];
			Personaje aux = new Personaje(nombrepj,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);

			int pos =personajes.indexOf(aux);
			if(pos != -1 && pos < numpj) {
				salida = eliminarPersonaje(personajes.get(pos));
			}
			return salida;
		}
	
		public boolean eliminarPersonaje(Personaje aux) {
			boolean salida = false;
			
			int pos = personajes.indexOf(aux);
			if(pos != -1 && pos < numpj) {
				personajes.remove(aux);
				numpj--;
				salida=true;
			}
			return salida;
			
		}
		//MODIFICAR ITEMS DE PERSONAJE 
		
			public int modEquipo() {
				int salida = -1;
				System.out.println("Introduce una acción, Añadir item '1' o Eliminar Item '2'");
				int opcion = teclado.nextInt();
				teclado.nextLine();
				if(opcion==1) {
					System.out.println("Introduce el nombre del personaje a modificar");
					mostrarPersonajes();
					String nombrepj = teclado.nextLine();
					Habilidad habilidadesaux[]  = new Habilidad[5];
					Item itemaux[] = new Item[5];
					Personaje aux = new Personaje(nombrepj,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
					int pospj = personajes.indexOf(aux);
					if( pospj !=-1){
						System.out.println("Introduce la posición del Item a añadir");
						mostrarItems();
						int positem = teclado.nextInt();
						teclado.nextLine();
						if(positem!=-1) {
							
							salida = modEquipo(personajes.get(pospj),items.get(positem),true);
						}
					}
				}if(opcion==2){
					System.out.println("Introduce el nombre del personaje a modificar");
					mostrarPersonajes();
					String nombrepj = teclado.nextLine();
					Habilidad habilidadesaux[]  = new Habilidad[5];
					Item itemaux[] = new Item[5];
					Personaje aux = new Personaje(nombrepj,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
					int pospj = personajes.indexOf(aux);
					if( pospj !=-1){
						System.out.println("Introduce la posición del Item a eliminar");
						mostrarItems();
						int positem = teclado.nextInt();
						teclado.nextLine();
						if(positem!=-1) {
							
							salida = modEquipo(personajes.get(pospj),items.get(positem),false);
						}
					}
				}
					
				
				return salida;
			}
			
			//MODIFICAREQUIPO DE PJ AÑADIR Y ELIMINAR
			public int modEquipo(Personaje auxpj, Item auxitem,boolean opcion) {
				int salida = -1;
				if(opcion==true) {
					//AÑADIR
					int pospj = personajes.indexOf(auxpj);//posicion de nuestro pj
					int numitempj = auxpj.getNumitem();//Obtenemos el número de items del pj
					if(pospj !=-1) {//si existe el pj
						 int positem = items.indexOf(auxitem);//obtenemos la posición de ese item
						 if(positem !=1) {//si existe el item
							Item[] auxequipo = auxpj.getEquipos();//Obtenemos los items de ese personaje
							int positempj = ObtenerPosItemEnPersonaje(auxequipo,auxitem);
						
							if(positempj == -1) {//si existe
								for(int x=0;x<auxequipo.length;x++) {//recorremos los equipos del personaje
									if(auxequipo[x]== null) {//si es igual a nulo
										auxequipo[x]= items.get(positem);//le asignamos ese item al pj
										numitempj++;//aumentamos el numero de items
										auxpj.setNumitem(numitempj);//le pasamos el nuevo valor 
										salida = 1;
										x=auxequipo.length;
									}
								}
								
							}
						 }
					}
				
					
				}if(opcion==false) {
					int pospj = personajes.indexOf(auxpj);//posición del personaje

					int numitempj = auxpj.getNumitem();//obtenemos numitem de pj
					if(pospj !=-1) {//si existe
						 int positem = items.indexOf(auxitem);//Obtenemos la posicion del item

						 if(positem !=-1) {//si existe
							Item[] auxequipo = auxpj.getEquipos();//cogemos sus items
							int positempj = ObtenerPosItemEnPersonaje(auxequipo,auxitem);//obtenemos la posicion del item
							if(positempj != -1) {//si existe 
								for(int x=0;x<auxequipo.length;x++) {//recorremos su array de equipos
									if(auxequipo[x]!= null && auxequipo[x] == auxitem) {//si la posición es diferente de nula e igual a la habilidad
										auxequipo[x] = null;
										for(int i = x; i<numitempj-1;i++ ) {
											auxequipo[i] = auxequipo[i+1];
											
										}
										x=auxequipo.length;
										numitempj--;
										auxpj.setNumitem(numitempj);
										salida = 1;
									}
								}
							}
						 }
					}
				}
				return salida;
				
			}
		
			//MODIFICAR HABILIDAD DE PERSONAJE
			public int modHabPer(){
				
				int salida = -1;
				System.out.println("Introduce una acción, Añadir habilidad '1' o Eliminar habilidad '2'");
				int opcion = teclado.nextInt();
				teclado.nextLine();
				if(opcion==1) {
					System.out.println("Introduce el nombre del personaje a modificar");
					mostrarPersonajes();
					String nombrepj = teclado.nextLine();
					
					Habilidad habilidadesaux[]  = new Habilidad[5];
					Item itemaux[] = new Item[5];
					Personaje aux = new Personaje(nombrepj,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
					int pospj = personajes.indexOf(aux);
					if( pospj !=-1){
						System.out.println("Introduce el nombre de la habilidad a añadir");
						mostrarHabilidades();
						String nombrehabilidad =teclado.nextLine();
						Habilidad auxhab = new Habilidad(nombrehabilidad,0,0,"");
						int poshabi = habilidades.indexOf(auxhab);
						 
						if(nombrehabilidad!="") {
							
							salida = modHabPer(personajes.get(pospj),habilidades.get(poshabi),true);
						}
					}
				}if(opcion==2){
					System.out.println("Introduce el nombre del personaje a modificar");
					mostrarPersonajes();
					String nombrepj = teclado.nextLine();
					
					Habilidad habilidadesaux[]  = new Habilidad[5];
					Item itemaux[] = new Item[5];
					Personaje aux = new Personaje(nombrepj,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
					int pospj = personajes.indexOf(aux);
					if( pospj !=-1){
						System.out.println("Introduce la posición del Item a eliminar");
						mostrarHabilidades();
						String nombrehabilidad =teclado.nextLine();
						Habilidad auxhab = new Habilidad(nombrehabilidad,0,0,"");
						int poshabi = habilidades.indexOf(auxhab);
						if(nombrehabilidad!="") {
							
							salida = modHabPer(personajes.get(pospj),habilidades.get(poshabi),false);
						}
					}
				}
				return salida;
			}
			
			//MODIFICAR HABILIDAD DE PJ PASANDO PARAMETROS 
			
			public int modHabPer(Personaje auxpj, Habilidad auxhabilidad,boolean opcion) {
				int salida = -1;
				if(opcion==true) {
					
					int pospj = personajes.indexOf(auxpj);
					int numhabi = auxpj.getNumhab();
					if(pospj !=-1) {
						 int poshabilidad = habilidades.indexOf(auxhabilidad);
						 if(poshabilidad !=-1) {
							Habilidad[] auxhab = auxpj.getHabilidades();
							int poshabpj = obtenerPosHabilidadEnPj(auxhab,auxhabilidad);
							if(poshabpj == -1) {
								for(int x=0;x<auxhab.length;x++) {
									if(auxhab[x]== null) {
										auxhab[x]= habilidades.get(poshabilidad);
										x=auxhab.length;
									}
								}numhabi++;
								auxpj.setNumhab(numhabi);
								salida = 1;
							}
						 }
					}

					
				}if(opcion==false) {

					int pospj = personajes.indexOf(auxpj);
					int numhabi = auxpj.getNumhab();
					if(pospj !=-1) {
						 int poshab = habilidades.indexOf(auxhabilidad);
						 if(poshab !=-1) {
							Habilidad[] auxhab = auxpj.getHabilidades();
							int poshabpj = obtenerPosHabilidadEnPj(auxhab,auxhabilidad);
							if(poshabpj != -1) {
								for(int x=0;x<auxhab.length;x++) {
									if(auxhab[x]!= null) {
										auxhab[x]= null;
										for(int i = poshabpj; i<numhabi-1;i++) {
											auxhab[i] = auxhab[i+1];
											
										}
									}
								}numhabi--;
								auxpj.setNumhab(numhabi);
								salida = 1;
							}
						 }
					}

				}
				return salida;
				
			}
			
			
			
			
		//añadir pj a zona
		public int addPersonajeAZona() {
			int salida = -1;
			System.out.println("Introduce la zona a la que desea introducir un personaje");
			mostrarZonas();
			String nombrezona = teclado.nextLine();
			int pos = obtenerPosZona(nombrezona);
			if(pos != -1 && pos <= numzona) {
				System.out.println("Introduce el nombre del personaje que desea añadir");
				mostrarPersonajes();
				String nombrepersonaje = teclado.nextLine();
				Habilidad habilidadesaux[]  = new Habilidad[5];
				Item itemaux[] = new Item[5];
				Personaje aux = new Personaje(nombrepersonaje,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
				int pospj = personajes.indexOf(aux);
				if(pospj != -1 && pospj < numpj) {
					salida = addPersonajeAZona(personajes.get(pospj),zonas[pos] );
				}
				
			}
			return salida;
			
		}
		
		public int addPersonajeAZona(Personaje auxpj,Zona auxzona ) {
			int salida = -1;
			boolean encontrado = false;
			
			Personaje pjaux[] = auxzona.getNpcs();
			String nombrezona = auxzona.getNombre();
			int numpjzona = auxzona.getNumpj();
			
			int poszona = obtenerPosZona(nombrezona);
			if(poszona !=-1 && poszona <= numzona) {
				
				int pospj = personajes.indexOf(auxpj);
				if(pospj != -1 && pospj <= numpjzona) {
					for(int i =0; i<numpjzona;i++) {
						if(pjaux[i] != null && pjaux[i].esIgual(auxpj)){
							encontrado=true;
						}
					}
					if(encontrado == false && numpjzona <10) {
						for(int x = 0 ; x<pjaux.length;x++) {
							if(pjaux[x] == null) {
								pjaux[x] = personajes.get(pospj);
								x= pjaux.length;
								numpj++;
								salida=1;
							}
						}
					}
				}
			}
			
			
			return salida;
		}
		
		//ELIMINAR PERSONAJE DE ZONA
		public int eliminarPersonajeAZona() {
			int salida = -1;
			System.out.println("Introduce la zona que desea eliminar un pj.");
			mostrarZonas();
			String nombrezona = teclado.nextLine();
			int pos = obtenerPosZona(nombrezona);
			if(pos != -1 && pos <= numzona) {
				System.out.println("Introduce el nombre del personaje que desea eliminar");
				mostrarPersonajes();
				String nombrepersonaje = teclado.nextLine();
				Habilidad habilidadesaux[]  = new Habilidad[5];
				Item itemaux[] = new Item[5];
				Personaje aux = new Personaje(nombrepersonaje,"0", 0,0, 0,0, 0, habilidadesaux, itemaux, false, false);
				int pospj = personajes.indexOf(aux);
				if(pospj != -1 && pospj < numpj) {
					salida = eliminarPersonajeAZona(personajes.get(pospj), zonas[pos]);
				}
			}	
			return salida;
		}
		
		public int eliminarPersonajeAZona(Personaje auxpj,Zona auxzona ) {
			int salida = -1;
			
			Personaje pjaux[] = auxzona.getNpcs();
			String nombrezona = auxzona.getNombre();
			int numpjzona = auxzona.getNumpj();
			
			int poszona = obtenerPosZona(nombrezona);
			if(poszona !=-1 && poszona <= numzona) {
				
				int pospj = personajes.indexOf(auxpj);
				if(pospj != -1 && pospj <= numpjzona) {
					for(int i =0; i<numpjzona;i++) {
						if(pjaux[i] != null && pjaux[i].esIgual(auxpj)){
							pjaux[i] = null;
							numpjzona--;
							for (int x=i; x<=numpjzona-1;x++) {
								pjaux[i] = pjaux[i+1];
								salida=1;
							}
						}
					}
					
				}
			}
			
			
			return salida;
		}
		
	//-------------------------------------------------------------------------------------------------------------------
		// MISIÓN
		
		// Mostramos las características de todas las Misiones
		public void mostrarMisiones()
			{
				for(int i =0; i<nummision; i++)
				{
					if(misiones[i] != null)
					misiones[i].visualizar();
				}
			}
			
		// Añadimos nueva misión
		public boolean anyadirMision() {
	    	
	    	boolean salida=false;
	    		    	
	    	System.out.println("Introduce nombre de la Mision");
			String nombre = teclado.nextLine();
			System.out.println("Introduce el nivel de la Mision");
			int nivel = teclado.nextInt();
			teclado.nextLine();
			
			Personaje objetivo= new Personaje();
			Item recompensa =  null;
			Zona zonamision =new Zona();
	    	
			int objetivomision=0;
			int recompensamision=0;
			int zonam=0;
			
			String nombreobjetivo;
			int posicionrecompensa;
			String nombrezona;
			do {
				System.out.println("Elige el objetivo de la mision ");
				for(int i = 0; i<numpj;i++)
				{
					personajes.get(i).visualizar();
				}
				System.out.println("Introduce el nombre del objetivo , \"\" para un objetivo por defecto");
				nombreobjetivo = teclado.nextLine();
				if(!nombreobjetivo.equals(""))
				{
					int pos = personajes.indexOf(objetivo);
					if(pos==-1)
					{
						System.out.println("!ERROR EL PERSONAJE NO EXISTE¡");
						System.out.println("");
					}
					if(pos!=-1)
					{
						objetivo=personajes.get(pos);
						objetivomision++;
					}
					
					
				}
			
		
		}while(!nombreobjetivo.equals("") && objetivomision<1);
			
			do {
				System.out.println("Elige la recompensa de la mision ");
				for(int i = 0; i<numitem;i++)
				{
					System.out.println("Posicion: " + i);
					items.get(i).visualizar();
				}
				System.out.println("Introduce posicion de la recompensa, o-1 para una recompensa por defecto");
				posicionrecompensa = teclado.nextInt();
				teclado.nextLine();
				
				if(posicionrecompensa <=numitem) {
					
					if(posicionrecompensa!=-1)
					{
						recompensa= items.get(posicionrecompensa);
						recompensamision++;
					}
					
					
				}else {
					System.out.println("Posicion del item no encontrada. Error!");
				}
			
			
		
		}while(posicionrecompensa == -1 && objetivomision<1);
			
			do {
				System.out.println("Elige la zona de la mision ");
				for(int i = 0; i<numzona;i++)
				{
					
					zonas[i].visualizar();
				}
				System.out.println("Introduce el nombre de la recompensa \"\" para una zona por defecto ");
				nombrezona = teclado.nextLine();
				if(!nombrezona.equals(""))
				{
					int pos = obtenerPosZona(nombrezona);
					if(pos==-1)
					{
						System.out.println("!ERROR LA ZONA NO EXISTE¡");
						System.out.println("");
					}
					if(pos!=-1)
					{
						zonamision=zonas[pos];
						zonam++;
					}	
				}
			
		}while(!nombreobjetivo.equals("") && objetivomision<1);
			System.out.println("Introduce la cantidad de monedas ");
			int monedas = teclado.nextInt();
			teclado.nextLine();
			
	    	Mision aux = new Mision(nombre,nivel,objetivo,zonamision,recompensa,monedas);
	    	salida=anyadirMision(aux);
	    	
	    	return salida;
	    }
	
	public boolean anyadirMision(Mision mision) {
		
		boolean salida=false;
		
		boolean encontrado = false;
		for(int i=0;i<50;i++)
		{
			if(misiones[i]!=null && misiones[i].esIgual(mision))
			{
				encontrado =true;
				i=50;
			}
		}
		if(!encontrado)
		{
			if(nummision<50)
			{
				misiones[nummision]=mision;
	    		nummision++;
				salida =true;
			}
			else
			{
				System.out.println("El array esta lleno");
			}
		}
		else
		{
			System.out.println("Error ya existe");
		}
	
    	return salida;
		
	}
	//ELIMINAR MISION
	public boolean eliminarMision() {
		boolean salida = false;
		System.out.println("Introduce el nombre de la mision a eliminar.");
		String nombrezona = teclado.nextLine();
		int pos = obtenerPosMision(nombrezona);
		if(pos != -1 && pos <=nummision) {
			salida = eliminarMision(misiones[pos]);
		}
		return salida;
	}
	
	public boolean eliminarMision(Mision aux) {
		boolean salida = false;
		String nombrezona = aux.getNombre();
		int pos = obtenerPosMision(nombrezona);
		if(pos != -1 && pos < nummision) {
			misiones[pos] = null;
			for(int i = pos; i<nummision-1;i++) {
				misiones[i] = misiones[i+1];
			}nummision--;
			salida= true;
		}
		return salida;
	}
	
	//OBTENER POS
	private int obtenerPosMision(String nombre)
	{
		int salida = -1;
		
		Personaje personajeaux = new Personaje();
		Item itemaux = null;
		Zona auxzona = new Zona();
		
		Mision aux = new Mision(nombre,0 ,personajeaux ,auxzona ,itemaux ,0 );
		
		for(int i = 0; i<nummision; i++)
		{
			if(misiones[i].esIgual(aux))
			{
				salida =i;
			}
		}
		return salida;
	}

}
