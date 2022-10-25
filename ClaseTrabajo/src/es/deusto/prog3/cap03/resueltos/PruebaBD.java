package es.deusto.prog3.cap03.resueltos;

import java.sql.*;

public class PruebaBD {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:mibasededatos.db" );
//			jdbc, nombre del gestor de BD, nombre de la BS
			Statement statement = conn.createStatement();
			
			statement.executeUpdate( "drop table if exists persona" );
			statement.executeUpdate( "create table persona(id integer, nombre string)" );
			
			// Create - insert
			statement.executeUpdate( "insert into persona values(1, 'Andoni')" );
			int ret = statement.executeUpdate( "insert into persona (id, nombre) values(2, 'Olatz')" );
			statement.executeUpdate( "insert into persona (id, nombre) values(3, 'Emilio')" );
			System.out.println("Devuelve " + ret);
			
			// Update - update
			statement.executeUpdate( "update persona set nombre = 'Aitziber' where id = 2" );
			
			// Delete - delete
			statement.executeUpdate( "delete from persona where id = 3" );
			
			ResultSet rs = statement.executeQuery( "select * from persona" );
			while (rs.next()) {
				int ident = rs.getInt( "id" );
				String nom = rs.getString( "nombre" );
				System.out.println(ident + " -> " + nom);
			} 
			
			statement.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
