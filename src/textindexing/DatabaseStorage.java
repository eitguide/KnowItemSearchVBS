package textindexing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Frame;

public class DatabaseStorage {
	private List<Frame> mData;
	private String mDatabaseStorageName;
	public DatabaseStorage(String databaseStorageName){
		this.mDatabaseStorageName  = databaseStorageName;
		this.mData = new ArrayList<>();
	}
	public List<Frame> getFrameDataFromFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(mDatabaseStorageName)));
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				String[] result = line.split("_____");
				Frame frame = new Frame(result[0], result[1]);
				mData.add(frame);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mData;
	}
}
