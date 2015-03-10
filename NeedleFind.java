
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NeedleFind{
	
	Scanner read;
	char [] stack;
	char [] needle;
	ArrayList <Integer> match = new ArrayList<Integer>(); 
	
	NeedleFind(File haystack1,File needle1){
		readFile(haystack,needle);
		findMatch();
	}
	
	void readFile(File haystack1,File needle1){
		try{
			read = new Scanner(haystack1);
			stack = read.nextLine().toCharArray();
			read.close();
			read = new Scanner(needle1);
			needle = read.nextLine().toCharArray();
			read.close();
		}catch(Exception e){
			System.exit(0);
		}		
	}
	
	void findMatch(){
		int [] badCharShift = new int[256];
		int minPath = needle.length;
		
		for(int i = needle.length-1;i>0;i--){
			if(needle[i] == '_' && i != needle.length-1){
				minPath = needle.length - (i + 1);
				break;
			}
		}	
	    	
		System.out.println("MIN PATH ---> " +minPath);
	  		for (int i = 0; i<badCharShift.length; i++){ 
				badCharShift[i] = minPath;	
	   		}
	  		
    	for (int i = 0; i<needle.length-1; i++){
				if(needle[i] != '_'){
				
		    		badCharShift[(int)needle[i]] = Math.min(minPath, (needle.length - 1) - i); 			
			}
    	}
	   	
	   	int offset =0 , scan = 0, maxoffset = stack.length - needle.length;
   		int last = needle.length - 1;
   
	 	while(offset <= maxoffset){
	   		for (scan = last; scan != -1 && (needle[scan] == '_' || needle[scan] == stack[scan+offset]); scan--){
      			if(scan == 0){
  					match.add(offset);
    			}
    			
    		}
 	   	offset += badCharShift[(int)stack[offset+last]];	
 	   	
		}
	}	
		
	void writeToFile(){
		if(match.size() != 0){
			try{
				PrintWriter pw = new PrintWriter("patternmatch.txt");
				for(int i: match){
					for(int j = i; j<needle.length+i ; j++){
						pw.print(stack[j]);
					}
					pw.println();
				}
				pw.close();
			}catch(Exception e ){
				System.err.println("FEIL ved aa skrive til fil");
			}
		}
	}	
}