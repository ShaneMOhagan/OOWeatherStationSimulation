package webpage_package;

public class WebPageFactory {
	
	public WebPage createWebPage(String type) {
		if(type.equals("NY")) {
			return new NYWebPage();
		}
		else if(type.equals("ATL")) {
			return new ATLWebPage();
		}
		else if(type.equals("SEA")) {
			return new SEAWebPage();
		}
		else if(type.equals("DEN")) {
			return new DENWebPage();
		}
		else if(type.equals("LA")) {
			return new LAWebPage();
		}
		else if(type.equals("MIA")) {
			return new MIAWebPage();
		}
		else {
			return new NYWebPage();
		}
	}
}