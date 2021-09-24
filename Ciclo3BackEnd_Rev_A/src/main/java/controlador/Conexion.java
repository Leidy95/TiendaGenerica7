package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private String user = "root";
	private String password = "Fercho0071";
	private String url = "jdbc:mysql://localhost/tiendagenerica07";
	private Connection con = null;
	
	public Connection getConexion () {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			try {
				con =DriverManager.getConnection(url,user,password);
				//System.out.println("Conexion Exitosa");
				
			} catch (SQLException e) {
				//System.out.println("Fallo Conexion");
				e.printStackTrace();
			}
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Sin Acceso al Driver");
		}
		
		return con;
		
		
	}
	
	public void desconectar () {
		
		try {
			con.close();
			//System.out.println("Base de Datos desconectada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al desconectar base de datos");
		}
	}

}
