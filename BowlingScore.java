import java.io.*;
import java.util.*;

public class BowlingScore {
  public static void main(String[] args) {
    try {
      File file = new File("inp.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
		System.out.print(data + " ==> ");
        System.out.println(getScore(data));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public static int getScore(String frames){
	  String[] turns = frames.split("\\s+");
	  int result = 0;
	  
	  for(int i = 0; i < 10; i++){
		  if(turns[i].equals("x")){
			  if(turns[i + 1].equals("x") && turns[i + 2].equals("x")){
				  result += 30;
			  } else if(turns[i + 1].equals("x")){
				  result += 20 + Character.getNumericValue(turns[i + 2].charAt(0));
			  } else if(turns[i + 1].charAt(1) == '/'){
				  result += 20;
			  }else {
				  int num = Integer.parseInt(turns[i + 1]);
				  result += 10 + (num / 10) + (num % 10);
			  }
		  } 
		  
		  else if (turns[i].charAt(1) == '/'){
			  if(turns[i + 1].equals("x")){
				  result += 20;
			  }else {
				  result += 10 + Character.getNumericValue(turns[i + 1].charAt(0));
			  }
		  }
		  else {
			  int num = Integer.parseInt(turns[i]);
			  result += (num / 10) + (num % 10);
		  }
	  }
	  
	  return result;
  }
}