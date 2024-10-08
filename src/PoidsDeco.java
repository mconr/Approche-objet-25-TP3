import java.util.UUID;

public class PoidsDeco extends ProductDecorator {

    protected Product decoratedProduct;
    double P;


    public PoidsDeco(Product decoratedProduct,Double Poids){
        super(decoratedProduct);
        P = Poids;
    }

    @Override
    public UUID getId() {
        return super.getID();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Double getPriceExcludingVAT() {
        return super.getPriceExcludingVAT()*P;
    }

    @Override
    public Double getPriceIncludingVAT() {
        return super.getPriceIncludingVAT()*P;
    }

    @Override
    public Double getVATAmount() {
        return super.getVATAmount()*P;
    }

}
