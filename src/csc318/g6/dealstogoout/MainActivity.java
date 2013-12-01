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
import android.widget.ImageView;
import android.widget.TextView;
//import android.content.Intent;
//import android.widget.EditText;
//import android.widget.TextView;
import android.widget.ListView;

public class MainActivity extends Activity {
	public final static String SEARCH_TEXT = "csc318.g6.dealstogoout.SearchText";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		onCreateListView();
	}

	public void onCreateListView() {
		ListView list;
		CustomList adapter = new CustomList(MainActivity.this, TPTData.items,
				TPTData.imageId, TPTData.cPrice, TPTData.oPrice,
				TPTData.location);
		list = (ListView) findViewById(R.id.sale_list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Toast.makeText(MainActivity.this, "You Clicked at "
				// +TPTData.items[+ position], Toast.LENGTH_SHORT).show();
				createDialog(position);
			}
		});
	}

	public void createDialog(int position) {

		final Dialog custom = new Dialog(MainActivity.this);
		custom.setContentView(R.layout.dialog);
		custom.setTitle("Product Detail: " + TPTData.items[+position]);

		ImageView itemImageField = (ImageView) custom
				.findViewById(R.id.item_img);
		itemImageField.setImageResource(TPTData.imageId[position]);

		TextView itemNameField = (TextView) custom.findViewById(R.id.item_name);
		itemNameField.setText("Name: " + TPTData.items[position]);

		TextView itemPriceField = (TextView) custom
				.findViewById(R.id.item_price);
		itemPriceField.setText("Current: " + TPTData.cPrice[position]
				+ "$      Was:" + TPTData.oPrice[position] + "$");

		double saved = Math
				.round(1000 * (TPTData.oPrice[position] - TPTData.cPrice[position])) / 1000;
		TextView itemSaveField = (TextView) custom.findViewById(R.id.item_save);
		itemSaveField.setText("Save: " + saved + "$");

		int date = 1 + (int) (Math.random() * 29);
		TextView itemSaleEndField = (TextView) custom
				.findViewById(R.id.sale_ends);
		itemSaleEndField.setText("Sale End: Dec " + date + ", 2013");

		TextView itemManufactureField = (TextView) custom
				.findViewById(R.id.manufacture_text);
		itemManufactureField.setText("Manufacture: CaON GreenHouse");

		TextView itemProductField = (TextView) custom
				.findViewById(R.id.product_text);
		itemProductField.setText("Product of: Canada");

		TextView itemBrandField = (TextView) custom
				.findViewById(R.id.brand_text);
		itemBrandField.setText("Brand: Unknown");

		TextView itemLocationField = (TextView) custom
				.findViewById(R.id.sold_at_text);
		itemLocationField.setText("Sold at: " + TPTData.location[position % 3]);

		ImageView mapImageField = (ImageView) custom
				.findViewById(R.id.item_location_map);
		mapImageField.setImageResource(TPTData.mapId[position % 3]);

		// Button savebtn = (Button)
		// custom.findViewById(R.id.add_to_cart_button);
		Button canbtn = (Button) custom.findViewById(R.id.cancel_button);
		canbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				custom.dismiss();
			}
		});/**/
		custom.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// called when user click send button
	public void sendMessage(View view) {
		// do something
		/*
		 * Intent intent = new Intent(this, DisplayMessageActivity.class);
		 * EditText editText =(EditText)findViewById(R.id.edit_message);
		 * 
		 * String message = editText.getText().toString();
		 * intent.putExtra(EXTRA_MESSAGE, message);
		 * 
		 * startActivity(intent);
		 */
	}

	public void search(View view) {
		Intent intent = new Intent(this, SearchResult.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);

		String message = editText.getText().toString();
		intent.putExtra(SEARCH_TEXT, message);

		startActivity(intent);
	}

	public void chMap(View view) {
		Intent intent = new Intent(this, MapActivity.class);
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
