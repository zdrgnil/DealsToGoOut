package csc318.g6.dealstogoout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomShoppingList extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;
	private final Double[] cPrice;
	private final Double[] oPrice;
	private final Integer[] quantity;
	private final String[] location;

	public CustomShoppingList(Activity context, String[] web,
			Integer[] imageId, Double[] cPrice, Double[] oPrice,
			String[] location, Integer[] quantity) {
		super(context, R.layout.shopping_list_single, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
		this.cPrice = cPrice;
		this.oPrice = oPrice;
		this.quantity = quantity;
		this.location = location;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.shopping_list_single, null,
				true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		TextView cPriceTag = (TextView) rowView.findViewById(R.id.cPrice);
		TextView oPriceTag = (TextView) rowView.findViewById(R.id.oPrice);
		TextView ptotalTag = (TextView) rowView.findViewById(R.id.pTotal);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

		txtTitle.setText(web[position]);
		oPriceTag.setText("   Reg: " + oPrice[position] + "$");
		cPriceTag.setText("Price: " + cPrice[position] + "$    x"
				+ quantity[position]);
		String sTotal = (cPrice[position] * (double) quantity[position]) + "";
		if (sTotal.length() - sTotal.indexOf('.') > 2)
			sTotal = sTotal.substring(0, sTotal.indexOf('.') + 3);
		ptotalTag.setText("   Total: " + sTotal + "$");
		imageView.setImageResource(imageId[position]);

		return rowView;
	}
}
