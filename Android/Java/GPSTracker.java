package com.example.destinationtrendes;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;



public class GPSTracker extends Service implements LocationListener {

	private Context context=null;
	boolean isGPSenabled=false;
	boolean isNetworkEnabled=false;
	boolean canGetLocation=false;
	double latitude;
	double longitude;
	
	Location location;
	
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATE=100;
	private static final long MIN_TIME_CHANGE_UPDATE=9000;

	protected LocationManager locationManager;
	
	public GPSTracker(Context context)
	{
		this.context=context;
		getLocation();
	}
	
	public Location getLocation() {
		
		locationManager=(LocationManager) context.getSystemService(LOCATION_SERVICE);
		isGPSenabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	 isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	 if(!isGPSenabled&&!isNetworkEnabled)
	 {
		 
		 
		 
	 }
	 else 
	 {
		 
		this.canGetLocation=true;
		if(isNetworkEnabled)
		{
			
			locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, MIN_TIME_CHANGE_UPDATE, MIN_DISTANCE_CHANGE_FOR_UPDATE, this);
		
		    if(locationManager!=null)
	        {
	        	location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	        	if(location!=null)
	        	{
	        	latitude=location.getLatitude();
	        	longitude=location.getLongitude();
	        	//Toast.makeText(getApplicationContext(), "Your Location is:\n"+latitude+" ,"+longitude,Toast.LENGTH_LONG).show();
	        	}
	        }
		}
		if(isGPSenabled)
		{
			locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, MIN_TIME_CHANGE_UPDATE, MIN_DISTANCE_CHANGE_FOR_UPDATE, this);
	        if(locationManager!=null)
	        {
	        	
	        	location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	        	if(location!=null)
	        	{
	        	latitude=location.getLatitude();
	        	longitude=location.getLongitude();
	        	//Toast.makeText(getApplicationContext(), "Your Location is:\n"+latitude+" ,"+longitude,Toast.LENGTH_LONG).show();;
	        	}
	        }
			
			
		}
	 }
		
		return location;
		
		
	}
	
	
	public void stopUsingGPS()
	{
		
		if(locationManager!=null)
		{
			locationManager.removeUpdates(GPSTracker.this);
		}
		
	}
	 public double getLatitude() {
		 
		 if(location!=null)
		 {
			 latitude=location.getLatitude();
		 }
		return latitude;
	}
	 
	 public double getLongitude() {
		 
		 if(location!=null)
		 {
			longitude=location.getLongitude();
		 }
		return longitude;
	}
	 
	 public Boolean canGetLocation()
	 {
		return this.canGetLocation;	 
	 }
	 public void showSettingAlert()
	 {
		 AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
		 alertdialog.setTitle("GPS is not enabled");
		 alertdialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
			   Intent intent=new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			   context.startActivity(intent);
			}
		});
		 alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				
			}
		});
		 alertdialog.show();
	 }

	@Override
	public void onLocationChanged(Location location) {
		
		class Post extends AsyncTask<String, Void, Void> {
			 private final Context context;
			 
			    public Post(Context c){
			        this.context = c;
			        
			    }
			
			protected Void doInBackground(String... params) {
		        try {
		       
		        	 String postReceiverUrl = "http://192.168.137.1/project/get_data.php";
		            
		              
		             // HttpClient
		             HttpClient httpClient = new DefaultHttpClient();
		              
		             // post header
		             HttpPost httpPost = new HttpPost(postReceiverUrl);
		      
		             // add your data
		          
		             String coodinate1=Double.toString(latitude);
		             String coodinate2=Double.toString(longitude);
		             List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		             nameValuePairs.add(new BasicNameValuePair("latitude", coodinate1));
		             nameValuePairs.add(new BasicNameValuePair("longitude", coodinate2));
		             
		             httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		      
		             // execute HTTP post request
		             HttpResponse response = httpClient.execute(httpPost);
		             HttpEntity resEntity = response.getEntity();
		              
		           

		 
		        } catch (MalformedURLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return null;
		    }
		}//Toast.makeText(getApplicationContext(), "Your Location is:\n"+location.getLongitude()+" ,"+location.getLatitude(),Toast.LENGTH_LONG).show();;
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
