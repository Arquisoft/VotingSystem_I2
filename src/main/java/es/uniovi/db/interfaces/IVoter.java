package es.uniovi.db.interfaces;

import es.uniovi.PollingStation.model.Voter;
import es.uniovi.db.VerificationException;

public interface IVoter {

	Voter getVoter(String login, String pass) throws VerificationException;

}
