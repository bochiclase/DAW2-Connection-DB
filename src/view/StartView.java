package view; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Iterator;

import modelo.cines.CinesCreate;
import modelo.cines.CinesDelete;
import negocio.beans.CineBean;
import negocio.controlador.Cinesa;
import view.cines.ModificarCineView;

public class StartView {

	private Cinesa cines;
	
	private InputStreamReader isr = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader (isr);
	
	
	public StartView(Cinesa cines) {
		
		this.cines = cines;
	}
	
	
	 
	
	
	public void go() throws NumberFormatException, IOException {
		
		
		  
		int numero = 1000;
		
		while(numero!=0) {
			
			System.out.println("\n\n\n\nMenu");
			System.out.println("_____________________");
			System.out.println("1) Lista de Cines");
			System.out.println("2) Agregar Cines");
			System.out.println("3) Modificar Cine");
			System.out.println("4) Borrar Cines");
			System.out.println("\n");
			System.out.println("0) SALIR");
			numero = Integer.parseInt (br.readLine());
			
			switch(numero) {
			
				case 1: listarCines(); break;
				case 2: agregarCines(); break;
				case 3: modificarCine(); break;
				case 4: borrarCines(); break;
			}
		}
	}
	
	
	
	
	
	/**
	 * Lista los cines disponibles
	 * PRIVADO
	 */
	private void listarCines() {
		
		Iterator<CineBean> listado =  cines.getCines();
		while(listado.hasNext()) {
			
			CineBean unCine = listado.next();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
	}



	
	/**
	 * Modifica un cine
	 * PRIVADO
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void modificarCine() throws NumberFormatException, IOException {
		
		// recorro la lista de cines imprimiendo lo que hay		
		Iterator<CineBean> listado =  cines.getCines();
		while(listado.hasNext()) {
			
			CineBean unCine = listado.next();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
		
		// solicito un ID
		System.out.println("Seleccione el ID del cine que quiere modificar");
		int numero = Integer.parseInt (br.readLine());
		
		// recojo el cine se lo paso a la parte de la view que lo modifica
		CineBean unCine = cines.getCine(numero);
		ModificarCineView.modificarCine(unCine);
		
		
	}
	
	/**
	 * Pido los datos por teclado y llamo a la funcion para agregar cines
	 */
	
	 public void agregarCines() throws IOException {
		 CineBean cine = new CineBean();
		 System.out.println("Introduce una clave para el Cine");
		 cine.setIdCine(Integer.parseInt(br.readLine()));
		 
		 System.out.println("Introduce el Nombre del Cine");
		 cine.setNombre(br.readLine());
		 
		 System.out.println("Introduce un Responsable ");
		 cine.setResponsable(br.readLine());
		 
		 System.out.println("Introduce el Teléfono del Cine");
		 cine.setTelefono(br.readLine());
		 
		 System.out.println("Introduce una Dirección");
		 cine.setDireccion(br.readLine());
		 
		 CinesCreate guardarCine = new CinesCreate();
		 guardarCine.createCine(cine);
	 }
	 
	 
	 
	 public void borrarCines() throws NumberFormatException, IOException {
		 Iterator<CineBean> listado =  cines.getCines();
			while(listado.hasNext()) {
				
				CineBean unCine = listado.next();
				System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
			}
			CinesDelete borrarCine = new CinesDelete();
			System.out.println("Indica el numero de Cine que deseas borrar");
			borrarCine.deleteCine(Integer.parseInt(br.readLine()));
	 }
	
}
