package com.example.destinationtrendes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Business extends Activity {
	String data = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
		
		
		 class PostDataAsyncTask extends AsyncTask<String, String, String> {
			 
		        protected void onPreExecute() {
		            super.onPreExecute();
		            // do stuff before posting data
		        }
		 
		        @Override
		        protected String doInBackground(String... strings) {
		        	
		        	
		                 
		        	Log.d("doin"," inside doin");
					HttpClient client=new DefaultHttpClient();
					String result="";
					HttpGet get=new HttpGet("http://192.168.137.1/project/get_area.php");
					HttpResponse response = null;
					try {
						response = client.execute(get);
					} catch (ClientProtocolException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					try {
						
						BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
						StringBuffer buffer=new StringBuffer("");
						String line="";
						//String NL=System.getProperty("line.separator");
						while((line=reader.readLine())!=null)
							buffer.append(line);
						reader.close();
						data=buffer.toString();
						Log.d("doin", result);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return result;
		
		        }
		 
		        @Override
		        protected void onPostExecute(String lenghtOfFile) {
		            // do stuff after posting data
		        	Log.d("data recvd", data);
		        	
		        }
		    }

			 new PostDataAsyncTask().execute();
		
			 List<String> placesList = Arrays.asList(data.split(","));
		
		ListView mainListView = (ListView) findViewById( R.id.listView1);  
		  
		ArrayList<String> placesList1 = new ArrayList<String>();
		 JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(data);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        // Getting JSON Array node
        JSONArray places = null;
		try {
			places = jsonObj.getJSONArray("Result");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        // looping through All Contacts
        for (int i = 0; i < places.length(); i++) {
            JSONObject c = null;
			try {
				c = places.getJSONObject(i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
            String name = null;
			try {
				name = c.getString("name");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            placesList1.add(name);
        }
		
	
		
		
		String[] items={"","","","","","","Recommended Locations for Opening Outlets:",placesList1.get(1),placesList1.get(2),placesList1.get(3),placesList1.get(4),placesList1.get(5)};  
		ArrayList<String> List = new ArrayList<String>();  
	  List.addAll( Arrays.asList(items) ); 
	    ArrayAdapter<String>adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
	 mainListView.setAdapter(adapter);
	}

	
}
