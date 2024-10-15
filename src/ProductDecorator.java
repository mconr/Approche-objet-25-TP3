public abstract class ProductDecorator implements Product {
	protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public double getPriceExclVat() {
        return decoratedProduct.getPriceExclVat();
    }

    @Override
    public double getPriceInclVat() {
        return getPriceExclVat() * (1 + getVat());
    }

    @Override
    public double getVatAmount() {
        return  getPriceExclVat() * getVat();
    }

	@Override
    public double getVat() {
    	return decoratedProduct.getVat();
    }

	@Override
	public String toString() {
		return "ProductDecorator [decoratedProduct=" + decoratedProduct + "]";
	}

}
