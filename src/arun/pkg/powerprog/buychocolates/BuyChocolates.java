package arun.pkg.powerprog.buychocolates;

public class BuyChocolates {
	public static void main(String[] args) {
		String kidsCount = "5";// s.nextLine();
		String chocolatesStr = "Kinder:30:2,Cadbury:15:8";// s.nextLine();

		int kids = Integer.parseInt(kidsCount);
		int maxPrice = Integer.MIN_VALUE;
		String[] chocArr = chocolatesStr.split(",");
		for (int i = 0; i < chocArr.length; i++) {
			String[] chocDetails = chocArr[i].split(":");
			if (kids <= Integer.parseInt(chocDetails[2])) {
				int chocPrice = Integer.parseInt(chocDetails[1]);
				if (maxPrice == Integer.MIN_VALUE) {
					maxPrice = chocPrice;
				} else if (maxPrice < chocPrice) {
					maxPrice = chocPrice;
				}
			}
		}

		if (maxPrice != Integer.MIN_VALUE) {
			System.out.println(maxPrice * kids);
		}
	}
}
