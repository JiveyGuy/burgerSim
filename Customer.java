public class Customer{
  private String name;
  private int age;
  private boolean isFat;
  public int[] arrival;
  private int[] leave;
  public int wait = -1;
  private Gen customerRand = new Gen();
  public Customer(int hour, int minute){
    this.name  = customerRand.nGen();
    this.age   = (int) customerRand.gGen(17);
    this.isFat = customerRand.scale();
    arrival =  leave = new int[]{hour, minute};
  }
  
  public String  toString(){
    return "My name is " + name + " and I am " + age + " years old, "  +  (( isFat == true ) ?  "sadly I am overweight " : "I can happilly say I am not fat. \n" ) ;
  }
  
  public void leave(int hour, int minute){
    if(wait == 0)
      leave = new int[]{hour, minute};
  }
  
  public int[][] getTime(){
    int result[][] = {arrival, leave};
    return result;
  }
  
  public void getServed(){
    if(wait == -1)
      wait = customerRand.rGen(2, 14);
  }
  
  public boolean ellapse(){
    if(wait == 0){
      return false;
    } else { wait--;
      return true;
    }
  }
}