package decorator_temp;

public class ConvertF implements WebTemp {
	@Override 
	public double convertDegrees(double num1) {
		double degreesF = ((num1 - 273.15) *(9.0/5.0)) +32;
		return degreesF;
	}
}