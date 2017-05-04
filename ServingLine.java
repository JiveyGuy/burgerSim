import java.util.Arrays;

public class ServingLine 
{
  public int nOfLines;
  Line[] lines;
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
}