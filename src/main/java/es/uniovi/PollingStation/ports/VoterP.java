package es.uniovi.PollingStation.ports;

import es.uniovi.PollingStation.model.Voter;
import es.uniovi.db.VerificationException;
import es.uniovi.db.interfaces.IVoter;
import es.uniovi.db.ports.VoterR;

public class VoterP {

	public static Voter getVoter(String login, String pass) throws VerificationException {
		
		IVoter voter = new VoterR();
		return voter.getVoter(login, pass);
	}

}
