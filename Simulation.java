import java.util.Scanner;
public class Simulation{
  private static int n;
  private static int m;
  private static int x;
  private static int t;
  private static int hour = 8;
  private static int minute = 0;
  private static int day = 1;
  private static ServingLine lines;
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
      lines = new ServingLine(n, 8);
      
      $("Starting sim loop...");
      Customer temp;
      for(int count = 0; count < t * 60; count++){
        tick();
        for(int rate = 0; rate < m; rate++){
          temp = new Customer(hour, minute);
          $(temp + "");
          lines.joinLine(temp);
        }
        lines.ellapse(hour, minute);
        if( minute % 10 == 0 )
          $("Time = " + hour + ":" + minute);
        lines.serve();
      }
      timeToExit = true;
    }
  }
  private static void $(String in){
    if(DEBUG) try{
      System.out.printf("$ %s\n", in); 
    } catch (Exception e ){}
  }
  
  private static void tick(){
    if(hour == 16 ){
      day++;
      hour = 8;
      lines = new ServingLine(n, 8);
    } else if ( minute == 60 ){
      hour++;
      minute = 0;
    } else    
      minute++;
  }
}