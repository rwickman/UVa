import java.util.*;

class Main{
  public static int lastIndex = 0;
  public static String[] instructions = new String[100];
  public static void main(String[]args){
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    int p = 0;
    for(int testCases = 0; testCases< t; testCases++){
      int n = in.nextInt();
      in.nextLine();
      for(int numInstructions = 0; numInstructions < n; numInstructions++){
          p += readInstruction(in.nextLine(), instructions);
        }
        System.out.println(p);
        p = 0;
        lastIndex = 0;
    }
  }
  public static int readInstruction(String instruction, String[] instructions){
    final String  LEFT = "LEFT";
    final String RIGHT = "RIGHT";
    if(instruction.equals(LEFT)){
      instructions[lastIndex] = LEFT;
      lastIndex++;
      return -1;
    }
    else if(instruction.equals(RIGHT)){
      instructions[lastIndex] = RIGHT;
      lastIndex++;
      return 1;
    }
    else{
        String[] digit = instruction.split("\\D");
        String sameAs = instructions[Integer.parseInt(digit[digit.length-1]) -1];
       if (sameAs.equals(LEFT)){
         instructions[lastIndex] = LEFT;
         lastIndex++;
         return -1;
       }
       else{
         instructions[lastIndex] = RIGHT;
         lastIndex++;
         return 1;
       }
    }
  }
}
