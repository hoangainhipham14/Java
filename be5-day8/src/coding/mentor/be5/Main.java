package coding.mentor.be5;

import java.util.Scanner;

public class Main {

	static final int BUS = 0;
	static final int TRAM = 1;
	static final int TRAIN = 2;
	
	public static void main(String[] args) {
		
		System.out.println("Please choose your choice of vehicle:");
		Scanner input = new Scanner(System.in);
		
		int selectedVehicle = input.nextInt();
		input.nextLine();
		TransportService service = getTransportServiceBasedOnUserInput(selectedVehicle);
		if (service != null) {
			service.calculateTravelFee();
			service.calculateTravelTime();
			service.planRoute();
		}
		input.close();
	}
	
	public static TransportService getTransportServiceBasedOnUserInput(int selectedVehicle) {
		switch (selectedVehicle) {
			case BUS: {
				System.out.println("The selected tranport: bus");
				return new BusTransportService();
			}
			case TRAM: {
				System.out.println("The selected tranport: tram");
				return new TramTransportService();
			}
			case TRAIN: {
				System.out.println("The selected tranport: train");
				return new TrainTransportService();
			}
		}
		return null;
	}
}
