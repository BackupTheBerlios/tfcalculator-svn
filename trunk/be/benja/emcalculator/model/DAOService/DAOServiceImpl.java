package be.benja.emcalculator.model.DAOService;

public class DAOServiceImpl implements DAOService{
	CompetitionDAOService competitionDAOService;
	MultiEventDAOService multiEventDAOService;
	
	public MultiEventDAOService getMultiEventDAOService() {
		return multiEventDAOService;
	}

	public void setMultiEventDAOService(MultiEventDAOService multiEventDAOService) {
		this.multiEventDAOService = multiEventDAOService;
	}

	public CompetitionDAOService getCompetitionDAOService() {
		return competitionDAOService;
	}

	public void setCompetitionDAOService(CompetitionDAOService competitionDAOService) {
		this.competitionDAOService = competitionDAOService;
	}
	

}
