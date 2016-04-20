package es.uniovi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.PollingStation.model.*;
import es.uniovi.db.util.Jdbc;

public class DatabaseGateway {

	public Voter getVerifiedVoter(String login, String pass)
			throws SQLException, VerificationException {
		Connection con = Jdbc.getConnection();
		Voter v = null;
		PreparedStatement ps = con.prepareStatement("Select * from voters where email = ? AND password = ?");

		
		ps.setString(1, login);
		ps.setString(2, pass);

		ResultSet rs = ps.executeQuery();

		int code = 0;
		if (!rs.next()) {

			rs.close();
			ps.close();
			con.close();
			throw new VerificationException("Invalid login data");
		} else {
			if ((rs.getBoolean(6)) || (rs.getBoolean(7))) {

				rs.close();
				ps.close();
				con.close();
				throw new VerificationException("User has already voted");
			}
			
			code = Integer.parseInt(rs.getString(5));
			v = new Voter(rs.getString(2), code);
		}
		
		ps = con
				.prepareStatement("Select START_DATE, END_DATE from CONFIGURATION");
		rs = ps.executeQuery();
		rs.next();

		Timestamp temp = new Timestamp(new Date().getTime());

		if ((rs.getTimestamp(1).after(temp))
				|| (rs.getTimestamp(2).before(temp))) {
			rs.close();
			ps.close();
			con.close();
			throw new VerificationException("Voting isn't open at this time");

		}

		ps = con.prepareStatement("Select POLLING_STATION_CODE FROM POLLING_STATION WHERE POLLING_STATION_CODE = ?");

		ps.setInt(1, code);

		rs = ps.executeQuery();

		if (!rs.next()) {

			rs.close();
			ps.close();
			con.close();
			throw new VerificationException(
					"Your polling station is not available for voting");
		}
		rs.close();
		ps.close();
		con.close();
		return v;
	}

	public List<Option> getOptions() throws SQLException{
		List<Option> opts = new ArrayList<Option>();
		Option temp;
		
		Connection con = Jdbc.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet rs =  stmnt.executeQuery("SELECT * FROM OPTIONS");
		
		while (rs.next()) {
			temp = new Option(rs.getInt(1), rs.getString(2), rs.getString(3));
			opts.add(temp);
		}
		
		rs.close();
		stmnt.close();
		con.close();
		return opts;
	}

	public void inserVote(int opt, Voter voter) throws SQLException {

		Connection con = Jdbc.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into votes (POLLING_STATION_CODE, OPTION_ID) values (?,?) ");

		ps.setInt(1, voter.getCode());
		ps.setInt(2, opt);
		
		ps.executeUpdate();
		
		ps = con.prepareStatement("UPDATE VOTERS SET HAS_EVOTED = 1 WHERE email = ?");
		ps.setString(1, voter.getLogin());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
}
