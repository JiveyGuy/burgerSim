public class Line
{
  private static int fights = 0;
  private static int cuts = 0;
  private Customer[] customers;
  public  int max;
  private int backOfLine = 0;
  private Gen random = new Gen();
  private boolean hasBeenServed = false;
  
  public Line(int length){
    customers = new Customer[length]; 
    this.max = length;
  }
  public void getInLine(Customer newCustomer){
    if( backOfLine == 0 ){
      customers[0] = newCustomer;
      backOfLine++;
    } else {
      if( backOfLine == 5 ){
        Simulation.$("Hey buddy, there is no room in this line, get lost." );
      } else {
        customers[backOfLine] = newCustomer;
        customers[backOfLine].getServed();
        backOfLine++;
        if( random.gGen(1) % 2  == 0 ){
          fights++;
        }
      }
    }
    
  }

public void bubbleSort(Customer[] array) {
    boolean swapped = true;
    int j = 0;
    Customer tmp;
    while (swapped) {
        swapped = false;
        j++;
        for (int i = 0; i < array.length - j; i++) {
            if (array[i].wait > array[i + 1].wait 
                  && array[i].wait != -1 
                  && array[i + 1]  != -1) {
                tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                swapped = true;
            }
        }
    }
    customers = array;
}

public Customer getOutOfLine(){
  if(backOfLine == 5 ){
    int temp = backOfLine;
    backOfLine--;
    return customers[temp];
  }
  int temp = backOfLine;
  backOfLine--;
  hasBeenServed = false;
  return customers[temp];
}

public int getLength(){
  return backOfLine; 
}

public Customer ellapse(int hour, int minute){
  if(customers[0].ellapse()){
    customers[0].leave(hour, minute);
    return getOutOfLine();
  } return new Customer(-1, -1);
}


}