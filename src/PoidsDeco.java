import java.util.UUID;

public class PoidsDeco extends ProductDecorator {

    protected Product decoratedProduct;
    private final double poids;


    public PoidsDeco(Product decoratedProduct,Double Poids){
        super(decoratedProduct);
        this.poids = Poids;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Double getPriceExcludingVAT() {
        return super.getPriceExcludingVAT()*this.poids;
    }

    @Override
    public Double getPriceIncludingVAT() {
        return super.getPriceIncludingVAT()*this.poids;
    }

    @Override
    public Double getVATAmount() {
        return super.getVATAmount()*this.poids;
    }

}
