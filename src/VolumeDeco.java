import java.util.UUID;


public class VolumeDeco extends ProductDecorator{

    protected Product decoratedProduct;
    private final double volume;

    public VolumeDeco(Product decoratedProduct,Double Volume){
        super(decoratedProduct);
        this.volume = Volume;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public Double getPriceExcludingVAT() {
        return super.getPriceExcludingVAT()*volume;
    }

    @Override
    public Double getPriceIncludingVAT() {
        return super.getPriceIncludingVAT()*volume;
    }

    @Override
    public Double getVATAmount() {
        return super.getVATAmount();
    }


}