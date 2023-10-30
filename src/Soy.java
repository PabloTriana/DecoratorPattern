public class Soy extends CondimentDecorator {

    public Soy(Beverage b){
        this.beverage = b;
    }

    @Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}
	
	@Override
	public double cost() {
		return .15 + beverage.cost();
	}
    
}
