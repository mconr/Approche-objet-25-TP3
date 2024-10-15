public class WeightProductDecorator extends ProductDecorator {
    private double weight;

    public WeightProductDecorator(Product decoratedProduct, double weight) {
        super(decoratedProduct);
        this.weight = weight;
    }

    @Override
    public double getPriceExclVat() {
        return decoratedProduct.getPriceExclVat() * weight;
    }

	@Override
	public String toString() {
		return "WeightProductDecorator [weight=" + weight + ", product=" + super.toString() + "]";
	}
    
    
}
