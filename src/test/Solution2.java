package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
	
	

	public static void main(String[] args) {
		new Solution2().solution(
				"Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00");
	}

	public int solution(String S) {
		int result = 0;
		// days of week
		String[] dow = new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
		BufferedReader br = new BufferedReader(new StringReader(S));
		List<String> m = new ArrayList<>();
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				m.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, List<String>> week = new HashMap<>();
		for (String meeting : m) {
			String day = meeting.substring(0, 3);

			String start = meeting.substring(4, meeting.indexOf("-"));
			String end = meeting.substring(meeting.indexOf("-") + 1);
			List<String> s = week.get(day);
			if (s == null) {

				s = new ArrayList<>();

			}
			s.add(start);
			s.add(end);
			Collections.sort(s, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int h1 = getHour(o1);
					int h2 = getHour(o2);
					int m1 = getMinute(o1);
					int m2 = getMinute(o2);
					if (h1 == h2) {
						return m1 - m2;
					}
					return h1 - h2;
				}

			});
			week.put(day, s);
		}
		//A list with hours transformed in minutes
		List<Integer> hourstomin = new ArrayList<>();
		int day = 0;
		int minPerDay = 24*60;
		for (String string : dow) {
			List<String> temp = week.get(string);
			if(temp!=null) {
				for (String t : temp) {
					int mins = toMinutes(t)+minPerDay*day; //add minutes of previous day
					hourstomin.add(mins);
				}
			}
			day++;
		}
		int maxRest = 0;
		for(int i = 0;i<hourstomin.size()-1;i++) {
			if(i==0) {
				result = hourstomin.get(i);
			}else {
				if(i%2>0) {
					result = hourstomin.get(i+1)-hourstomin.get(i);
				}
			}
			if(result>maxRest) {
				maxRest=result;
			}
		}
		result=maxRest;
		return result;
	}

	private int toMinutes(String t) {
		int h = getHour(t);
		int m = getMinute(t);
		return (h*60)+m;
	}

	private Integer getMinute(String string) {
		return Integer.valueOf(string.substring(string.indexOf(":") + 1));
	}

	private Integer getHour(String string) {
		return Integer.valueOf(string.substring(0, string.indexOf(":")));
	}

}
