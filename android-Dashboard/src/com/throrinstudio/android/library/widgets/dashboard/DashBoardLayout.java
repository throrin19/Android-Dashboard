package com.throrinstudio.android.library.widgets.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;

public class DashBoardLayout extends LinearLayout{

	private LayoutInflater 				mInflater;
	private GridView					mGridDashboard;
	private	LinearLayout				mContentView;


	public DashBoardLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mInflater 		= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mContentView 	= (LinearLayout) mInflater.inflate(R.layout.widget_dashboard, null);
		mGridDashboard	= (GridView) mContentView.findViewById(R.id.dashboard_grid);
		
		mGridDashboard.setAdapter(new DashBoardAdapter(context));
		mGridDashboard.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
				DashBoardElement element = (DashBoardElement) mGridDashboard.getAdapter().getItem(pos);
				element.getListener().onClick(arg1);
			}
		});
		
		this.addView(mContentView);
	}

	public void addElement(Object img, String libelle, DashBoardElement.OnClickListener listener){
		((DashBoardAdapter)mGridDashboard.getAdapter()).addElement(img, libelle, listener);
	}
	
	public void addElement(DashBoardElement element){
		((DashBoardAdapter)mGridDashboard.getAdapter()).addElement(element);
	}
	
	
}
