package com.throrinstudio.android.library.widgets.dashboard;

import android.view.View;

public class DashBoardElement {

	private Object res;
	private String libelle;
	private OnClickListener listener;
	
	public DashBoardElement(Object res, String libelle, OnClickListener action){
		this.setRes(res);
		this.setLibelle(libelle);
		this.setListener(action);
	}

	public void setRes(Object res) {
		this.res = res;
	}
	
	public Object getRes() {
		return res;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}

	public OnClickListener getListener() {
		return listener;
	}





	public static abstract class OnClickListener{
		public void onClick(View v){
			
		}
	}
}
