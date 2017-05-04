public class Customer{
    private String name;
    private int age;
    private boolean isFat;
    private int[] arrival;
    private int[] leave;
    private int wait;
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
        leave = new int[]{hour, minute};
    }

    public int[][] getTime(){
        int result[][] = {arrival, leave};
        return result;
    }

    public getServed{
        if(wait == null)
            wait = customerRand.rGen(2, 14);
    }

    public boolean wait(){
        if(wait == 0){
            return false;
        } else { wait--;
            return true;
        }
    }
}
