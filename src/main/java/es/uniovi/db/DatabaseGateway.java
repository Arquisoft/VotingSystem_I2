package es.uniovi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.electoral.model.Option;

public class DatabaseGateway {

	public void insertOption(Connection con, Option option) throws SQLException {
		PreparedStatement ps = con.prepareStatement("Insert into OPTIONS Values (?,?,?)");
		
		ps.setLong(1, option.getId());
		ps.setString(2, option.getName());
		ps.setString(3, option.getComment());
	}

	public void reset(Connection con) throws SQLException {
		con.createStatement().executeUpdate("DELETE FROM OPTIONS");
		con.createStatement().executeUpdate("DELETE FROM VOTES");
		con.createStatement().executeUpdate("DELETE FROM POLLING_STATION");
	}
}
