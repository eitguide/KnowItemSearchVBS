package textindexing;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import model.Frame;

public class Indexing {
	public static final String FRAME_NAME = "frame_name";
    public static final String LABLE_FRAME_NAME = "semantic_of_image";
    
	public static void addDocumentToIndexStorage(IndexStorage indexStorage, Frame frame){
		Document doc = new Document();
		doc.add(new StringField(FRAME_NAME, frame.getFrameName(), Store.YES));
		doc.add(new TextField(LABLE_FRAME_NAME, frame.getSematicOfFrame(),Store.YES));
		
		try {
			indexStorage.getIndexWriter().addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void indexFromDatabaseStorage(IndexStorage indexStorage, DatabaseStorage databaseStorage){
		if(indexStorage == null || databaseStorage == null)
			return;
		
		List<Frame> allFrameFromDatabaseStorage = databaseStorage.getFrameDataFromFile();
		System.out.println("Size Frame: " + allFrameFromDatabaseStorage.size());
		for(Frame frame: allFrameFromDatabaseStorage){
			addDocumentToIndexStorage(indexStorage, frame);
		}
	}
}
