package es.uniovi.db.ports;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.interfaces.Create;
import es.uniovi.db.util.Jdbc;
import es.uniovi.electoral.model.Configuration;
import es.uniovi.electoral.model.Option;
import es.uniovi.electoral.model.PollingStation;

public class CreateP implements Create {

	@Override
	public void create(Configuration conf, List<Option> options,
			List<PollingStation> stations) {
		try {
			Connection con = Jdbc.getConnection();
			DatabaseGateway dbg = new DatabaseGateway();
			
			dbg.reset(con);
		} catch (SQLException e) {

		}

	}

}
