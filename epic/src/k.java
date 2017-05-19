import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.HashSet; 
import java.util.Scanner; 
import java.util.Set; 

/*Determine whether a number is colorful or not. 263 is a colorful number because (2,6,3,2x6,6x3,2x3x6) are all different whereas 236 is not because (2,3,6,2x3,3x6,2x3x6) have 6 twice. So take all consecutive subsets of digits, take their product and ensure all the products are different*/ 


public boolean isColorful(String number){ 
	int len=number.length(); 
	ArrayList<Integer> intarray = new ArrayList<Integer>();Integer val = null; 
	if (number != null) {	
		for (int i = 0; i < len; i++) 
			intarray.add(Integer.parseInt(String.valueOf(number.charAt(i)))); 
	}	
	if(intarray.size()==2 ||intarray.size()>10 ||intarray.contains(0)||intarray.contains(1)) 
		return false;	
	Set<Integer> set = new HashSet<Integer>(intarray); 

	//Check if the number contains duplicates 
	if(set.size() < intarray.size()) 
		return false; 
	else{ 
		for(int i=0;i<intarray.size();i++){ 
			set.add(intarray.get(i)); 
		} 
		for(int i=0;i<=intarray.size()/2;i++){ 
			val=intarray.get(i)*intarray.get(i+1); 
			boolean value =set.add(val); 
			if(!value) return false; 
		}} 
	return true; 
} 

public static void main(String arg[]){ 
	colorfulNumber c=new colorfulNumber(); 
	System.out.println(c.isColorful("263")); 
}