package data.repository;

import java.util.List;


public interface IRepository<T> {
	
	
	public List<T> getAllElements() throws Exception;

}
