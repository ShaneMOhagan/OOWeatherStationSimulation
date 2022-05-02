package test;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
//import org.json.simple.JSONObject;

public class tester {
	public String ruff(){
		String out = "out";
		try {
			out = tester.call_me();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	//public static void main(String[] args) {
		//try {
			//tester.call_me();
		//} catch (Exception e) {
			//e.printStackTrace();
		//}
	//}	
		public static String call_me() throws Exception {
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
			String wind = listOfString.get(15);
			
			String[] Nelements = wind.split(":");
			List<String> NfixedLenghtList = Arrays.asList(Nelements);
			ArrayList<String> NlistOfString = new ArrayList<String>(NfixedLenghtList);
			System.out.println(wind);
			String Nwind = NlistOfString.get(1);
			
			//System.out.println(Nwind);
			return(Nwind);
			//JSONObject myResponse = new JSONObject(response.toString());
			//System.out.println("latitude- "+myResponse.getString("lat"));
		}
}
	