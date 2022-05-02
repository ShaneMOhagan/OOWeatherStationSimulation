package webpage_package;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import template_datetime.GMT4DateTime;

public class NYWebPage extends WebPage{
	public String getCityName() {
		return "New York City, New York, United States";
	}
	
	public String getCityImage() {
		return "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F02%2F19%2Fnew-york-city-evening-NYCTG0221.jpg&w=1100&h=737&c=sc&poi=face&q=60";
	}
	
	public String getCityDateTime() {
		GMT4DateTime gmt4 = new GMT4DateTime();
		return gmt4.createDateTime();
	}
	
	public String[] getCityTemp() {
		String temp[] = new String[] {};
		try {
			temp = NYWebPage.call_meNY();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
		public static String[] call_meNY() throws Exception {
			String url = "https://api.openweathermap.org/data/2.5/onecall?lat=39.74&lon=-104.99&exclude=hourly,daily&appid=7a0ebe7b84c6dee8ee2563d84cc943d2&format=json";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			//con.setRequestMethod("Get");
			//con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'Get' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			System.out.println(response.toString());
			
			String[] elements = response.toString().split(",");
			List<String> fixedLenghtList = Arrays.asList(elements);
			ArrayList<String> listOfString = new ArrayList<String>(fixedLenghtList);
			String wind = listOfString.get(7);
			
			String[] Helements = response.toString().split(",");
			List<String> HfixedLenghtList = Arrays.asList(Helements);
			ArrayList<String> HlistOfString = new ArrayList<String>(HfixedLenghtList);
			String Hwind = HlistOfString.get(10);
			
			String[] Delements = response.toString().split(",");
			List<String> DfixedLenghtList = Arrays.asList(Delements);
			ArrayList<String> DlistOfString = new ArrayList<String>(DfixedLenghtList);
			String Dwind = DlistOfString.get(11);
			
			String[] Welements = response.toString().split(",");
			List<String> WfixedLenghtList = Arrays.asList(Helements);
			ArrayList<String> WlistOfString = new ArrayList<String>(WfixedLenghtList);
			String Wwind = WlistOfString.get(15);
			
			String[] Nelements = wind.split(":");
			List<String> NfixedLenghtList = Arrays.asList(Nelements);
			ArrayList<String> NlistOfString = new ArrayList<String>(NfixedLenghtList);
			System.out.println(wind);
			String Nwind = NlistOfString.get(1);
			
			String[] HHelements = wind.split(":");
			List<String> HHfixedLenghtList = Arrays.asList(HHelements);
			ArrayList<String> HHlistOfString = new ArrayList<String>(HHfixedLenghtList);
			System.out.println(Hwind);
			String HHwind = HHlistOfString.get(1);
			
			String[] DDelements = wind.split(":");
			List<String> DDfixedLenghtList = Arrays.asList(DDelements);
			ArrayList<String> DDlistOfString = new ArrayList<String>(DDfixedLenghtList);
			System.out.println(Dwind);
			String DDwind = DDlistOfString.get(1);
			
			String[] WWelements = wind.split(":");
			List<String> WWfixedLenghtList = Arrays.asList(WWelements);
			ArrayList<String> WWlistOfString = new ArrayList<String>(WWfixedLenghtList);
			System.out.println(Wwind);
			String WWwind = WWlistOfString.get(1);
			
			System.out.println(Nwind);
			String return_data[] = new String[] {Nwind, HHwind, DDwind, WWwind};
			return(return_data);
			//JSONObject myResponse = new JSONObject(response.toString());
			//System.out.println("latitude- "+myResponse.getString("lat"));
		}
}