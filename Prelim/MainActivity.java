package com.example.prelim;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public abstract class MainActivity extends Activity implements OnClickListener, OnItemClickListener {
	ListView lv;
	Button btnAdd;
	EditText txtname;
	EditText txtcourse;
	
	ArrayList<String> list=new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        
        this.txtname=(EditText) this.findViewById(R.id.editText1);
        this.txtcourse=(EditText) this.findViewById(R.id.editText2);
        this.btnAdd=(Button) this.findViewById(R.id.button1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.lv.setAdapter(adapter);
        
        this.btnAdd.setOnClickListener(this);
        this.lv.setOnItemClickListener(this);
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		String s=this.lv.getItemAtPosition(arg2).toString();
		b.setTitle("Selected Item");
		b.setMessage(s);
		b.setNeutralButton("Okey", null);
		
		AlertDialog dialog=b.create();
		dialog.show();
	}
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
				switch(arg1){
				case DialogInterface.BUTTON_POSITIVE:
				//retreive the typed data from the edit text
				String name=this.txtname.getText().toString();
				String course=this.txtcourse.getText().toString();
				//check if there is a typed data 
				
				if(!name.equals("") && course.equals("")){
					//add the typed data to the data source
					list.add(name);
					list.add(course);
					//update the adapter
					this.adapter.notifyDataSetChanged();
					((DialogInterface) arg0).dismiss();
				}
				else Toast.makeText(this, "Type Name", Toast.LENGTH_SHORT).show();
					
				break;	
				case DialogInterface.BUTTON_NEGATIVE:
				//dismiss the dialog
					((DialogInterface) arg0).dismiss();
			    
				}	
	    }
  
}
