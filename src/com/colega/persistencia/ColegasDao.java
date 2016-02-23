package com.colega.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.colega.modelo.entidades.Colega;

public interface ColegasDao {
	
	void altaRegistro(Colega colega) throws SQLException;
	void bajaRegistro(Integer id) throws SQLException;
	void modificarRegistro(Colega colega) throws SQLException;
	Colega ConsultarUnRegistro(Integer id) throws SQLException;
	Collection<Colega> ConsultarTodosRegistros() throws SQLException;
	
}
