import java.util.*;

class testSplit{
  public static void main(String[]args){
    String test = "SAME AS 22";
    String[] testCases = test.split("\\D");
    System.out.println(testCases[testCases.length -1]);
    for(String t: testCases){
    System.out.println(t);
    }
  }
}
