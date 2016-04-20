package es.uniovi.db.ports;

import java.sql.SQLException;

import es.uniovi.PollingStation.model.Voter;
import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.interfaces.InsertVote;

public class InsertVoteR implements InsertVote {

	@Override
	public String insertVote(int opt, Voter code) {
		DatabaseGateway dbg = new DatabaseGateway();
		try {
			dbg.inserVote(opt, code);
			return "Vote has been stored";
		} catch (SQLException e) {
			System.out.print(e);
			return "There was an issue storing your vote";
		}
	}

}
