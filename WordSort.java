import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;
import java.util.Iterator;

public class WordSort {
	public static void main( String[] args ) throws Exception {
		
		BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));
		Scanner src = new Scanner(stdIn);

		CopyOnWriteArrayList<String> wordList = new CopyOnWriteArrayList<String>();
		int fromIndex = 0;
		int toIndex = 0;
		int count = 0;
		String s = "";

		src.useDelimiter("[.,;:\\n\\s-]+"); //sets delimeters

		if ( args.length == 1 && "-sensitive".equals( args[0] ) ) { //case sensitive method
			while ( src.hasNext() ) { 
				wordList.add( src.next() );
			}
		}
		else if (args.length == 0) { //upper case method
			while ( src.hasNext() ) { 
				wordList.add( src.next().toUpperCase() );
			}
		}
		else {
			throw new IllegalArgumentException(); //exception if args incorrect
		}

		Collections.sort( wordList );

		Iterator<String> it = wordList.iterator();
		while( it.hasNext() ) {
			s = it.next();
			fromIndex = wordList.indexOf( s );
			toIndex = wordList.lastIndexOf( s );
			count = toIndex - fromIndex + 1; 
			if ( wordList.contains( s ) ) {
				wordList.set( fromIndex, s + " " + count );
			}
			if ( it.hasNext() ) {
				wordList.subList( fromIndex + 1, toIndex + 1 ).clear();
			}
		}
		
		System.out.println(wordList);
	}
}