package com.nwea.test;

import java.util.ArrayList;
import java.util.List;

public class Flattener {
	
	public Flattener() {
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> flatten(List<Object> input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// null check
		if ((input == null) || (input.size() == 0)) {
			return result;
		}
		
		for (int i = 0; i < input.size(); i++) {
			Object item = input.get(i);
			
			// check for a list
			if (item instanceof List) {
				List<Object> subList = (List<Object>) item;
				result.addAll(flatten(subList));
			} else {
			// otherwise assume Integer
				Integer newInteger = (Integer) item;
				result.add(newInteger);
			}
		}
		
		return result;
	}
}
