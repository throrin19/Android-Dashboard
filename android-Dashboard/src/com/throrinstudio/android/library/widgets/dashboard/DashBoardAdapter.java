package com.throrinstudio.android.library.widgets.dashboard;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DashBoardAdapter extends BaseAdapter{

	
	private LayoutInflater 				mInflater;
	private Context						mContext;
	private ArrayList<DashBoardElement> mElements;
	
	public DashBoardAdapter(Context c){
		mContext 	= c;
		mInflater	= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mElements	= new ArrayList<DashBoardElement>();
	}
	
	public void addElement(Object img, String libelle, DashBoardElement.OnClickListener listener){
		DashBoardElement element = new DashBoardElement(img, libelle, listener);
		mElements.add(element);
		this.notifyDataSetInvalidated();
	}
	
	public void addElement(DashBoardElement element){
		mElements.add(element);
		this.notifyDataSetInvalidated();
	}
	
	
	@Override
	public int getCount() {
		return mElements.size();
	}

	@Override
	public DashBoardElement getItem(int arg0) {
		return mElements.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		final ViewHandler holder;
		
		if(convertView == null) {
            vi 				= mInflater.inflate(R.layout.widget_dashboard_item, null);
            holder			= new ViewHandler();
            holder.image	= (ImageView) vi.findViewById(R.id.dashboard_item_img);
            holder.text 	= (TextView) vi.findViewById(R.id.dashboard_item_name);
            vi.setTag(holder);
        } else {
        	holder = (ViewHandler) vi.getTag();
        }
		
		DashBoardElement element = getItem(position);
		
		if(element.getRes() instanceof Integer){
			holder.image.setImageResource((Integer) element.getRes());
		}else if(element.getRes() instanceof Drawable){
			holder.image.setImageDrawable((Drawable) element.getRes());
		}else if(element.getRes() instanceof Bitmap){
			holder.image.setImageBitmap((Bitmap) element.getRes());
		}
		
		holder.text.setText(element.getLibelle());
		
		return vi;
	}

	
	public static class ViewHandler{
		public ImageView 	image;
		public TextView 	text;
	}
}
