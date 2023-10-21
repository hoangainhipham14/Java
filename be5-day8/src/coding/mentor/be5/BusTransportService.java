package coding.mentor.be5;

public class BusTransportService extends TransportService {
	
	public void calculateTravelTime() {
		double time = 30;
		System.out.println("Travel time by bus: " + time);
	}
	
	public void calculateTravelFee() {
		double fee = 20;
		System.out.println("Travel fee by bus: " + fee);
	}
	
	public void planRoute() {
		String route = "A -> B -> C";
		System.out.println("Route by bus: " + route);
	}

}
