public interface Product {
    double getPriceExclVat(); // Prix HT sur le produit détaillé
    double getPriceInclVat(); // Prix TTC sur le produit détaillé
    double getVatAmount(); // Montant de la TVA sur le produit détaillé
	double getVat(); // Montant de la TVA
}
