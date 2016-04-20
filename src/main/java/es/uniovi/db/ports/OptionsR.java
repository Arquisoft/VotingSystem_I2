package es.uniovi.db.ports;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.PollingStation.model.Option;
import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.interfaces.IOptions;

public class OptionsR implements IOptions {

	@Override
	public List<Option> getOptions() {
		DatabaseGateway dbg = new DatabaseGateway();
		
		try {
			return dbg.getOptions();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
