package es.uniovi.db.interfaces;

import java.util.List;

import com.sun.media.sound.InvalidDataException;

import es.uniovi.voting.model.*;

public interface Create {

	public void create(Configuration conf, List<Option> options, List<PollingStation> stations) throws InvalidDataException;
}
