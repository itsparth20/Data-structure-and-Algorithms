/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author itspa
 */
public class CrypticStudioProb {
    public static ArrayList<String> myList = new ArrayList<String>();
	
	public static void main(String[] args) throws NumberFormatException, ScriptException {
		
		Scanner sc = new Scanner(System.in);
		String numStr = sc.nextLine();
		int space =numStr.length()-1;
		int target = sc.nextInt();

		ArrayList tempList= new ArrayList();
		ArrayList finalLust = new ArrayList();
		for(int i=1;i<=space;i++){
			if(i==1){
				myList.add("+");
				myList.add("*");
				myList.add("_");
			}
			else{
				tempList = possible(myList,"+");
				finalLust.addAll(tempList);
				tempList = possible(myList,"*");
				finalLust.addAll(tempList);
				tempList = possible(myList,"_");
				finalLust.addAll(tempList);
				
				myList.clear();
				myList.addAll(finalLust);
				finalLust.clear();
			}
		}
		
		ArrayList<String> expList = expressions(myList, numStr);
		boolean isFound=false;
		System.out.println(new Date());
		for(String str : expList){
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    if(Integer.valueOf(engine.eval(str).toString())==target){
		    	System.out.println(str);
		    	isFound=true;
		    	break;
		    }
		}
		if(!isFound)
			System.out.println("No Expression Found");
		System.out.println(new Date());
	}
	
	public static ArrayList possible(List<String> readyList,String exp){
		
		ArrayList newLst = new ArrayList();
		for(String str : readyList){
			newLst.add(str+exp);
		}
		return newLst;
	}

	public static ArrayList expressions(ArrayList<String> expList, String inputStr){
		ArrayList myList = new ArrayList();
		int loop = inputStr.length();
		StringBuffer buf = new StringBuffer(inputStr);
		for(String exp : expList){
			int i=0;
			int j=1;
			while(i<loop-1){
				if('_'!=exp.charAt(i)){
					buf.insert(j, exp.charAt(i));
					j=j+2;
				}
				else
					j=j+1;
				i++;
			}
			myList.add(buf.toString());
			buf.delete(0, buf.length());
			buf.append(inputStr);
		}
		
		return myList;
	}
}
