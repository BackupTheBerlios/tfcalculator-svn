package be.benja.emcalculator.dao.service;

import java.util.Date;
import java.util.Vector;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

import be.benja.emcalculator.model.Competition;
import be.benja.emcalculator.model.MultiEvent;
import be.benja.emcalculator.model.DAOService.CompetitionDAOService;
import be.benja.emcalculator.model.DAOService.DAOService;

public class CompetitionDAOServiceImpl implements CompetitionDAOService {
	private char SEPARATOR = '§';
	DAOService daoService;
	public CompetitionDAOServiceImpl(DAOService daoService) 
	{
		this.daoService = daoService;
	}
	public Vector loadAll() {
		RecordStore rs;
		Vector result = new Vector();
		try {
			rs = RecordStore.openRecordStore("CompetitionDAOService",true);
			RecordEnumeration re = rs.enumerateRecords(null, null, true);
			System.out.println("records "+re.numRecords());
			int id=0;
			while(re.hasNextElement())
			{
				/**
				 * Cela semble etre un bug: nextRecordId fait avancer le pointeur
				 * donc oblige d'appeler rs.getRecord ...
				 */
				id = re.nextRecordId();
				byte nextRec[] = rs.getRecord(id);
				String recordString = new String(nextRec);
				System.out.println("record "+recordString);
				
				Competition competition = convertRowToCompetition(recordString,String.valueOf(id));
				result.addElement(competition);
			}
			rs.closeRecordStore();
			return result;
			
		} catch (RecordStoreFullException e) {
			System.out.println(e);
			return null;
		} catch (RecordStoreNotFoundException e) {
			System.out.println(e);
			return null;
		} catch (RecordStoreException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	private Competition convertRowToCompetition(String row,String id)
	{
		//TODO tester s'il n'y a pas de separateur dans les mots
		String name="";
		Date date=null;
		String place="";
		String athlete="";
		MultiEvent multiEvent=null;
		
		
		int nTokens=0;
		int i=0;
		StringBuffer buffer = new StringBuffer();
		while(i<row.length())
		{
			
			if(row.charAt(i)==SEPARATOR)
			{
				switch(nTokens)
				{
				case 0: 
					name = (buffer.toString());
					break;
				case 1:
					date = (new Date(Long.parseLong(buffer.toString())));
					break;
				case 2:
					place =(buffer.toString());
					break;
				case 3:
					athlete = (buffer.toString());
					break;
				case 4:
					multiEvent = daoService.getMultiEventDAOService().load(buffer.toString());
					break;
				}
				
				buffer = new StringBuffer();
				nTokens++;
			}
			else
			{
				buffer.append(row.charAt(i));
			}
			i++;
		}
		if(multiEvent!=null)
		{
			Competition competition = new Competition(multiEvent);
			competition.setId(id);
			competition.setAthleteName(athlete);
			competition.setDate(date);
			competition.setName(name);
			competition.setPlace(place);
			return competition;
		}
		return null;
		
	}

	public Competition load(String id) {
		RecordStore rs;
		try {
			rs = RecordStore.openRecordStore("CompetitionDAOService",true);
			byte nextRec[] = rs.getRecord(Integer.parseInt(id));
			String recordString = new String(nextRec);
			System.out.println(recordString);
			Competition competition = convertRowToCompetition(recordString,String.valueOf(id));
			rs.closeRecordStore();
			return competition;
		} catch (RecordStoreFullException e) {
			return null;
		} catch (RecordStoreNotFoundException e) {
			return null;
		} catch (RecordStoreException e) {
			return null;
		}
	}

	public void saveOrUpdate(Competition competition) {
		RecordStore rs;

			try {
				rs = RecordStore.openRecordStore("CompetitionDAOService",true);
				StringBuffer buffer = new StringBuffer();
				buffer.append(competition.getName());
				buffer.append(SEPARATOR);
				buffer.append(competition.getDate().getTime());
				buffer.append(SEPARATOR);
				buffer.append(competition.getPlace());
				buffer.append(SEPARATOR);
				buffer.append(competition.getAthleteName());
				buffer.append(SEPARATOR);
				buffer.append(competition.getMultiEvent().getName());
				buffer.append(SEPARATOR);
				//TODO result
				byte record[] = buffer.toString().getBytes();
				if(competition.getId()!=null)
				{
					rs.setRecord(Integer.parseInt(competition.getId()),record,0,record.length);
				}
				else
				{
					rs.addRecord(record,0,record.length);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidRecordIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
