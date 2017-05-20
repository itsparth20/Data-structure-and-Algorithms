package practiceProblem;

/*
 * PROBLEM

AngelList users frequently select locations from a dropdown, either to specify where they currently live, or to filter down job listings by location.

Let's say we have a JSON list of locations:

[
  {"id": 1, "name": "San Francisco Bay Area", "parent_id": null},
  {"id": 2, "name": "San Jose", "parent_id": 3},
  {"id": 3, "name": "South Bay", "parent_id": 1},
  {"id": 4, "name": "San Francisco", "parent_id": 1},
  {"id": 5, "name": "Manhattan", "parent_id": 6},
  {"id": 6, "name": "New York", "parent_id": null}
]

We'd like to generate a list of the locations, with sublocations grouped under their parents, and in alphabetical order. 
We want to indent sub-locations with a hyphen. So the resulting output for the above data would look like this:

OutPut:

New York
-Manhattan
San Francisco Bay Area
-San Francisco
-South Bay
--San Jose

Rules are:

Child locations should be immediately after their parent, with an extra dash prepended.
Locations of the same level of depth should be alphabetically sorted.
Assume that the actual list of locations will be longer (up to 100 locations), and have max up to 5 levels of depth.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AngelListTest {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		ArrayList<Data> list = new ArrayList<Data>();
		JSONArray jsonArray = new JSONArray(input);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Data dataObj = new Data(jsonObj.getString("id"), jsonObj.getString("parent_id"), jsonObj.getString("name"));
			list.add(dataObj);
		}
		List<Data> parent = new ArrayList<Data>();
		for (Data obj : list) {
			if (obj.parent_id.equals("null"))
				parent.add(obj);

			for (Data child : list) {
				if (obj.id.equals(child.parent_id))
					obj.childList.add(child);

			}
		}

		// list.stream().forEach(System.out::println);

		Collections.sort(parent, new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		});
//		parent.stream().forEach(System.out::println);
		for (Data data : parent)
			printValue(data, "");
	}

	private static void printValue(Data data, String addStr) {
		System.out.println(addStr + data.name);
		if (data.childList.size() > 0) {
			Collections.sort(data.childList, new Comparator<Data>() {
				@Override
				public int compare(Data o1, Data o2) {
					// TODO Auto-generated method stub
					return o1.name.compareTo(o2.name);
				}
			});
			for (Data child : data.childList) {
				printValue(child,addStr+"-");
			}
		}
		
	}

}

class Data {
	String id;
	String parent_id;
	String name;
	List<Data> childList;

	/**
	 * @param id
	 * @param parent_id
	 * @param name
	 */
	public Data(String id, String parent_id, String name) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		childList = new ArrayList<Data>();
	}

	Data() {
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{ id= " + this.id + " " + "Name= " + this.name + " " + "parent_id= " + this.parent_id + ", child= ");
		if (childList.size() > 0) {
			for (Data data : childList) {
				sb.append(data.id + ", ");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
}
