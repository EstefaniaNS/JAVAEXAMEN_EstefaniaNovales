package com.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.colega.modelo.entidades.Colega;
import com.colega.persistencia.ColegasDao;


public class GestionColegasImpl implements GestionColegas {

    private ColegasDao colegasDao;
	
 

	public GestionColegasImpl(ColegasDao colegasDao) {
	super();
	this.colegasDao = colegasDao; 
}
	

	@Override
	public void insertarRegistro(Colega colega) throws SQLException {
		  colegasDao.altaRegistro(colega);
		
		
	}

	@Override
	public void borrarRegistro(Integer id) throws SQLException {
		colegasDao.bajaRegistro(id);	

	}

	@Override
	public void modificarRegistro(Colega colega) throws SQLException {
		colegasDao.modificarRegistro(colega);
		
	}


	@Override
	public Colega ConsultarUnRegistro(Integer id) throws SQLException {
		return colegasDao.ConsultarUnRegistro(id);
		
	}


	@Override
	public Collection<Colega> ConsultarTodosRegistros() throws SQLException {
		return colegasDao.ConsultarTodosRegistros();
	}

}
