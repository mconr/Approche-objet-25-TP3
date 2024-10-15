public class VolumeProductDecorator extends ProductDecorator {
    private double volume;

    public VolumeProductDecorator(Product decoratedProduct, double volume) {
        super(decoratedProduct);
        this.volume = volume;
    }

    @Override
    public double getPriceExclVat() {
        return decoratedProduct.getPriceExclVat() * volume;
    }

	@Override
	public String toString() {
		return "VolumeProductDecorator [volume=" + volume + ", product=" + super.toString() + "]";
	}
    
    
}
