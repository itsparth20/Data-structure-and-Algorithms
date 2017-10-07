package com.program.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class FindPeak {
	static Map<String, List<Double>> map = new HashMap<>();

	public static void main(String[] args) {		
	}
	
	//Calculate map
    public static void accumulate(String idx, String spaceId, double v, double w) {
        map.putIfAbsent(idx, new ArrayList<Double>(2));
        List<Double> arr = map.get(idx);
        arr.add(0, arr.get(0)+(v*w));
        arr.add(1, arr.get(1)+(w));
        map.put(idx, arr);  
    }
    
    //get Peak
    public static Double getPeak(){
    	OptionalDouble peak = map.entrySet().stream().mapToDouble(t -> t.getValue().get(1) != 0 ? t.getValue().get(0)/t.getValue().get(1) : 0).max();
    	return peak.isPresent()?peak.getAsDouble()*100:0;
    }	
}
