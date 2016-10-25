package com.example.destinationtrendes;

import java.util.ArrayList;
import java.util.List;






import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Selection extends Activity {
	Button business,res,ref,cab,location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection);
	
	
		business=(Button) findViewById(R.id.button1);
		business.getBackground().setAlpha(0);
		res=(Button) findViewById(R.id.button2);
		res.getBackground().setAlpha(0);
		cab=(Button) findViewById(R.id.button3);
		cab.getBackground().setAlpha(0);
		location=(Button) findViewById(R.id.button4);
		location.getBackground().setAlpha(0);
		ref=(Button) findViewById(R.id.button5);
		ref.getBackground().setAlpha(0);
		
		
		
		 List<String> list = new ArrayList<String>();
	       list.add("Personal");
	       list.add("Trending:Nearby");
	       list.add("Trending: In City");
	     
	    
	       //create an ArrayAdaptar from the String Array
	       ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	               android.R.layout.simple_spinner_item, list);
	       //set the view for the Drop down list
	       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       //set the ArrayAdapter to the spinner
	       
	       
	       
	       
	       
	       
	location.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			     //  if(personal.equals("Trending: In City"))
			       {
			    	   Toast.makeText(getBaseContext(),"Personal",Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(Selection.this,Personal.class);
						startActivity(intent);
			       }
			      // else if(subject.equals("Trending:Nearby"))
			      /* {
			    	   Toast.makeText(getBaseContext(),"Personal",Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(Selection.this,Personal2.class);
						startActivity(intent);
			       }
			     */
				
			}
		});
	
	cab.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		     //  if(personal.equals("Trending: In City"))
		       {
		    	   Toast.makeText(getBaseContext(),"Personal",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(Selection.this,UserSimilarity.class);
					startActivity(intent);
		       }
		      // else if(subject.equals("Trending:Nearby"))
		      /* {
		    	   Toast.makeText(getBaseContext(),"Personal",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(Selection.this,Personal2.class);
					startActivity(intent);
		       }
		     */
			
		}
	});
		
	business.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Toast.makeText(getBaseContext(),"Business",Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(Selection.this,Business.class);
			startActivity(intent);
			
		}
	});
res.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Toast.makeText(getBaseContext(),"Restaurants",Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(Selection.this,Restaurant.class);
			startActivity(intent);
			
		}
	});

ref.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		Toast.makeText(getBaseContext(),"Refreshing....",Toast.LENGTH_SHORT).show();
		
		Toast.makeText(getBaseContext(),"Fetching Data....",Toast.LENGTH_SHORT).show();
		
		Toast.makeText(getBaseContext(),"Updated",Toast.LENGTH_SHORT).show();
	}
});

}

	private void setAlphaForView(View v, float alpha) {
		AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
		animation.setDuration(0);
		animation.setFillAfter(true);
		v.startAnimation(animation);
		
	}


	
}
