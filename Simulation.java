import java.util.Scanner;
public class Simulation{
  private static int n;
  private static int m;
  private static int x;
  private static int t;
  private static int hour = 8;
  private static int minute = 0;
  private static int day = 1;
  private static Gen random = new Gen();
  private static final boolean DEBUG = true;
  public static void main(String args[]){
    //We declare our first keyboard.
    Scanner keyboard = new Scanner(System.in); 
    $("Starting program");
    boolean timeToExit = false;
    while(!timeToExit){
      try{
        System.out.println("Getting input....");
        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        x = Integer.parseInt(args[2]);
        t = Integer.parseInt(args[3]);
      } catch(Exception e){
        System.out.println("Failed input.... try again\n input 4 values delimitted by spaces");
        String tempInput = keyboard.nextLine();
        args = tempInput.split(" ");
        continue; 
      }
      
      $("Making " + n + " lines");
      ServingLine lines = new Serving line(n, 8);
      
      $("Starting sim loop...");
      for(int count = 0; count < t; count++){
        tick();
        
      }
      
    }
  }
  private static void $(String in){
    if(DEBUG)
      System.out.println("$ " + in); 
  }
  
  private static void tick(){
    if(hour == 21 ){
      day++;
      hour = 8;
    } else if ( minute == 60 ){
      hour++;
      minute = 0;
    } else    
      minute++;
  }
}