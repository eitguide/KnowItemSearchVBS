package textindexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import model.Frame;;;

public class Matching {

	public List<Frame> getResult(IndexStorage indexStorage, int topRank, String query) throws IOException, ParseException {
		IndexSearcher searcher = new IndexSearcher(indexStorage.getIndexReader());

		TopDocs docs = searcher.search(TextQuery.create(query, indexStorage.getAnalyzer()), topRank);
		ScoreDoc[] hits = docs.scoreDocs;
		List<Frame> results = null;
		if(hits.length != 0){
			results = new ArrayList<>();
			for (int i = 0; i < hits.length; ++i) {
				int docId = hits[i].doc;
				Document d = searcher.doc(docId);
				Frame frame = new Frame(d.get(Indexing.FRAME_NAME), d.get(Indexing.LABLE_FRAME_NAME));
//				frame.decodeFrame(d.get(Indexing.FRAME_NAME));
				results.add(frame);
			}
			return results;
		}
		
		return null;
	}
}
