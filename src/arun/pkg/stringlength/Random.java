package arun.pkg.stringlength;

import java.util.ArrayList;
import java.util.List;

public class Random {
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("a");
		List<Object> objArr = new ArrayList<Object>();
		objArr.addAll(arr);
		objArr.add(1);
		System.out.println(objArr.toString());
	}
}
