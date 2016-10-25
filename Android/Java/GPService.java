package com.example.destinationtrendes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class GPService extends Service
{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		GPSTracker gps;
		System.out.println("pppppppppppppppppppppppppppppp");
		gps=new GPSTracker(GPService.this);
		if(gps.canGetLocation())
		{
			double latitude=gps.getLatitude();
			double longitude=gps.getLongitude();
			Toast.makeText(getApplicationContext(), "Your Location is:\n"+latitude+" ,"+longitude,Toast.LENGTH_LONG).show();
		}
		else
		{
		
			gps.showSettingAlert();
		}
		 return START_STICKY;
	   }
}
