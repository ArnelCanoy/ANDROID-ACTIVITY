package com.example.mylocation;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener,LocationListener {

	EditText txtLat,txtLng;
	Button btnOkey,btnCancel;
	//
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		locman = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		//
		criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
		criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
		
		provider = locman.getBestProvider(criteria, true);
		
		locman.requestLocationUpdates(provider, 1, 10, this);
		
		location = locman.getLastKnownLocation(provider);
		
		txtLat = (EditText) this.findViewById(R.id.editText1);
		txtLng = (EditText) this.findViewById(R.id.editText2);
		this.btnOkey = (Button) this.findViewById(R.id.button1);
		this.btnCancel = (Button) this.findViewById(R.id.button2);
		
		this.btnOkey.setOnClickListener(this);
	}
	public void onClick(View arg0) {
		
		int id = arg0.getId();
		switch(id){
		case R.id.button1: 
			
			location = locman.getLastKnownLocation(provider);
			Log.d("provider", provider);
			String lat = String.format("%.3f", location.getLatitude());
			String lng = String.format("%.3f", location.getLongitude());
			this.txtLat.setText(lat);
			this.txtLng.setText(lng);
			
			break;
		case R.id.button2:
			this.txtLat.setText("");
			this.txtLng.setText("");
			this.txtLat.requestFocus();
		}
		
	}
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}
