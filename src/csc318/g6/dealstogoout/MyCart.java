package csc318.g6.dealstogoout;

import csc318.g6.dealstogoout.util.SystemUiHider;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MyCart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_cart);
		onCreateListView();

		String total = TPTData.getTotal();
		String sTotal = TPTData.getSaved();
		TextView textView = (TextView) findViewById(R.id.total_text);
		textView.setText("Total: " + total + "$");
		TextView sTotalText = (TextView) findViewById(R.id.stotal_text);
		sTotalText.setText("Saved: " + sTotal + "$");
		
	}

	public static String[] items;
	public static Integer[] imageId;
	public static Double[] cPrice;
	public static Double[] oPrice;
	public static Integer[] quantity;

	public void onCreateListView() {
		int num = 0;
		for (int i = 0; i < TPTData.selected.length; i++) {
			if (TPTData.selected[i] == 1)
				num++;
		}
		items = new String[num];
		imageId = new Integer[num];
		cPrice = new Double[num];
		oPrice = new Double[num];
		quantity = new Integer[num];
		int c = 0;
		for (int i = 0; i < TPTData.selected.length; i++) {
			if (TPTData.selected[i] == 1) {
				items[c] = TPTData.items[i];
				imageId[c] = TPTData.imageId[i];
				cPrice[c] = TPTData.cPrice[i];
				oPrice[c] = TPTData.oPrice[i];
				quantity[c] = TPTData.quantity[i];
				c++;
			}
		}

		ListView list;
		CustomShoppingList adapter = new CustomShoppingList(MyCart.this, items,
				imageId, cPrice, oPrice, TPTData.location, quantity);
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
		final int pos = position;
		final Dialog custom = new Dialog(MyCart.this);
		custom.setContentView(R.layout.dialog);
		custom.setTitle("Product Detail: " + items[+position]);

		ImageView itemImageField = (ImageView) custom
				.findViewById(R.id.item_img);
		itemImageField.setImageResource(imageId[position]);

		TextView itemNameField = (TextView) custom.findViewById(R.id.item_name);
		itemNameField.setText("Name: " + items[position]);

		TextView itemPriceField = (TextView) custom
				.findViewById(R.id.item_price);
		itemPriceField.setText("Current: " + cPrice[position] + "$      Was:"
				+ oPrice[position] + "$");

		double saved = Math.round(1000 * (oPrice[position] - cPrice[position])) / 1000;
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

		Button deletebtn = (Button) custom
				.findViewById(R.id.add_to_cart_button);
		deletebtn.setText("Remove From List");
		deletebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int id = TPTData.findID(items[pos]);
				TPTData.selected[id] = 0;
				custom.dismiss();
			}
		});

		Button canbtn = (Button) custom.findViewById(R.id.cancel_button);
		canbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				custom.dismiss();
			}
		});
		custom.show();
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

	public void goHome(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
