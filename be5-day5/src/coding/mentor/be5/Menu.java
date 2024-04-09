package coding.mentor.be5;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Product[] products = new Product[3];
		
		products[0] = new Product();
		products[0].name = "Black Coffee";
		products[0].price = 7;
		products[1] = new Product();
		products[1].name = "White Coffee";
		products[1].price = 5;
		products[2] = new Product();
		products[2].name = "Chocolate";
		products[2].price = 4;
		
		Order[] items = new Order[100];
		showMenu(products);
		
		Scanner input = new Scanner(System.in);
		String orderMore = "Yes";
		
		while (orderMore.equals("Yes")) {
			
			System.out.println("Please select your item in our menu");
			int item = input.nextInt();
			input.nextLine();
			
			System.out.println("Please enter quantity");
			int quantity = input.nextInt();
			input.nextLine();
			if (items[item] == null) {
			    items[item] = new Order();
			    items[item].name = item;
			    items[item].quantity = quantity;
			} else {
			    items[item].quantity += quantity;   
			}
			
			items[item].subTotal = items[item].quantity * products[item - 1].price;
			
			System.out.println("Would you like to order more? Yes/No");
			orderMore = input.nextLine();
		}
		
		printBill(items);
		input.close();
	}
	
	public static void showMenu(Product[] products) {
		for (int index = 0; index < products.length; index++) {
			System.out.println(index + 1 + ". " + products[index].name + " - price: " + products[index].price + "AUD");
		}
	}
	
	public static void printBill(Order[] items) {
		double total = 0;
		int index = 1;
		while (items[index] != null) {
			System.out.println(items[index].name);
			System.out.println("Item: " + items[index].name);
			System.out.println("Sub total: " + items[index].subTotal);
			System.out.println("Quantity: " + items[index].quantity);
			total += items[index].subTotal;
			index++;
		}
		System.out.println("-------------------");
		System.out.println("Total: " + total);
	}
}
