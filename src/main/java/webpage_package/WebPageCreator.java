package webpage_package;

public class WebPageCreator {
	private WebPageFactory factory;
	
	public WebPageCreator(WebPageFactory factory) {
		this.factory = factory;
	}
	
	public WebPage generateWebPage(String type) {
		WebPage wp = factory.createWebPage(type);
		return wp;
	}
}