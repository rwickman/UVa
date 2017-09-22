import java.util.*;

public class Main{
  public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    ArrayList<String> relevantPages = new ArrayList<String>();
    int t = in.nextInt();

    String nextUrl;
    int relevance;

    for(int testCases = 1; testCases <= t; testCases++){
      relevantPages.add(in.next());
      int currHighestRelevance = in.nextInt();
      for(int j = 0; j < 9 ; j++){

         nextUrl = in.next();
         relevance = in.nextInt();

         if(relevance > currHighestRelevance){
           relevantPages.clear();
           relevantPages.add(nextUrl);
           currHighestRelevance = relevance;
         } else if(relevance >= currHighestRelevance){
           relevantPages.add(nextUrl);
         }
      }

      System.out.println("Case #" + testCases + ":");
      for(String page : relevantPages){
        System.out.println(page);
      }
      relevantPages.clear();
    }

  }
}
