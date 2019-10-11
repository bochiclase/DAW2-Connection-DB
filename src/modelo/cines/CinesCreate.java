package modelo.cines;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesCreate {
	
	
	public void createCine(CineBean cine) {
		//¿EN CONEXION PORQUE HAY QUE IMPORTAR JAVA.UTIL SQL Y NO DE LA LIBRERIA?
		Connection conexion = BDConect.getConexion();
		PreparedStatement stmt;
		
		String sentencia = "insert into cines values(" + cine.getIdCine() + ","+  cine.getNombre() + "," + cine.getResponsable()   + "," +  cine.getTelefono() +","+ cine.getDireccion()+ ")";
		
		
		try {
			stmt = conexion.prepareStatement(sentencia);
	       	stmt.executeUpdate();
	       	
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
			
		
	}
	

}
