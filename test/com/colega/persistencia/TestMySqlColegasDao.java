package com.colega.persistencia;

import static org.junit.Assert.*;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;

import com.colega.modelo.entidades.Colega;

public class TestMySqlColegasDao {
	
	
	@Before 
	public void prepararEntorno() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Colega colega1 = new Colega(1,"Maria", "Pamplona", new Date(formatter.parse("1998-06-23").getTime()));
		Colega colega2 = new Colega(2,"Pedro", "Madrid", new Date(formatter.parse("2016-02-20").getTime()));
	
	BasicDataSource ds = new BasicDataSource();
	ds.setUrl("jdbc:mysql://localhost:3306/colegasjdbc"); 
	ds.setUsername("root"); 
	ds.setPassword("root");
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	
	MySqlColegasDao sut = new MySqlColegasDao(ds);

	
	try {
		sut.bajaRegistro(colega1.getId());
		sut.bajaRegistro(colega2.getId());
		Colega colegaObtenido1 = sut.ConsultarUnRegistro(colega1.getId());
		Colega colegaObtenido2 = sut.ConsultarUnRegistro(colega2.getId());
	} catch (SQLException e) {
		e.printStackTrace();
		fail("Seproduce un SQLException y no deberia: " + e.getMessage());
	}
		
	}
	
	@Test
	public void test() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Colega colega1 = new Colega(1,"Maria", "Pamplona", new Date(formatter.parse("1998-06-23").getTime()));
		Colega colega2 = new Colega(2,"Pedro", "Madrid", new Date(formatter.parse("2016-02-20").getTime()));
	
	BasicDataSource ds = new BasicDataSource();
	ds.setUrl("jdbc:mysql://localhost:3306/colegasjdbc"); 
	ds.setUsername("root"); 
	ds.setPassword("root");
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	
	MySqlColegasDao sut = new MySqlColegasDao(ds);
	
	
	try {
		sut.altaRegistro(colega1);
		sut.altaRegistro(colega2);
		Colega colegaObtenido1 = sut.ConsultarUnRegistro(colega1.getId());
		Colega colegaObtenido2 = sut.ConsultarUnRegistro(colega2.getId());
		assertEquals(colega1,colegaObtenido1);
		assertEquals(colega2,colegaObtenido2);
	} catch (SQLException e) {
		e.printStackTrace();
		fail("Seproduce un SQLException y no deberia: " + e.getMessage());
	}
	
	
	
	
		
	
	 
	//fail("Not yet implemented");
	
		
		
	}

}


