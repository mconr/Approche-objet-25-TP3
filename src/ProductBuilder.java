import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductBuilder {
	private enum Decorator {
		FOOD, CULTURAL, VOLUME, WEIGHT, PACK, DEADLINE
	}

	private Product product;
	private Set<Decorator> appliedDecorators; // Pour suivre les décorateurs appliqués
	private Map<Decorator, Set<Decorator>> incoherences; // Pour stocker les incohérences entre propriétés
	private Map<Decorator, Set<Decorator>> complementaries; // Pour stocker les propriétés complémentaires

	public ProductBuilder(Product product) {
		this.product = product;
		appliedDecorators = new HashSet<>();
		incoherences = new HashMap<>();
		complementaries = new HashMap<>();
		initializeIncoherences(); // Initialiser les incohérences entre propriétés
		initializeComplementaries(); // Initialiser les propriétés complémentaires
	}

	private void initializeIncoherences() {
		incoherences.put(Decorator.FOOD, new HashSet<>(Set.of(Decorator.CULTURAL)));
		incoherences.put(Decorator.CULTURAL, new HashSet<>(Set.of(Decorator.FOOD)));
		incoherences.put(Decorator.VOLUME, new HashSet<>(Set.of(Decorator.WEIGHT)));
		incoherences.put(Decorator.WEIGHT, new HashSet<>(Set.of(Decorator.VOLUME)));
	}

	private void initializeComplementaries() {
		complementaries.put(Decorator.FOOD, new HashSet<>(Set.of(Decorator.DEADLINE)));
	}

	public ProductBuilder withFoodVat() throws Exception {
		appliedDecorators.add(Decorator.FOOD); // Ajouter le décorateur appliqué
		product = new FoodProductDecorator(product);
		return this;
	}

	public ProductBuilder withCulturalVat() throws Exception {
		appliedDecorators.add(Decorator.CULTURAL); // Ajouter le décorateur appliqué
		product = new CulturalProductDecorator(product);
		return this;
	}

	public ProductBuilder withVolume(double volume) throws Exception {
		appliedDecorators.add(Decorator.VOLUME); // Ajouter le décorateur appliqué
		product = new VolumeProductDecorator(product, volume);
		return this;
	}

	public ProductBuilder withWeight(double weight) throws Exception {
		appliedDecorators.add(Decorator.WEIGHT); // Ajouter le décorateur appliqué
		product = new WeightProductDecorator(product, weight);
		return this;
	}

	public ProductBuilder withPack(int quantity) throws Exception {
		appliedDecorators.add(Decorator.PACK); // Ajouter le décorateur appliqué
		product = new PackProductDecorator(product, quantity);
		return this;
	}

	public ProductBuilder withBundleSales(int quantity, double discount) throws Exception {
		appliedDecorators.add(Decorator.PACK); // Ajouter le décorateur appliqué
		product = new bundleSalesProductDecorator(product, quantity, discount);
		return this;
	}

	public ProductBuilder withDeadline(int days) throws Exception {
		appliedDecorators.add(Decorator.DEADLINE); // Ajouter le décorateur appliqué
		product = new DeadlineProductDecorator(product, days);
		return this;
	}

	private void checkIncoherence() throws Exception {
	    for (Decorator decorator : appliedDecorators) {
	        Set<Decorator> incompatibleDecorators = incoherences.get(decorator);
	        
	        if (incompatibleDecorators != null) {
	            // Trouver l'intersection entre les décorateurs appliqués et les décorateurs incompatibles
	            Set<Decorator> intersection = new HashSet<>(appliedDecorators);
	            intersection.retainAll(incompatibleDecorators);

	            // S'il y a une intersection, cela signifie qu'il y a une incohérence
	            if (!intersection.isEmpty()) {
	                for (Decorator incoherent : intersection) {
	                    throw new IllegalArgumentException(String.format(
	                        "Incoherence detected: %s cannot be used with %s", decorator, incoherent));
	                }
	            }
	        }
	    }
	}

	private void checkCompletness() throws Exception {
	    for (Decorator decorator : appliedDecorators) {
	        Set<Decorator> complementariesWithDecorator = complementaries.get(decorator);
	        if (complementariesWithDecorator != null) {
	            // Trouver l'intersection entre les décorateurs appliqués et les décorateurs complémentaires
	            Set<Decorator> intersection = new HashSet<>(complementariesWithDecorator);
	            intersection.retainAll(appliedDecorators);

	            // Vérifier si l'intersection est vide
	            if (intersection.isEmpty()) {
	            	String str = "";
	            	// Afficher les décorateurs complémentaires qui sont présents
		            for (Decorator incomplete : complementariesWithDecorator) {
		                str += " " + incomplete;
		            }
		            	
	                // S'il n'y a pas d'intersection, cela signifie qu'il manque des décorateurs nécessaires
	                throw new Exception(String.format(
	                    "Incompleteness detected: %s must be used with at least one complementary decorator (%s).", decorator, str));
	            }

	        }
	    }
	}

	public Product build() throws Exception {
		this.checkIncoherence();
		this.checkCompletness();
		return product;
	}

}
