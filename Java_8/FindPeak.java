package com.program.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class FindPeak {
	Map<String, List<Double>> state = new HashMap<>();

    public void accumulate(String idx, String spaceId, double v, double w) {
        state.putIfAbsent(idx, new ArrayList<>());
        List<Double> list = state.get(idx);
            list.add(v*w);
            list.add(w);
	}

    public double result() {

        OptionalDouble peak = state.entrySet().stream()
									.mapToDouble(t -> t.getValue().get(1) != 0 ? t.getValue().get(0)/t.getValue().get(1): 0)
									.max();

		return peak.isPresent()?peak.getAsDouble()*100:0;

    }
	public static void main(String[] args) {		
	}
}
