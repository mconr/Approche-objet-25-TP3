import java.util.UUID;

public class CostumerProduct implements Product{
    private String name;
    private Double Price;
    protected static final Double vat;
    private UUID id;


    @Override
    public Double getPriceExcludingVAT() {

        return Price;
    }


    @Override
    public Double getPriceIncludingVAT() {

        return Price*(1 + vat);
    } 


    @Override
    public Double getVATAmount(Double price){

        return price*0.2;
    }


    @Override
    public String getName(){
        return name;
    }

    @Override
    public UUID gatId(){
        return id;
    }


    public Double getVAT(){
        return vat;
    }

}
