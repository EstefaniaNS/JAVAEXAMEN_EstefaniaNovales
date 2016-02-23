package com.colega.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import com.colega.modelo.entidades.Colega;


public class MySqlColegasDao implements ColegasDao { 

	
	private static final String INSERT_COLEGA = "INSERT INTO colegas (id,nombre,ciudad,fecha) " + " VALUES (?,?,?,?)";
	private static final String DELETE_COLEGA = "DELETE FROM colegas " + " WHERE id=?";
	private static final String MODIFICAR_COLEGA = "UPDATE colegas SET nombre=?, ciudad=?, fecha=? WHERE id=?";
	private static final String SELECT_COLEGA_ID = " SELECT * " +" FROM colegas" + " WHERE id=?"; 
	private static final String SELECT_COLEGA = "SELECT * FROM colegas";
	
	
	private DataSource ds;
	
	
	public MySqlColegasDao(DataSource ds) {
		super();
		this.ds = ds;
	}

	
	
	@Override
	public void altaRegistro(Colega colega) throws SQLException {
		Connection connection= null;
			
		try {
			
			connection= ds.getConnection();
			
			java.sql.PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1,colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));
			
			ps.executeUpdate();
			
		
		} finally{
			if (connection != null){
				connection.close();
			}
		}
		
	}

	@Override
	public void bajaRegistro(Integer id) throws SQLException {
	
		Connection connection= null;
		
		try {
			
			connection= ds.getConnection();
		
			PreparedStatement ps =  (PreparedStatement) connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1,id);
			
		
			ps.executeUpdate();
			
			
		} finally{
			
			if (connection != null){
				connection.close();
			}
		}
	}
	
	@Override
	public void modificarRegistro(Colega colega) throws SQLException {
		Connection connection= null;
		
		try {
			
			connection= ds.getConnection();
		
			PreparedStatement ps =  (PreparedStatement) connection.prepareStatement(MODIFICAR_COLEGA);
			
			ps.setString(1, colega.getNombre());
			ps.setString(2, colega.getCiudad());
			ps.setDate(3, new java.sql.Date(colega.getFecha().getTime()));
			ps.setInt(4,colega.getId());
			ps.executeUpdate();
			
		} finally{
			
			if (connection != null){
				connection.close();
			}
		}
	}



	@Override
	public Colega ConsultarUnRegistro(Integer id) throws SQLException{
		
			Connection connection= null;
					
					try {
					
						connection= ds.getConnection();
						
						PreparedStatement ps =  (PreparedStatement) connection.prepareStatement(SELECT_COLEGA_ID);
						
						ps.setInt(1,id);
						ResultSet rs = ps.executeQuery();
						
						if(rs.first()){
							
							return  new Colega(id, rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));
					
						}
						return null;
						
					} finally{
						
						if (connection != null){
							connection.close();
						}
					}
					
					
				}



	@Override
	public Collection<Colega> ConsultarTodosRegistros() throws SQLException {
		
		Collection<Colega> resultado= new HashSet<>();
		
		
		Connection connection = null;

		try {
			
			connection = ds.getConnection();
		
			java.sql.PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);
		
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
			
				do{
				
					Colega colega = new Colega(
							rs.getInt("id"), 
							rs.getString("nombre"),
							rs.getString("ciudad"),
							rs.getDate("Fecha")); 
					resultado.add(colega);
				}while (rs.next());
			}
			return resultado;
		}finally {
			
			if (connection != null) {
				connection.close();
			}
		}
	}
		
	
	
}

	
