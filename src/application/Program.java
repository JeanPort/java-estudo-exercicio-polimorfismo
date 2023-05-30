package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import enetities.ImportedProduct;
import enetities.Product;
import enetities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int quntityProducts = scanner.nextInt();
		
		List<Product> products = new ArrayList<>();
		
		for (int i = 1; i <= quntityProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = scanner.next().charAt(0);
			
			System.out.print("Name: ");
			String name = scanner.next();
			
			System.out.print("Price: ");
			double price = scanner.nextDouble();
			
			if (resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(scanner.next(), dateTimeFormatter);
				products.add(new UsedProduct(name, price, date));
			}else if (resp == 'i') {
				System.out.print("Custom fee: ");
				products.add(new ImportedProduct(name, price, scanner.nextDouble()));
			}else {
				products.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		
		
		scanner.close();
	}

}
