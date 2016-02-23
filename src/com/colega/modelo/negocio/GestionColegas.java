package com.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.colega.modelo.entidades.Colega;

public interface GestionColegas {
	
	void insertarRegistro(Colega colega) throws SQLException; 
	void borrarRegistro(Integer id) throws SQLException;
	void modificarRegistro(Colega colega) throws SQLException;
	Colega ConsultarUnRegistro(Integer id) throws SQLException;
	Collection<Colega> ConsultarTodosRegistros() throws SQLException;
		

}
