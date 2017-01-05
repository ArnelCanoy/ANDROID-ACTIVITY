package com.example.mysearchtext;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {


	
	EditText txtSearch;
	ListView lv;
	//data holders
	ArrayList<String> list=new ArrayList<String>();
	ArrayList<String> source=new ArrayList<String>();
	//adapter
	ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtSearch=(EditText) this.findViewById(R.id.editText1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        this.lv.setAdapter(adapter);
        
        this.lv.setOnItemClickListener(this);
        //populate my data reference
        
        this.source.add("a");
        this.source.add("b");
        this.source.add("ab");
        this.source.add("ac");
        this.source.add("ad");
        this.source.add("carrot");
        this.source.add("bh");
        this.source.add("cf");
        this.source.add("dr");
        this.source.add("n");
        this.source.add("k");
        this.source.add("l");
        this.source.add("jump");
        this.source.add("j");
        this.source.add("z");
       
     
        
       
       
        this.txtSearch.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				
				list.clear();//clear  the list before refilling
				
				Pattern p=Pattern.compile(arg0.toString());
				for(int i=0;i<source.size();i++){
					Matcher m=p.matcher(source.get(i));
					 if(m.find()){
						list.add(source.get(i));
						
					 }
					 adapter.notifyDataSetChanged();
				}
				
		
			}});
        
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		String s=this.lv.getItemAtPosition(arg2).toString();
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
	}
}
