public class BaseProduct implements Product {
    private static final double VAT = 0.2; // TVA de 20% par défaut
    private double price;
	private String name;

    public BaseProduct(String name, double priceExclVat) {
    	this.name = name;
        this.price = priceExclVat;
    }

	@Override
	public String toString() {
		return "BaseProduct [price=" + price + ", name=" + name + "]";
	}

    @Override
    public double getPriceExclVat() {
        return price;
    }

    @Override
    public final double getPriceInclVat() {
    	throw new IllegalStateException("internal error");
    }

    @Override
    public final double getVatAmount() {
    	throw new IllegalStateException("internal error");
    }

	@Override
	public double getVat() {
		return VAT;
	}

}
