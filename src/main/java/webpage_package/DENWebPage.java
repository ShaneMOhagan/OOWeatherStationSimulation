package webpage_package;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import template_datetime.GMT6DateTime;
import test.tester;

public class DENWebPage extends WebPage{
	public String getCityName() {
		return "Denver, Colorado, United States";
	}
	
	public String getCityImage() {
		return "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Denver_skyline.jpg/532px-Denver_skyline.jpg";
	}
	
	public String getCityDateTime() {
		GMT6DateTime gmt6 = new GMT6DateTime();
		return gmt6.createDateTime();
	}
	public String[] getCityTemp() {
		String temp[] = new String[] {};
		try {
			temp = DENWebPage.call_meDen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
		public static String[] call_meDen() throws Exception {
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
			
			//System.out.println(Nwind);
			//return(Nwind);
			//JSONObject myResponse = new JSONObject(response.toString());
			//System.out.println("latitude- "+myResponse.getString("lat"));
		}
}