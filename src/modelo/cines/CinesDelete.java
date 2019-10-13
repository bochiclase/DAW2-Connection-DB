package modelo.cines;


 


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesDelete {
	
	public void deleteCine(int id) {
	Connection conexion= BDConect.getConexion();
	PreparedStatement stmt;
	
	String sentencia ="delete from cines where id  = " + id + ";";
		
	try {
		stmt = conexion.prepareStatement(sentencia);
		stmt.executeUpdate();
	} catch(SQLException e){
		e.printStackTrace();
		
	}
	 
	}
	
}
