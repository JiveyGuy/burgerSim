import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ServingLine<Key> 
{
  public int nOfLines = 0;
  Line[] lines;
  public String stats;
  int maxWait = 0;
  int avgLength = 0;
  int maxLength = 0;
  int emptyEvents = 0;
  
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
  
  public boolean isEmpty() {
    return nOfLines == 0;
  }
  
  public boolean joinLine(Customer newCustomer){
    Arrays.sort(lines);
    if( lines[0].getLength() == lines[0].max )
      return false;
    else {
      lines[0].getInLine(newCustomer);
      return true;
    } 
    
  }
  
  

  
  public void ellapse(int hour, int minute){
    for(int count = 0; count < nOfLines; count++){
      Customer temp = lines[count].ellapse(hour, minute);
      if ( temp != null && temp.arrival[0] != -1){
        maxWaitTime(temp.getTime()); 
      }
    }
  }
  
  public void maxWaitTime(int[][] input){
    int time =  ( ( input[1][0] * 60 ) + input[1][1] )  -  ( ( 60 * input[0][0]) + input[0][1] );
    if( time > maxWait ){
      maxWait = time;
    }
    
  }
  public void avgLineLength(){
    int sum = 0;
    for(int count = 0; count < nOfLines; count++){
      sum += lines[count].getLength(); 
    } sum /= nOfLines;
    avgLength += sum;
    avgLength /= 2;
  }
  
  public void maxLineLength(){
    int max = Integer.MIN_VALUE;
    for(int count = 0; count < nOfLines; count++){
      if( max < lines[count].getLength())
        max = lines[count].getLength(); 
    } 
    if( max > maxLength )
      maxLength = max;
  }
  
  public void emptyCheck(){
    for(int count = 0; count < nOfLines; count++){
      if( lines[count].getLength() == 0)
        emptyEvents++; 
    }
  }
}