package be.benja.emcalculator.dao.service;

import java.util.Vector;

import be.benja.emcalculator.dao.service.staticdatas.MultiEventDatas;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.model.DAOService.MultiEventDAOService;

public class MultiEventDAOServiceImpl implements MultiEventDAOService{

	MultiEventDatas multiEventDatas;
	
	public MultiEventDAOServiceImpl(MultiEventDatas multiEventDatas)
	{
		this.multiEventDatas = multiEventDatas;
	}
	public MultiEvent load(String id) {
		return multiEventDatas.getMultiEvent(id);
	}

	public Vector loadAll() {
		return multiEventDatas.getMultiEventList();
	}

}
