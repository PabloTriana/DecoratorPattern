public class Decaf extends Beverage {

    public Decaf(){
        description = "Decaffeinated Coffee";
    }

    @Override
    public double cost() {
       return 1.05;
    }
    
}
