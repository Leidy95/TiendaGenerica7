package controlador;

import java.util.Scanner;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
	
	public static void Controller() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Vista view = new Vista();
		UsuarioDAO ud = new UsuarioDAO();
		Modelo mod = new Modelo();
		int opc = Integer.MAX_VALUE;
		Vista uV = new Vista();
				
				
		while (opc !=5) {
			view.menu();
			System.out.println("Por favor ingrese una Opcion: ");
			
				do {
					try {
						opc = scan.nextInt();
					}catch (Exception e){
						System.out.println("Digite un numero Valido");
						scan.nextLine();
						
					}
				}while (opc == Integer.MAX_VALUE);
				
				switch (opc) {
					case 1: 
						System.out.println("-----------------------------------");
						System.out.println("-----INSERTAR UN NUEVO USUARIO-----");
						System.out.println("-----------------------------------");
						System.out.println("Escriba la cedula del Usuario: ");
						mod.setCedula_usuario(scan.nextInt());
						scan.nextLine();
						System.out.println("Escriba el Email del Usuario: ");
						mod.setEmail_usuario(scan.next());
						scan.nextLine();						
						System.out.println("Escriba Nombre de usuario: ");
						mod.setNombre_usuario(scan.next());
						scan.nextLine();
						System.out.println("Escriba el password del usuario: ");
						mod.setPassword(scan.nextLine());										
						System.out.println("Escriba el NickName del Usuario: ");
						mod.setUsuario(scan.nextLine());										
						ud.insert(mod);
						break;
						
					case 2:
						System.out.println("-----------------------------------");
						System.out.println("----------TABLA USUARIOS-----------");
						System.out.println("-----------------------------------");						
						uV.usuariosView();
						break;
						
					case 3:
						System.out.println("-----------------------------------");
						System.out.println("--------ACTUALIZAR USUARIO---------");
						System.out.println("-----------------------------------");
						mod = new Modelo();
						uV.usuariosView();
						
						System.out.println("***********************************");
						System.out.println("   Escriba la cedula del usuario   ");
						System.out.println("***********************************");
						mod.setCedula_usuario(Integer.MAX_VALUE);
						while (mod.getCedula_usuario()== Integer.MAX_VALUE) {
							
							try {
							opc = scan.nextInt();
							mod.setCedula_usuario(opc);
							}catch (Exception e) {
								System.out.println("Digite un Numero Valido");
								scan.nextLine();
								}
						}
						scan.nextLine();
						System.out.println("Digite un Nuevo Email de Usuario");
						mod.setEmail_usuario(scan.next());
						scan.nextLine();
						System.out.println("Digite un Nuevo Nombre de usuario");
						mod.setNombre_usuario(scan.next());
						scan.nextLine();
						System.out.println("Digite un nuevo Password");
						mod.setPassword(scan.next());
						scan.nextLine();
						System.out.println("Digite un Nuevo NickName");
						mod.setUsuario(scan.next());
						scan.nextLine();
						ud.update(mod);
						break;
					
					case 4:
						System.out.println("-----------------------------------");
						System.out.println("---------ELIMINAR USUARIO----------");
						System.out.println("-----------------------------------");
						uV.usuariosView();
						
						System.out.println("****************************************");
						System.out.println("Escriba la cedula del usuario a eliminar");
						System.out.println("****************************************");
						ud.delete(scan.nextInt());
						break;							
						
					case 5:
						System.out.println("===================================");
						System.out.println("       GRACIAS, VUELVA PRONTO      ");
						System.out.println("===================================");
						
				}
				
							
			}
			
		}
		
}
	

