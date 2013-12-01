package csc318.g6.dealstogoout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;
	private final Double[] cPrice;
	private final Double[] oPrice;
	private final String[] location;

	public CustomList(Activity context, String[] web, Integer[] imageId,
			Double[] cPrice, Double[] oPrice, String[] location) {
		super(context, R.layout.list_single, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
		this.cPrice = cPrice;
		this.oPrice = oPrice;
		this.location = location;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_single, null, true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		TextView cPriceTag = (TextView) rowView.findViewById(R.id.cPrice);
		TextView oPriceTag = (TextView) rowView.findViewById(R.id.oPrice);
//		TextView store = (TextView) rowView.findViewById(R.id.store_location);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

		txtTitle.setText(web[position]);
		cPriceTag.setText("   Now " + cPrice[position] + "$ !!!");
		oPriceTag.setText("Reg: " + oPrice[position] + "$");
		// store.setText("     @" + location[position % 3] + "");
		imageView.setImageResource(imageId[position]);

		return rowView;
	}
}
