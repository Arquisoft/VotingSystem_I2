package es.uniovi.db.ports;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sun.media.sound.InvalidDataException;

import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.interfaces.Create;
import es.uniovi.db.util.Jdbc;
import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class CreateP implements Create {

	Connection con;
	
	@Override
	public void create(Configuration conf, List<Option> options,
			List<PollingStation> stations) throws InvalidDataException {
		try {
			con = Jdbc.getConnection();
			DatabaseGateway dbg = new DatabaseGateway(); 
			
			dbg.reset(con);
			for (Option opt : options) {
				dbg.insertOption(con, opt);
			}
			
			for (PollingStation station : stations) {
				dbg.insertStation(con, station);
			}
			
			dbg.configure(con, conf);
		} catch (SQLException e) {
			System.out.print(e);
			throw new InvalidDataException("Data invalid");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
