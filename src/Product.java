import java.util.UUID;

public interface Product {
    Double getPriceExcludingVAT();
    Double getPriceIncludingVAT();
    Double getVATAmount();
    String getName();
    UUID getID();

}
