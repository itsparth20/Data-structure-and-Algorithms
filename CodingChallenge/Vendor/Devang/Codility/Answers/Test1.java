package exam.com.devang;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Test1 {

	public static void main(String[] args) {

		String s = "Hello \nhellow";
		String arr[] = s.split("\n");
		System.out.println(Arrays.toString(arr));
		String a = "400-234-090";
		String b = "000-000-000";
		System.out.println(b.compareTo(a));
		
		String S = "00:01:07,400-234-090\n"
				+ "00:05:01,701-000-999\n"
				+ "00:05:00,400-234-090";
		System.out.println(solution(S));
	}

	public static int solution(String S) {
		int cents = 0;
		String[] arr = S.split("\n");
		String[] num = new String[2];
		Map<String, Integer> map= new HashMap<>();
		for(String log : arr){
			num = log.split(",");
			String t = num[0];
			String n = num[1];
			
			//get the time 
			LocalTime time = LocalTime.parse(t);
			int se = time.getSecond();
			int min = time.getMinute();
			int hour = time.getHour();
			int sec = (hour * 60 * 60) + (min * 60) + (se);
			int money = 0;
			if(sec < 300){
				money = (sec * 3); 
			}else{
				money = ( (min * 150) + (sec%60 == 0 ? 0 : 150) + (hour * 60 * 150) );
			}
			cents+=money;
			//add to map
			map.putIfAbsent(n, 0);
			map.put(n, map.get(n)+money);
		}
		
		Integer max=map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
		return cents - max;
	}
	
	

}
