package es.uniovi.PollingStation.ports;

import java.util.List;

import es.uniovi.PollingStation.model.Option;
import es.uniovi.db.interfaces.IOptions;
import es.uniovi.db.ports.OptionsR;

public class OptionsP {

	public static List<Option> getOptions() {
		IOptions opt = new OptionsR();
		return opt.getOptions();
	}

}
