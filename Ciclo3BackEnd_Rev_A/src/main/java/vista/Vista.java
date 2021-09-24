package vista;

import modelo.Modelo;

import java.util.LinkedList;
import java.util.List;

import controlador.UsuarioDAO;

public class Vista {
	
	public void menu () {
		
		System.out.println("*=====================================*");
		System.out.println("*----------------MENU-----------------*");
		System.out.println("*=====================================*");
		System.out.println("*         1. Crear Usuario            *");
		System.out.println("*         2. Ver Usuarios             *");
		System.out.println("*         3. Actualizar Usuario       *");
		System.out.println("*         4. Borrar Usuario           *");
		System.out.println("*         5. Salir                    *");
		System.out.println("*=====================================*");
		
		
	}

	public void usuariosView(){
		
		UsuarioDAO ud = new UsuarioDAO();
		List <Modelo> l = new LinkedList<Modelo>();
		l = ud.selectAll();
		System.out.println("=============================================================================================");
		System.out.println("CEDULA USUARIO" + "\t" + "EMAIL DE USUARIO" + "\t" + "NOMBRE" + "\t" + "\t" + "PASSWORD" + "\t" +"NICKNAME");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Modelo mod1 : l) {
			System.out.println(mod1.getCedula_usuario() + "\t" + mod1.getEmail_usuario() + "\t" + mod1.getNombre_usuario() + "\t" + mod1.getPassword()+ "\t" + mod1.getUsuario());
		}
		System.out.println("==============================================================================================");
		
	}
}
