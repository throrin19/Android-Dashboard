package com.throrinstudio.android.dashboard.example;

import com.throrinstudio.android.library.widgets.dashboard.DashBoardElement.OnClickListener;
import com.throrinstudio.android.library.widgets.dashboard.DashBoardLayout;
import com.throrinstudio.android.library.widgets.dashboard.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProgrammaticallyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_programmatically);
		
		DashBoardLayout dashboard = (DashBoardLayout) findViewById(R.id.dashBoardLayout1);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 1", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 2", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 3", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 4", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 5", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 6", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 7", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 8", testListener);
		dashboard.addElement(R.drawable.ic_dashboard_test, "Item 9", testListener);

	}

	private OnClickListener testListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(ProgrammaticallyActivity.this, "Click Item", Toast.LENGTH_LONG).show();
		}
		
	};
}
