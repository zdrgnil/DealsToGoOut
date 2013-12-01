package csc318.g6.dealstogoout;

import csc318.g6.dealstogoout.util.SystemUiHider;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class SearchResult extends Activity {
	public final static String SEARCH_TEXT = "csc318.g6.dealstogoout.SearchText";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);

		Intent intent = getIntent();
		int num = 10 + (int) (Math.random() * 70);
		String message = "\"" + intent.getStringExtra(MainActivity.SEARCH_TEXT);
		message += "\" (" + num + " results)";

		TextView searchTextField = (TextView) findViewById(R.id.Search_text);
		searchTextField.setText(message);

		onCreateListView();
	}

	public void onCreateListView() {
		ListView list;
		CustomList adapter = new CustomList(SearchResult.this, TPTData.items,
				TPTData.imageId, TPTData.cPrice, TPTData.oPrice,
				TPTData.location);
		list = (ListView) findViewById(R.id.sale_list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Toast.makeText(SearchResult.this,
				// "You Clicked at " + TPTData.items[+position],
				// Toast.LENGTH_SHORT).show();
				createDialog(position);
			}
		});
	}

	public void createDialog(int position) {

		final Dialog custom = new Dialog(SearchResult.this);
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

	public void goHome(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void search(View view) {
		Intent intent = new Intent(this, SearchResult.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);

		String message = editText.getText().toString();
		intent.putExtra(SEARCH_TEXT, message);

		startActivity(intent);
	}

}