package com.throrinstudio.android.dashboard.example;

import com.throrinstudio.android.library.widgets.dashboard.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		ListView choice = (ListView) findViewById(R.id.selectList);
		choice.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{ "Programmatically", "Ressource" } ));
		choice.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
				if(pos == 0){ // Programmatically
					Intent i = new Intent(MainActivity.this, ProgrammaticallyActivity.class);
					startActivity(i);
				}
			}
		});
	}
	
}
