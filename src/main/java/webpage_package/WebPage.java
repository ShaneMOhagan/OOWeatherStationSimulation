package webpage_package;

public abstract class WebPage {
	
	public String[] generation() {
		String cityInfo = getCityName();
		String cityImage = getCityImage();
		String cityDateTime = getCityDateTime();
		String[] Ddata = new String[] {};
		Ddata = getCityTemp();
		String cityDateTemp = Ddata[0];
		String cityDateH = Ddata[1];
		String cityDateD = Ddata[2];
		String cityDateW = Ddata[3];
		String data[] = new String[] {cityInfo, cityImage, cityDateTime, cityDateTemp, cityDateH, cityDateD, cityDateW};
		return data;
	}
	
	abstract String getCityName();
	
	abstract String getCityImage();
	
	abstract String getCityDateTime();
	
	abstract String[] getCityTemp();
}