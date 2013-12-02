package csc318.g6.dealstogoout;

public class TPTData {
	public static final String[] items = { "Carrot", "Bean", "Cabbage",
			"Onion", "Spinach", "Tomato", "Apple", "Banana", "Brown Bean",
			"Pineapple" };

	public static Double[] cPrice = { 0.99, 0.88, 0.77, 0.65, 0.55, 0.45, 0.33,
			0.20, 0.19, 0.01 };
	public static Double[] oPrice = { 1.99, 1.88, 1.77, 1.65, 1.55, 1.45, 1.33,
			1.20, 1.19, 1.09 };

	public static String[] location = { "Metro (22 Yong Street)",
			"Food Basics (238 Wellesley)", "Price Chooper (23 Bloor)" };
	public static Integer[] imageId = { R.raw.carrot, R.raw.greenbean,
			R.raw.s_cabbage, R.raw.s_onion, R.raw.s_spinach, R.raw.s_tomato,
			R.raw.s_red_apple, R.raw.s_banana, R.raw.s_swedishbrownbeans,
			R.raw.s_pineapple };
	public static Integer[] mapId = { R.raw.yong23, R.raw.wellesley238,
			R.raw.bloor23 };

	public static Integer[] selected = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static Integer[] quantity = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static int findID(String itemName) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(itemName))
				return i;
		}
		return 0;
	}

	public static String getTotal() {
		double sum = 0;
		for (int i = 0; i < items.length; i++) {
			if (selected[i] != 0)
				sum = sum + (quantity[i] * cPrice[i]);
		}
		String sTotal = sum + "";
		if (sTotal.length() - sTotal.indexOf('.') > 2)
			sTotal = sTotal.substring(0, sTotal.indexOf('.') + 3);
		return sTotal;
	}

	public static String getSaved() {
		double cSum = 0;
		double oSum = 0;
		for (int i = 0; i < items.length; i++) {
			if (selected[i] != 0) {
				cSum = cSum + (quantity[i] * cPrice[i]);
				oSum = oSum + (quantity[i] * oPrice[i]);
			}
		}
		String sTotal = (oSum - cSum) + "";
		if (sTotal.length() - sTotal.indexOf('.') > 2)
			sTotal = sTotal.substring(0, sTotal.indexOf('.') + 3);
		return sTotal;
	}

}
