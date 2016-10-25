package com.example.destinationtrendes;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button login;
	EditText Password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startService(new Intent(this, GPService.class));
		
		login=(Button) findViewById(R.id.button1);
		login.setBackgroundColor(Color.GRAY);;
		setAlphaForView(login, 0.8f);
		
		
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
				//Intent intent = new Intent(MainActivity.this,Selection.class);
				//startActivity(intent);
				
				Intent intent = new Intent(MainActivity.this,Selection.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
				
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
