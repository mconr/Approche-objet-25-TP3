import java.util.UUID;

public abstract  class ProductDecorator implements Product{
    
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct){
        this.decoratedProduct = decoratedProduct;
    }


    @Override
    public Double getPriceExcludingVAT() {
        return decoratedProduct.getPriceExcludingVAT();
    }

    @Override
    public Double getPriceIncludingVAT() {
        return decoratedProduct.getPriceIncludingVAT();
    }

    @Override
    public Double getVATAmount() {
        return decoratedProduct.getVATAmount();
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @override 
    public UUID getId() {
        return decoratedProduct.getID();
    }
}
