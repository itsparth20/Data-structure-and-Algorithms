package tries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Folders {
	   public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
	       List<String> list = new ArrayList<>();	       
	      String[] arr = xml.split("<");	       
	      int start;
	       int end;
	       
	      for(String s:arr){
	           if(s.contains("folder name")){
	               start = s.indexOf('=')+2;
	               end = s.lastIndexOf('"');
	               if(s.charAt(start) == startingLetter)
	            	   list.add(s.substring(start,end));
	           }
	       }
	       return list;
	   }
	   
	  public static void main(String[] args) throws Exception {
	       String xml =
	               "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	               "<folder name=\"c\">" +
	                   "<folder name=\"program files\">" +
	                       "<folder name=\"uninstall information\" />" +
	                   "</folder>" +
	                   "<folder name=\"users\" />" +
	               "</folder>";

	      Collection<String> names = folderNames(xml, 'u');
	       for(String name: names)
	           System.out.println(name);
	   }
	}
