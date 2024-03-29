package impl.tew.persistence;

import java.sql.*;
import java.util.*;

import com.tew.model.Pisos;
import com.tew.persistence.PisosDao;
import com.tew.persistence.exception.*;


/**
 * @author Alejandro Mu�iz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class PisosJdbcDao implements PisosDao {

	public List<Pisos> Pisos() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Pisos> Pisoss = new ArrayList<Pisos>();
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("select * from Piso");
			rs = ps.executeQuery();
			System.out.print("----------------------------------");

			while (rs.next()) {
				Pisos Pisos = new Pisos();
				Pisos.setID(rs.getInt("ID"));
				Pisos.setPrecio(rs.getDouble("PRECIO"));
				Pisos.setIDAgente(rs.getInt("IDAGENTE"));
				Pisos.setDireccion(rs.getString("DIRECCION"));
				Pisos.setAnio(rs.getInt("ANIO"));
				Pisos.setEstado(rs.getInt("ESTADO"));
				Pisos.setCiudad(rs.getString("CIUDAD"));
				Pisos.setImagen(rs.getString("IMAGEN"));
				Pisoss.add(Pisos);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}

		return Pisoss;
	}

	@SuppressWarnings("resource")
	@Override
	public void delete(int id) throws NotPersistedException {
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			
								
				ps = con.prepareStatement("delete from Piso where ID = ?");
				ps.setInt(1, id);

				rows = ps.executeUpdate();


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Drive not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public Pisos findById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		Pisos Pisos = null;

		try {
 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("select * from Piso where id = ?");
			ps.setLong(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				Pisos = new Pisos();

				Pisos.setID(rs.getInt("ID"));
				Pisos.setPrecio(rs.getDouble("PRECIO"));
				Pisos.setIDAgente(rs.getInt("IDAGENTE"));
				Pisos.setDireccion(rs.getString("DIRECCION"));
				Pisos.setAnio(rs.getInt("ANIO"));
				Pisos.setEstado(rs.getInt("ESTADO"));
				Pisos.setImagen(rs.getString("IMAGEN"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}

		return Pisos;
	}
	
	public String reinicia() {
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;
		
		try {			

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");

			ps = con.prepareStatement("delete from PISO");
			rows = ps.executeUpdate();
			
			ps = con.prepareStatement("delete from AGENTE");
			rows = ps.executeUpdate();


			rows = ps.executeUpdate();
			
			ps = con.prepareStatement("INSERT INTO AGENTE VALUES(1,'agente1','clave1')");	
			rows = ps.executeUpdate();
			
			ps = con.prepareStatement("INSERT INTO AGENTE VALUES(2,'agente2','clave2')");	
			rows = ps.executeUpdate();
							

			
			
			
			
			
			return "exito";
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}
	


	@Override
	public void save(Pisos a) throws AlreadyPersistedException {
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(
					"insert into Piso (IDAgente, precio, direccion,ciudad,anio,estado,imagen) " +
					"values (?, ?, ?, ?, ?, ?,?)");
			ps.setInt(1, a.getIDAgente());
			ps.setDouble(2, a.getPrecio());
			ps.setString(3, a.getDireccion());
			ps.setString(4, a.getCiudad());
			ps.setInt(5, a.getAnio());
			ps.setInt(6, a.getEstado());
			ps.setString(7, a.getImagen());

			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new AlreadyPersistedException("Piso " + a + " already persisted");
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public void update(Pisos a) throws NotPersistedException {
		PreparedStatement ps = null;
		Connection con = null;
		int rows = 0;

		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(
					"update Piso " +
							"set ID = ?, IDAgente = ?, precio = ?, direccion = ?, ciudad = ?, anio = ?, estado = ?, imagen = ?" +
					"where ID = ?");

			ps.setInt(1, a.getID());
			ps.setInt(2, a.getIDAgente());
			ps.setDouble(3, a.getPrecio());
			ps.setString(4, a.getDireccion());
			ps.setString(5, a.getCiudad());
			ps.setInt(6, a.getAnio());
			ps.setInt(7, a.getEstado());
			ps.setString(8,a.getImagen());
			ps.setInt(9, a.getID());


			rows = ps.executeUpdate();
			if (rows != 1) {
				throw new NotPersistedException("Piso " + a + " not found");
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
	}

	@Override
	public List<Pisos> PisosAgente(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		List<Pisos> Pisoss = new ArrayList<Pisos>();
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("select * from Piso where IDAGENTE=?");
			ps.setInt(1, id);
						
			rs = ps.executeQuery();
			System.out.print("----------------------------------");

			while (rs.next()) {
				Pisos Pisos = new Pisos();
				Pisos.setID(rs.getInt("ID"));
				Pisos.setPrecio(rs.getDouble("PRECIO"));
				Pisos.setIDAgente(rs.getInt("IDAGENTE"));
				Pisos.setDireccion(rs.getString("DIRECCION"));
				Pisos.setAnio(rs.getInt("ANIO"));
				Pisos.setEstado(rs.getInt("ESTADO"));
				Pisos.setCiudad(rs.getString("CIUDAD"));
				Pisoss.add(Pisos);
				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenceException("Driver not found", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}

		return Pisoss;
	}
	
}
