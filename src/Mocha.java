
public class Mocha extends CondimentDecorator {
	public Mocha(Beverage b) {
		this.beverage = b;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
	
	@Override
	public double cost() {
		return .20 + beverage.cost();
	}
}