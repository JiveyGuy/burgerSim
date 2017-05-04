import java.util.Arrays;

public class ServingLine 
{
  public int nOfLines;
  Line[] lines;
  public String stats;
  int[] maxWait = 0;
  public ServingLine(int n, int max)
  {
    n = ( n < 1 ) ? 1 : n;
    n = ( n > 10 ) ? 10 : n;
    lines = new Line[n];
    nOfLines = n;
    for(int count = 0; count < n; count++){
      lines[count] = new Line(max);
    }
  }
  
  public boolean joinLine(Customer newCustomer){
    Arrays.sort(lines);
    if( lines[0].getLength() == lines[0].max )
      return false;
    else try {
      lines[0].getInLine(newCustomer);
    } catch (Exception e){
      
    }
    return true;
  }
  
  
  public void serve(){
    for(int count = 0; count < nOfLines; count++){
      lines[count].serve();
    }
  }
  
  public void ellapse(int hour, int minute){
    for(int count = 0; count < nOfLines; count++){
      lines[count].ellapse(hour, minute); 
    }
  }
  
  public void maxWaitTime(int[][] input){
    int time =  ( ( input[1][0] * 60 ) + input[1][1] )  -  ( ( 60 * input[0][0]) + input[0][1] );
    if( time > maxWait ){
      maxWait = time;
    }
    
  }
  public void updateStats(String in){
    int sum = 0;
    for(int count = 0; count < nOfLines; count++){
      sum += lines[count].getLength(); 
    } sum /= nOfLines;
  }
}