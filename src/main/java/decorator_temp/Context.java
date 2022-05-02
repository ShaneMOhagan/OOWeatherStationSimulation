package decorator_temp;

public class Context {
	private WebTemp strategy;
	
	public Context(WebTemp strategy) {
		this.strategy = strategy;
	}
	
	public double executeStrategy(double num1) {
		return strategy.convertDegrees(num1);
	}
}
