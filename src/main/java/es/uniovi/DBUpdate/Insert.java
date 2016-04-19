package es.uniovi.dbupdate;

import java.util.List;

import es.uniovi.parser.Voter;

public interface Insert {

	public List<Voter> insert(List<Voter> voters);
}
