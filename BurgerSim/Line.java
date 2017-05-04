public class Line
{
    private static int fights = 0;
    private static int cuts = 0;
    private Customer[] customers;
    private int backOfLine = 0;
    private Gen random = new Gen();

    public void getInLine(Customer newCustomer) throws Exception{
        if( backOfLine == 0 ){
            customers = new Customer[5];
            customers[0] = newCustomer;
            backOfLine++;
        } else {
            if( backOfLine == 5 ){
                throw new Exception("Hey buddy, there is no room in this line, get lost." );
            } else {
                customers[backOfLine] = newCustomer;
                backOfLine++;
                if( random.gGen(1) % 2  == 0) {
                    cuts++;
                    if( random.gGen(1) % 2  == 0 ){
                        fights++;
                    }
                }
            }
        }
    }

    public Customer getOurOfLine(){
        if(backOfLine == 5 ){
            int temp = backOfLine;
            backOfLine--;
            return customers[temp];
        }
        int temp = backOfLine;
        backOfLine--;
        return customers[temp];
    }
}
