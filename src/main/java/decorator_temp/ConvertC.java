package decorator_temp;

public class ConvertC implements WebTemp {
	@Override 
	public double convertDegrees(double num1) {
		double degreesF = num1 - 273.15;
		return degreesF;
	}
}