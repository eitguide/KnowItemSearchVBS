package filemanager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

public class FileManager {
	private static FileManager mInstance;
	private FileManager(){
		
	}
	
	public static FileManager getInstance(){
		if(mInstance == null){
			mInstance = new FileManager();
		}
		return mInstance;
	}
	
	public List<String> listFilesForFolder(final File folder) {
        List<String> listFileVideos = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                listFileVideos.add(fileEntry.getName());
            }
        }

        return listFileVideos;
    }

	
    public static List<String> listFilesForFolder(final String path) {
        List<String> listFileVideos = new ArrayList<>();

        File file = new File(path);
        for (final File fileEntry : file.listFiles(new FilterExtentsion())) {
            if (fileEntry.isFile()) {
                listFileVideos.add(fileEntry.getAbsolutePath());
            }
        }
        
        return listFileVideos;
    }

    static class FilterExtentsion implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
           if(FilenameUtils.getExtension(name).equals("mp4"))
               return true;
           return false;
        }
    }
}
