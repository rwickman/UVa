import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    for(int testCases = in.nextInt(); testCases > 0; testCases--){
      int minutes = 0;
      int n = in.nextInt(); //1 <= n <= 100
      int myPosition = in.nextInt(); //0 <= m <= n-1
      LinkedList<Integer> myQueue = new LinkedList<>();
      for(int i = 0; i < n; i++){
        myQueue.add(in.nextInt());
      }

      for(int i = 0; myQueue.size() != 0; i++){
          int nextJob= myQueue.pop();
          boolean shouldPrint = true;
        for(int j = 0; j < myQueue.size() ; j++){
          if(myQueue.get(j) > nextJob){
            myQueue.add(nextJob);
            shouldPrint = !shouldPrint;
            break;
          }
        }
        if(shouldPrint){minutes++;}
        if(shouldPrint && myPosition == 0 ){
          System.out.println(minutes);
          break;
        }
        else if(!shouldPrint && myPosition == 0){
          myPosition = myQueue.size() -1;
        }
        else
          myPosition--;
      }
    }
  }
}
