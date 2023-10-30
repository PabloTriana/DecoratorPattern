public class SteamedMilk extends CondimentDecorator{

    public SteamedMilk(Beverage b){
        this.beverage = b;
    }
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Steamed Milk";
	}
	
	@Override
	public double cost() {
		return .10 + beverage.cost();
	}
    
}
