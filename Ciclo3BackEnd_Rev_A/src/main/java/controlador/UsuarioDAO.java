package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Modelo;

public class UsuarioDAO {
	
	public boolean insert (Modelo mod) {
		boolean flag = false;
		Conexion con = new Conexion();
		String sql = "INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) VALUES (?,?,?,?,?)";
				
		try {
			
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, mod.getCedula_usuario());
			ps.setString(2, mod.getEmail_usuario());
			ps.setString(3, mod.getNombre_usuario());
			ps.setString(4, mod.getPassword());
			ps.setString(5, mod.getUsuario());
			if (ps.executeUpdate() == 1) {
				flag = true;
				System.out.println("---------------------------------------------");
				System.out.println("'" + mod.getNombre_usuario().toUpperCase() + "' REGISTRADO CORRECTAMENTE ");
				System.out.println("---------------------------------------------");
			}else {
				System.out.println("Error al registrar usuario");
			}			
			con.desconectar();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public List<Modelo>selectAll(){
		List<Modelo> lista = new LinkedList<Modelo>();
		String sql = "SELECT * FROM tiendagenerica07.usuarios;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Modelo tablaUsuarios;
			while (rs.next()) {
				tablaUsuarios = new Modelo(rs.getInt("cedula_usuario"),rs.getString("email_usuario"), rs.getString("nombre_usuario"), rs.getString("password"), rs.getString("usuario"));
				lista.add(tablaUsuarios);
			}
			
			if (lista.size()> 0) {
				//System.out.println("Lista llena");
			}else {
				System.out.println("No hay ningun registro");
			}	
			con.desconectar();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public boolean update(Modelo mod){
		boolean flag =false;
		String sql = "UPDATE tiendagenerica07.usuarios SET email_usuario = ?, nombre_usuario = ?, password = ?, usuario = ? WHERE cedula_usuario= ?;";			
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, mod.getEmail_usuario());
			ps.setString(2, mod.getNombre_usuario());
			ps.setString(3, mod.getPassword());
			ps.setString(4, mod.getUsuario());
			ps.setInt(5, mod.getCedula_usuario());
			if(ps.executeUpdate() == 1){
				flag = true;
				System.out.println("Usuario Actualizado");
			}else {
				System.out.println("No se ha podido Actualizar");
			}
			con.desconectar();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean delete(int cedula_usuario){
		Boolean flag = false;
		String sql = "DELETE FROM tiendagenerica07.usuarios WHERE cedula_usuario = ?;";
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, cedula_usuario);
			if (ps.executeUpdate()== 1) {
				flag = true;
				System.out.println("Resgistro Eliminado");
			}else {
				System.out.println("Resgistro NO se ha Eliminado");
			}
			con.desconectar();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}


}
