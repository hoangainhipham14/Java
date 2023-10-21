package coding.mentor.be5;

public class TramTransportService extends TransportService {
	
	public void calculateTravelTime() {
		double time = 40;
		System.out.println("Travel time by tram: " + time);
	}
	
	public void calculateTravelFee() {
		double fee = 10;
		System.out.println("Travel fee by tram: " + fee);
	}
	
	public void planRoute() {
		String route = "A -> B -> C -> D";
		System.out.println("Route by tram: " + route);
	}

}
