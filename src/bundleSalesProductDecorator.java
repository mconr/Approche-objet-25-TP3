
public class bundleSalesProductDecorator extends ProductDecorator {

	private int quantity;
	private double discount;

	public bundleSalesProductDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

	public bundleSalesProductDecorator(Product decoratedProduct, int quantity, double discount) {
        super(decoratedProduct);
		this.quantity = quantity;
		this.discount = discount;
	}

    @Override
    public double getPriceExclVat() {
        return decoratedProduct.getPriceExclVat() * quantity * (1 - discount);
    }

}
