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

import android.R.string;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Personal extends Activity {
	String data;
	private ListView mainListView ;  
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal);
		  
		
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
					HttpGet get=new HttpGet("http://192.168.137.1/project/get_other_places.php");
					HttpResponse response = null;
					try {
						response = client.execute(get);
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
					return data;
		
		        }
		 
		        @Override
		        protected void onPostExecute(String lenghtOfFile) {
		            // do stuff after posting data
		        	Log.d("data recvd", lenghtOfFile);
		        }
		    }

			 new PostDataAsyncTask().execute();
		
		
		//mainListView = (ListView) findViewById( R.id.);  
		
		List<String> placesList = Arrays.asList(data.split(","));
		System.out.println(placesList.get(0));
		String[] items={"","","","","","","Trending Places:",placesList.get(1),placesList.get(2),placesList.get(3),placesList.get(4),placesList.get(5)};  
		
		
	    ArrayList<String> planetList = new ArrayList<String>();  
	    planetList.addAll( Arrays.asList(items) ); 
	    ArrayAdapter<String>adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
	 mainListView.setAdapter(adapter);
		
	}

	
}
