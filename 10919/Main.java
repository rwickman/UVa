import java.util.*;

class Main{
  public static void main(String[] args){
  Scanner in = new Scanner(System.in);
    while(true){
      int k = in.nextInt();
      if(k == 0){
        return;
      }
      int m = in.nextInt();
      boolean isValidSelection = true;
      HashSet<Integer> courses = new HashSet<>(k);
      for(int i = k; i > 0; i--){
        courses.add(in.nextInt());
      }
      for(int i = m; i > 0; i--){
        int numC = in.nextInt(), min = in.nextInt();
        int matched = 0;
        for(int j = numC; j> 0; j--){
          if(courses.contains(in.nextInt()))
            matched++;
        }
        if(matched < min)
          isValidSelection = false;

      }
      if(!isValidSelection){
        System.out.println("no");
      }else{
        System.out.println("yes");
      }
    }
  }
}
