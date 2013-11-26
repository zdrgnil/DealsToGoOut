package csc318.g6.dealstogoout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
//import android.content.Intent;
//import android.widget.EditText;
//import android.widget.TextView;
import android.widget.ListView;


public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "csc318.g6.dealstogoout.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateListView();
        // Create the text view
        //TextView textView = (TextView)findViewById(R.id.text_message);
        //textView.setText("This and that");

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
        		Toast.makeText(MainActivity.this, "You Clicked at " +TPTData.items[+ position], Toast.LENGTH_SHORT).show();
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

