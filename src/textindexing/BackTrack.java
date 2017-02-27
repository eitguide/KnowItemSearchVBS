package textindexing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BackTrack {
	private String mBacktrackFileName;
	private Map<String, String> mDataBackTrack;
	
	public BackTrack(String backTrackFileName){
		this.mBacktrackFileName = backTrackFileName;
		mDataBackTrack = new HashMap<String, String>();
	}
	
	public void loadDataBackTrack(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(mBacktrackFileName)));
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("_____");
				mDataBackTrack.put(data[0], data[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		
	}
	
	public Map<String, String> getBackTrackData(){
		return mDataBackTrack;
	}
	
	public String getRealFileNameVideo(String key){
		if(mDataBackTrack.size() != 0){
			return mDataBackTrack.get(key);
		}
		return null;
	}
}
