package es.uniovi.electoral;

import java.sql.SQLException;
import java.util.List;

import es.uniovi.electoral.model.*;
import es.uniovi.db.interfaces.Create;
import es.uniovi.db.ports.CreateP;

public class CreateR {

	public void create( Configuration conf, List<Option> options, List<PollingStation> stations) {
	
		Create cr = new CreateP();
			cr.create(conf, options, stations);
		
	}
	
}
