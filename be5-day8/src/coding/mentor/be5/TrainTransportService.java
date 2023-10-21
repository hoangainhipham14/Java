package coding.mentor.be5;

public class TrainTransportService extends TransportService {
	
	public void calculateTravelTime() {
		double time = 10;
		System.out.println("Travel time by train: " + time);
	}
	
	public void calculateTravelFee() {
		double fee = 30;
		System.out.println("Travel fee by train: " + fee);
	}
	
	public void planRoute() {
		String route = "A -> B -> C -> D -> E";
		System.out.println("Route by train: " + route);
	}

}
