package textindexing;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;

public class TextQuery {
	public static Query create(String query, Analyzer analyzer) throws ParseException {
		return new QueryParser(Indexing.LABLE_FRAME_NAME, analyzer).parse(query);

	}

}
