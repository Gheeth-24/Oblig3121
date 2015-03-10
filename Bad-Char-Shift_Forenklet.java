import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BadChar{
	public static void main(String args[]) {
		Scanner les = new Scanner(System.in);
		System.out.println ("Skriv haystack Fil Navn :- ");
		String haystack = les.nextLine();
		System.out.println ("Skriv needle Fil Navn :- ");
		String needle = les.nextLine();
		if(haystack.contains(".txt") && needle.contains(".txt")){
			new NeedleFind(new File(haystack),new File(needle));
		}else{
			System.out.println ("Feil Fil Format.Prov paa nytt");
		}
	}
}
