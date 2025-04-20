import java.time.LocalDateTime;

public class Receipt {
	int cost;
	LocalDateTime deliveryTime;

	public void Receipt(int cost, int minutesToDeliver) {
		this.cost = cost;
		this.deliveryTime = LocalDateTime.now().plusMinutes(minutesToDeliver);
	}
}
