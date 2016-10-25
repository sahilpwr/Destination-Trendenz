package com.example.destinationtrendes;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UserSimilarity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_similarity);
		
		ListView mainListView = (ListView) findViewById( R.id.listView1);  
		  
	    // just a demo for future scope 
		String[] items={"","","","","","","Recommended User:","Suhas Pandhe"};

	    ArrayList<String> planetList = new ArrayList<String>();  
	    planetList.addAll( Arrays.asList(items) ); 
	    ArrayAdapter<String>adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
	 mainListView.setAdapter(adapter);
	}

	
}
