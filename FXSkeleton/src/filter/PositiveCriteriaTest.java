package filter;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class PositiveCriteriaTest {

	@Test
	public void test() {
		List<Integer> result = CriteriaManager.newInstance(new PositiveCriteria()).and(new EvenCriteria()).filter(Arrays.asList(10, 11, -2, -5, 2, 4, 8, 10000));
		//Assert.assertEquals(result.size(), 5);
		System.out.println(result.toString());
	}

}
