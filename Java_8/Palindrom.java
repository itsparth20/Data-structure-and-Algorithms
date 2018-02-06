String x = "racecar";
boolean b = IntStream.range(0, x.length()).allMatch(i -> x.charAt(i) == x.charAt(x.length() -1 - i));