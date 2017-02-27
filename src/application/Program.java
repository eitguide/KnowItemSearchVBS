package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import model.Frame;
import textindexing.BackTrack;
import textindexing.DatabaseStorage;
import textindexing.IndexStorage;
import textindexing.Indexing;
import textindexing.Matching;
import utils.Logger;

public class Program {

	public static void main(String[] args) {
		// TODO Test module IndexStorage
		
		DatabaseStorage databaseStorage = new DatabaseStorage(Config.DATABASE_STORAGE);
		
		
		
		IndexStorage indexStorage = new IndexStorage(Config.INDEX_STORAGE_NAME);
		try {
			indexStorage.openIndexStorage();
			
			Indexing.indexFromDatabaseStorage(indexStorage, databaseStorage);
					
			Matching matching = new Matching();
			List<Frame> results = matching.getResult(indexStorage, 10, "clock");
			
			for(Frame a: results){
				Logger.e(a.getSematicOfFrame());
			}
			
			
			System.out.println(results.size());
			
			indexStorage.closeIndexStorage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO test Module DatabaseStorage
		
		//DatabaseStorage databaseStorage = new DatabaseStorage(Config.DATABASE_STORAGE);
		//List<Frame> allFrame = databaseStorage.getFrameDataFromFile();
		//for(Frame item: allFrame){
			//Logger.e(item.getFrameName() + "__" + item.getSematicOfFrame());
		//}
		
		
		//TODO test module backtrack
		//BackTrack  backtrack = new BackTrack(Config.BACKTRACK_NAME);
		//backtrack.loadDataBackTrack();
		//Logger.e(backtrack.getRealFileNameVideo("VIDEO_1"));
		
		//TODO test decode frame
		//Frame testFrame = new Frame();
		//testFrame.decodeFrame("VIDEO_1#shot_1#0_20#frame_1.jpg");
		//Logger.e(testFrame.toString());
	
		
		  
	}

}
