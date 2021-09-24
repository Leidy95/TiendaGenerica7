package main;

import controlador.Consultas;
import controlador.Controlador;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		Consultas con = new Consultas();
		System.out.println(con.autenticacion("bogota21","097624354"));
		
		//Controlador.Controller();
		        
	}
	
	
}
