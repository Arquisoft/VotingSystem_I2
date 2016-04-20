package es.uniovi.db.interfaces;

import es.uniovi.PollingStation.model.Voter;

public interface InsertVote {

	String insertVote(int opt, Voter voter);

}
