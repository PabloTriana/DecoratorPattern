public class Whip extends CondimentDecorator {

    public Whip(Beverage b){
        this.beverage = b;
    }

    @Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
	
	@Override
	public double cost() {
		return .10 + beverage.cost();
	}
    
}
