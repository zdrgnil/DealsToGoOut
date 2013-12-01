package csc318.g6.dealstogoout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MapActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_map);

	}

	public void chMap(View view) {
		Intent intent = new Intent(this, MapActivity.class);
		startActivity(intent);
	}

	public void goHome(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void chLogin(View view) {
		// EditText editText = (EditText) findViewById(R.id.edit_message);
		// String message = editText.getText().toString();
		Intent intent = new Intent(this, LoginActivity.class);
		// intent.putExtra(SEARCH_TEXT, message);
		startActivity(intent);
	}

	public void chCart(View view) {
		Intent intent = new Intent(this, MyCart.class);
		startActivity(intent);
	}
}
