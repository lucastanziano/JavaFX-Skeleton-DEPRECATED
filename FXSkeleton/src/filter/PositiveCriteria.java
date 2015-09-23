package filter;

public class PositiveCriteria implements ICriteria<Integer>{

	
	
	public PositiveCriteria(){

	}
	
	

	@Override
	public boolean isValid(Integer data) {
		
		return data.intValue() > 0;
	}
	
	



}
