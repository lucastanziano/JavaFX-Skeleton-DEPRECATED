package filter;

public class EvenCriteria implements ICriteria<Integer>{

	@Override
	public boolean isValid(Integer data) {
		return (data.intValue() % 2) != 0;
	}


	

}
