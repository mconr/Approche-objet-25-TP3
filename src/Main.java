public class Main {
    public static void main(String[] args) {
    	// Créez d'abord le produit de base
        Product baseProduct = new BaseProduct("lait", 1.0); 
        // Lait à 1.00€/l       
        
        Product product;
		try {
			product = new ProductBuilder(baseProduct)
					.withFoodVat()				// Produit alimentaire (TVA 5.5%)
			        // /* Commenter cette ligne pour provoquer un problème de complétude 
					.withDeadline(7)			// Produit limité à la vente sur 7 jours
			        // /* dé-commenter cette ligne pour provoquer un problème de cohérence 
					//.withCulturalVat()		// Produit culturel : Incohérent avec Food !
					.withVolume(0.5)			// Volume de 50cl
			        // /* dé-commenter cette ligne pour provoquer un problème de cohérence 
					//.withWeight(0.5)		// Produit au poids : Incohérent avec Volume !
			        .withBundleSales(10, 0.1)	// promotion de 10% sur un pack de 10
			        .withPack(12)				// blister de 12
			        .build();
			        

			System.out.println(product);
	        
	        System.out.println("Price excl. VAT: " + product.getPriceExclVat() + "€");
	        System.out.println("Price incl. VAT: " + product.getPriceInclVat() + "€");
	        System.out.println("VAT amount: " + product.getVatAmount() + "€");
	        
	        // Lait
	        // 1.00 €HT / litre
	        // volume 0.5l : 0,50€ HT
	        // pack de 12: 6l : 6,00€ HT
	        // remise pour une vente de 10 unités: 60l : 60.00€ HT, remise 10%: 54,00€
	        // TVA de 5,5%: 56,97€
	        // TVA reversée: 2,97€
	        
	        
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

    }
}
