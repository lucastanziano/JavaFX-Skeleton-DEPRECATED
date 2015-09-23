package filter;

import java.util.Iterator;
import java.util.List;

import collections.CollectionFactory;

public class CriteriaManager<T> {


	private List<ICriteria<T>> criteriaList = CollectionFactory.newArrayList();
	private List<LogicOperator> operatorList = CollectionFactory.newArrayList();
	
	private CriteriaManager(ICriteria<T> criteria){
		
	}
	
	public static <T> CriteriaManager<T> newInstance(ICriteria<T> criteria){
		return new CriteriaManager<>(criteria);
	}
	
	public CriteriaManager<T> and(ICriteria<T> criteria){
		operatorList.add(LogicOperator.AND);
		criteriaList.add(criteria);
		return this;
	}
	
	public CriteriaManager<T> or(ICriteria<T> criteria){
		operatorList.add(LogicOperator.OR);
		criteriaList.add(criteria);
		return this;
	}
	
	
	public List<T> filter(List<T> items){
		List<T> filtered = CollectionFactory.newArrayList();
		
		for(T item : items){
			if(checkCriteria(criteriaList.iterator(), operatorList.iterator(), item)){
				filtered.add(item);
			}
		}
		
		return filtered;
	}

	private boolean checkCriteria(Iterator<ICriteria<T>> criteriaIt, Iterator<LogicOperator> opIt, T item) {
		if(criteriaIt.hasNext()){
			ICriteria<T> criteria = criteriaIt.next();
			if(opIt.hasNext()){
				LogicOperator op = opIt.next();
				return op.eval(criteria.isValid(item), checkCriteria(criteriaIt, opIt, item));
			}
			else{
				if(criteriaIt.hasNext()){
					throw new IllegalStateException("There are more criteria to evaluate than logic operators");
				}
				return criteria.isValid(item);
			}
		}
		return true;
	}


	
	

}
