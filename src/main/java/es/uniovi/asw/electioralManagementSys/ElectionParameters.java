package es.uniovi.asw.electioralmanagementsys;

import java.sql.Date;
import java.util.List;

import es.uniovi.asw.pollingst.PollingStation;

public class ElectionParameters {
	private Date electionDate;
	private List<PollingStation> pollingStations;
	private List<PoliticalParty> parties;
}
