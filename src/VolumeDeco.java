import java.util.UUID;


public class VolumeDeco extends ProductDecorator{

    protected Product decoratedProduct;
    double Vol;


    public VolumeDeco(Product decoratedProduct,Double Volume){
        super(decoratedProduct);
        Vol = Volume;
    }

    @Override
    public UUID getID() {
        return super.getId();
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public Double getPriceExcludingVAT() {
        return super.getPriceExcludingVAT()*Vol;
    }

    @Override
    public Double getPriceIncludingVAT() {
        return super.getPriceIncludingVAT()*Vol;
    }

    @Override
    public Double getVATAmount() {
        return super.getVATAmount()*Vol;
    }


}