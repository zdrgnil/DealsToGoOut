package csc318.g6.dealstogoout;

import csc318.g6.dealstogoout.util.SystemUiHider;

import android.app.Activity;
import android.app.Dialog;
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
		TextView textView = (TextView)findViewById(R.id.total_text);
		textView.setText("Total: 23.95$");
	}

	public void onCreateListView() {
		ListView list;
		CustomList adapter = new CustomList(MyCart.this, TPTData.items,
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
		final Dialog custom = new Dialog(MyCart.this);
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

		Button deletebtn = (Button) custom
				.findViewById(R.id.add_to_cart_button);
		deletebtn.setText("Remove From List");
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
}