package data.repository;

public interface ObjBuilder<T, S> {
	
	public T build( S entry, int row) throws Exception;

}
