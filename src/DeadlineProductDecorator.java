
public class DeadlineProductDecorator extends ProductDecorator {
	
	private Deadline deadline;

	public DeadlineProductDecorator(Product decoratedProduct, int days) {
		super(decoratedProduct);
		deadline = new DaysDeadline(days);
	}

}
