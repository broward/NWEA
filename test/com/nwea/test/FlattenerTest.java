package com.nwea.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FlattenerTest {
	private static Flattener flattener = new Flattener();

	
	@Test
	public void testNull() {
		List<Object> input = null;
		
		ArrayList<Integer> result = flattener.flatten(input);
		
		assertNotNull("result should not be null", result);
		assertTrue("result should be empty list", result.size() == 0);
	}

	@Test
	public void testEmpty() {
		List<Object> input = getBaseList();
		
		ArrayList<Integer> result = flattener.flatten(input);
		
		assertNotNull("result should not be null", result);
		assertTrue("result should be empty list", result.size() == 0);
	}
	
	@Test
	public void testDuplicateValues() {
		List<Object> input = getPopulatedList();
		input.add(input.get(0));
		
		ArrayList<Integer> result = flattener.flatten(input);
		
		assertNotNull("result should not be null", result);
		assertTrue("result should have two items", result.size() == 2);
	}
	
	@Test
	public void testEmbeddedList() {
		List<Object> input = getPopulatedList();
		input.add(getPopulatedList());
		
		ArrayList<Integer> result = flattener.flatten(input);
		
		assertNotNull("result should not be null", result);
		assertTrue("result should have two items", result.size() == 2);
	}
	
	@Test
	public void testNestedLists() {
		List<Object> input = getPopulatedList();
		List<Object> input2 = getPopulatedList();
		List<Object> input3 = getPopulatedList();
		
		input2.add(input3);
		input.add(input2);
		
		ArrayList<Integer> result = flattener.flatten(input);
		System.out.println(result.size());
		
		assertNotNull("result should not be null", result);
		assertTrue("result should have 3 items", result.size() == 3);
	}
	
	private List<Object> getBaseList() {
		List<Object> list = new ArrayList<Object>();
		return list;
	}
	
	private List<Object> getPopulatedList() {
		List<Object> list = getBaseList();
		list.add(1);
		return list;
	}
}
