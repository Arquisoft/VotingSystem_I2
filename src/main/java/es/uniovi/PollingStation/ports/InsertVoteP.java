package es.uniovi.PollingStation.ports;

import es.uniovi.PollingStation.model.Voter;
import es.uniovi.db.interfaces.InsertVote;
import es.uniovi.db.ports.InsertVoteR;

public class InsertVoteP {

	public static String insertVote(int opt, Voter voter) {
		InsertVote v = new InsertVoteR();
		
		return v.insertVote(opt, voter);
		
	}

}
