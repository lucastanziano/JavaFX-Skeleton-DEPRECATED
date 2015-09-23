package data.repository;

import java.util.List;

public interface ObjBuilder<T, S> {
	
	public T build( S entry, int row) throws Exception;
	
	public List<Integer> getSheetsToParse();

}
