public class PackProductDecorator extends ProductDecorator {
    private int quantity;

    public PackProductDecorator(Product decoratedProduct, int quantity) {
        super(decoratedProduct);
        this.quantity = quantity;
    }

    @Override
    public double getPriceExclVat() {
        return decoratedProduct.getPriceExclVat() * quantity;
    }

	@Override
	public String toString() {
		return "PackProductDecorator [quantity=" + quantity + ", getPriceInclVat()=" + getPriceInclVat()
				+ ", getVatAmount()=" + getVatAmount() + ", getVat()=" + getVat() + ", toString()=" + super.toString()
				+ "]";
	}

}
