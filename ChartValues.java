package application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.json.*;

public class ChartValues {

	private final String USER_AGENT = "Mozilla/5.0";

	// HTTP POST request return arraylist
	
	protected ArrayList<API1> sendPost() throws Exception 
        {
		String url = "http://104.236.233.81:8080/StreamingDemo/services/StreamingDemoServices/get_streaming_list?api_key=lattice";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection(); // open http connection

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes("");
		wr.flush();
		wr.close();


		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));                
                
                JsonReader rdr = Json.createReader(in);  
                JsonObject obj1 = rdr.readObject();
                JsonArray results = obj1.getJsonArray("list");
                ArrayList<API1> api_list = new ArrayList<API1>();
                for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                   
                	API1 ao = new API1();                 
                    ao.setId(result.getInt("id"));
                    ao.setParam1(result.getString("param1"));
                    ao.setParam2(result.getString("param2"));
                    ao.setDate(result.getString("datetime"));
                    api_list.add(ao);
                }
                in.close(); 
                
                for(int i = 0; i<api_list.size();i++)
                {
                   // System.out.println(ao);
                    System.out.println(api_list.get(i));
                }
                return api_list;
	}
}

// Bean Class
class API1
{
    int id;
    String param1;
    String param2;
    String date;
    
    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getParam1() {
		return param1;
	}



	public void setParam1(String param1) {
		this.param1 = param1;
	}



	public String getParam2() {
		return param2;
	}



	public void setParam2(String param2) {
		this.param2 = param2;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
    public String toString()
    {
        return "id:" + id + ", param1:" + param1 + ", param2:"+ param2 + ", date:" + date;
    }
}
