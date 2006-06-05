package be.benja.emcalculator.system;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;

import be.benja.emcalculator.model.Competition;

import com.sun.midp.io.j2me.storage.File;

public class CompetitionSaver {
	
	public CompetitionSaver() throws RecordStoreFullException, RecordStoreNotFoundException, RecordStoreException
	{
		 
	}
	
	public void save(Competition competition) throws RecordStoreFullException, RecordStoreNotFoundException, RecordStoreException, IOException
	{
		RecordStore db = RecordStore.openRecordStore("be.benja.emcalculator.competition", true);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(competition.getName());
		byte[] b = baos.toByteArray();
		db.addRecord(b, 0, b.length);
		db.closeRecordStore(); 
	}

}
