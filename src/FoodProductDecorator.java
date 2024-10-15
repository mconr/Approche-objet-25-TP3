public class FoodProductDecorator extends ProductDecorator {
    private static final double VAT = 0.055; // TVA réduite pour les produits alimentaires

	public FoodProductDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getVat() {
        return VAT;
    }

	@Override
	public String toString() {
		return "FoodProductDecorator [getPriceExclVat()=" + getPriceExclVat() + ", getPriceInclVat()="
				+ getPriceInclVat() + ", getVatAmount()=" + getVatAmount() + "]";
	}

}