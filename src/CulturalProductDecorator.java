public class CulturalProductDecorator extends ProductDecorator {
    private static final double VAT = 0.1; // TVA réduite pour les produits culturels

	public CulturalProductDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getVat() {
        return VAT; 
    }

	@Override
	public String toString() {
		return "CulturalProductDecorator [product=" + super.toString() + "]";
	}

    
}