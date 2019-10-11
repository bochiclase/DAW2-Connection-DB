package modelo.cines;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesDelete {
	
	public void deleteCine(CineBean cine) {
	Connection conexion= BDConect.getConexion();
	PreparedStatement stmt;
	String sentencia ="DELETE from cines where nombre = '" + cine.getNombre() + "'";
		
	try {
		stmt = conexion.prepareStatement(sentencia);
		
	} catch(SQLException e){
		e.printStackTrace();
	}
	
	}
	
}
