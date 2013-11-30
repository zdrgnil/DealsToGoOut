package csc318.g6.dealstogoout;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.content.Intent;
//import android.widget.EditText;
//import android.widget.TextView;
import android.widget.ListView;


public class MainActivity extends Activity {
	Dialog custom;
	EditText Fname;
	EditText Lname;
	TextView txt;
	Button savebtn;
	Button canbtn;
	
	public final static String EXTRA_MESSAGE = "csc318.g6.dealstogoout.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateListView();
    }

    public void onCreateListView(){
    	ListView list;        
        CustomList adapter = new CustomList(MainActivity.this, TPTData.items, TPTData.imageId,
        		TPTData.cPrice, TPTData.oPrice);
        list=(ListView)findViewById(R.id.sale_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		//Toast.makeText(MainActivity.this, "You Clicked at " +TPTData.items[+ position], Toast.LENGTH_SHORT).show();

        		custom = new Dialog(MainActivity.this);
                custom.setContentView(R.layout.dialog);
                Fname = (EditText)custom.findViewById(R.id.fname);
                Lname = (EditText)custom.findViewById(R.id.lname);
                savebtn = (Button)custom.findViewById(R.id.savebtn);
                canbtn = (Button)custom.findViewById(R.id.canbtn);
                custom.setTitle(""+TPTData.items[+ position]); 
                canbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Auto-generated method stub
                        custom.dismiss();
 
                    }
                });
                custom.show();
        	}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // called when user click send button
    public void sendMessage(View view){
    	//do something
    	/*
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText =(EditText)findViewById(R.id.edit_message);
    	
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	
    	startActivity(intent);*/
    }
    
    public void chLogin(View view){
    	Intent intent = new Intent(this, LoginActivity.class);
    	startActivity(intent);
    }    
}

