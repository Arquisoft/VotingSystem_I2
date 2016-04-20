package es.uniovi.db.ports;

import java.sql.SQLException;

import es.uniovi.PollingStation.model.Voter;
import es.uniovi.db.DatabaseGateway;
import es.uniovi.db.VerificationException;
import es.uniovi.db.interfaces.IVoter;

public class VoterR implements IVoter{

	@Override
	public Voter getVoter(String login, String pass) throws VerificationException{
		DatabaseGateway dbg = new DatabaseGateway();
		
		Voter voter = null;
		try {
			voter = dbg.getVerifiedVoter(login, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return voter;
	}

}
