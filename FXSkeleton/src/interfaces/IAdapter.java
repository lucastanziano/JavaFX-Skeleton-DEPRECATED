package interfaces;

import java.util.List;

public interface IAdapter<T,U> {

	public List<T> convert(List<U> data) throws Exception;
	
	public List<T> merge(List<T> oldData, List<T> newData);
}
