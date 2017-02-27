package textindexing;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;


public class IndexStorage {
		
	private String mFolderIndexName;
	private StandardAnalyzer analyzer;
	
	private IndexWriterConfig indexWriterConfig;
	private IndexReader indexReader;
	private IndexWriter indexWriter;
	
	private FSDirectory directoryIndexing;
	
	public IndexStorage(String folderIndexName){
		mFolderIndexName = folderIndexName;
		analyzer = new StandardAnalyzer();
		indexWriterConfig = new IndexWriterConfig(analyzer);
	}
	
	public StandardAnalyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(StandardAnalyzer analyzer) {
		this.analyzer = analyzer;
	}
	
	

	public void openIndexStorage() throws IOException{
		if(directoryIndexing == null)
			directoryIndexing = FSDirectory.open(Paths.get(mFolderIndexName));
	}
	
	
	public IndexReader getIndexReader() throws IOException{
		if(indexReader == null)
			indexReader = DirectoryReader.open(getIndexWriter());
		return indexReader;
	}
	
	public IndexWriter getIndexWriter() throws IOException {
		if(indexWriter == null){
			indexWriter = new IndexWriter(this.directoryIndexing, indexWriterConfig);
		}
		return indexWriter;
	}
	
	public void closeIndexStorage() throws IOException{
		indexReader.close();
		indexWriter.close();
	}

}



