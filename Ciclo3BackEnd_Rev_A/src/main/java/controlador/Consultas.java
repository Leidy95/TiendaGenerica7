package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Modelo;

public class Consultas extends Conexion {
	
	Conexion con = new Conexion();
	Modelo mod = new Modelo();
	
	public Boolean autenticacion(String usuario, String password){
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String consulta = "SELECT * FROM usuarios U WHERE U.usuario = ? AND U.password = ?";
		try {
			
			ps = getConexion().prepareStatement(consulta);
			ps.setString(1, usuario);
			ps.setString(2, password);
			rs = ps.executeQuery();
						
			if(rs.next()) {
				mod = new Modelo();
				//mod.setCedula_usuario(rs.getInt("cedula_usuario"));
				mod.setUsuario(rs.getString("usuario"));
				mod.setPassword(rs.getString("password"));
				System.out.println("Con login");
				return true;
			}else {
				System.out.println("Sin Login");
			}
			
			/*if (rs.absolute(1)) {
				return true;
			}else {
				System.out.println("MAL MAL");
			}*/
			
		} catch (SQLException e) {
			//System.out.println("Error" + e);
			e.printStackTrace();
		}		
		
		return false;
		//con.desconectar();
	}

}
