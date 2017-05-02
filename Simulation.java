public class Simulation{
  private static int hour = 8;
  private static int minute = 0;
  private static int day = 1;
  private static Gen random = new Gen();
  private static final boolean DEBUG = false;
  
  public static void main(String args[]){
    for(int x  = 0; x < 525600; x++){
      tick(); 
    }
  }
  
  private static void tick(){
    if(hour == 22 ){
      day++;
      hour = 8;
    } else if ( minute == 60 ){
      hour++;
      minute = 0;
      $("Tick, its now day "+ day + " @ " + hour + ":" + minute );
    }
    
    minute++;
  }
  
  private static void $(String in){
    if(DEBUG){ System.out.println(in); } 
  }
}