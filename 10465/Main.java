import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      int m = in.nextInt(), n= in.nextInt(), t =in.nextInt();
      //System.out.println(m + " " + n + " " + t);
      int bigBurger = n <= m ? m : n;
      int smallBurger = (bigBurger == m) ? n : m;
      int[] max = new int[t+1];
      Arrays.fill(max,0, smallBurger, -1);
      int maxBurgers= 0;

      for(int i = smallBurger; i <= t; i++){
        if(i % smallBurger == 0){max[i] = i/smallBurger;}
        else if(i % bigBurger == 0){
          int numBig = 1;
          while((i- (numBig*bigBurger)) % smallBurger != 0 && numBig < i){numBig++;}
          max[i] = (numBig == i) ? numBig : numBig + max[i-numBig];
        }
        else{ max[i] = -1; System.out.println("i: " + (i+smallBurger) );}
        maxBurgers = Math.max(max[maxBurgers], max[i]) == max[i] ? i : maxBurgers;
        //System.out.println(max[i]);
      }
      if(maxBurgers < t){System.out.println(max[maxBurgers] + " " + (t-maxBurgers) );}
      else{System.out.println(max[maxBurgers]);}
    }

  }
}
