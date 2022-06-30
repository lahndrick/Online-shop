/*
 * This class is the main class used by the user
 * 
 * It uses the OnlineShop and Product classes to create a shop with products in it
 * 
 * The beggining of main is simply creating 5 products and creating some ratings for these products
 * 
 * What the user sees is an infinite loop that will keep looping until the user enters "C" (lower or upper case)
 * 
 * The options for the user are to display the products in the store, rate the products or exit
 * if exit is chosen the product is closed
 * if display is chosen it displays the products in the store then asks the user for a chosen option again
 * if rating a product is chosen they will then be prompted to select which product followed by what they want to rate the product
 */

import java.util.Scanner;

public class App 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		//creating new products to be put into an online shop
		Product a = new Product("T-800", "Cyberdyne Systems", 10000);
		Product b = new Product("Notebook", "Oxford", 3.40);
		Product c = new Product("Magic Cube", "Toy Inc", 5.34);
		Product d = new Product("Headphones", "Sound Company", 99.99);
		Product e = new Product("Coffee Thermos", "Hot Cold Company", 30.99);
		
		//creating a new shop for products to be put into
		OnlineShop Shop1 = new OnlineShop();

		//adding products to the online shop
		Shop1.addNewProduct(a);
		Shop1.addNewProduct(b);
		Shop1.addNewProduct(c);
		Shop1.addNewProduct(d);
		Shop1.addNewProduct(e);

		//adding ratings for products
		a.rateReliability(3);
		a.rateReliability(4);
		a.rateReliability(2);
		b.rateReliability(4);
		b.rateReliability(3);
		b.rateReliability(5);
		b.rateReliability(4);
		b.rateReliability(5);
		c.rateReliability(2);
		c.rateReliability(1);
		c.rateReliability(3);
		c.rateReliability(2);
		c.rateReliability(2);
		c.rateReliability(2);
		c.rateReliability(2);
		d.rateReliability(2);
		d.rateReliability(3);
		d.rateReliability(4);
		d.rateReliability(4);
		e.rateReliability(5);
		e.rateReliability(1);
		e.rateReliability(2);
		e.rateReliability(1);
		e.rateReliability(5);
		
		//variable for user input
		String input = "";
		
		//infinite loop until C is entered which will close the program
		for(;;)
		{
			
			//standard options given to user and requires an input to proceed
			System.out.println("A. Display inventory");
			System.out.println("B. Rate Product");
			System.out.println("C. Exit");
			input = scan.nextLine();
			
			//if A is selected the store is shown
			if(input.equalsIgnoreCase("A"))
			{
				System.out.println(Shop1);
			}
			
			//if C is entered the progarm closes
			if(input.equalsIgnoreCase("C"))
			{
				System.out.println("C has been entered, closing program.");
				System.exit(0);
			}
			
			//if B is selected the user continues on to rating a product
			if(input.equalsIgnoreCase("B"))
			{
				System.out.println(Shop1);
				System.out.print("What product would you like to rate? ");
				int userChoice = scan.nextInt();
				
				//if statements for string input from 1 to 5, used for rating each product in store
				if(userChoice == 1)
				{
					System.out.print("What would you like to rate " + Shop1.getProduct(userChoice).getModelName() + "? (1 to 5) ");
					double userRating = scan.nextDouble();

					//rates product using users input
					Shop1.getProduct(1).rateReliability(userRating);
					
					//shows the user the new rating for the product
					System.out.println("Thank you for your rating, " + Shop1.getProduct(userChoice).getModelName() + " now has a rating of: " + Shop1.getProduct(userChoice).getReliabilityRating() + "\n");
				}
				
				if(userChoice == 2)
				{
					System.out.print("What would you like to rate " + Shop1.getProduct(userChoice).getModelName() + "? (1 to 5) ");
					double userRating = scan.nextDouble();

					//rates product using users input
					Shop1.getProduct(2).rateReliability(userRating);

					//shows the user the new rating for the product
					System.out.println("Thank you for your rating, " + Shop1.getProduct(userChoice).getModelName() + " now has a rating of: " + Shop1.getProduct(userChoice).getReliabilityRating() + "\n");
				}
				
				if(userChoice == 3)
				{
					System.out.print("What would you like to rate " + Shop1.getProduct(userChoice).getModelName() + "? (1 to 5) ");
					double userRating = scan.nextDouble();

					//rates product using users input
					Shop1.getProduct(3).rateReliability(userRating);

					//shows the user the new rating for the product
					System.out.println("Thank you for your rating, " + Shop1.getProduct(userChoice).getModelName() + " now has a rating of: " + Shop1.getProduct(userChoice).getReliabilityRating() + "\n");
				}
				
				if(userChoice == 4)
				{
					System.out.print("What would you like to rate " + Shop1.getProduct(userChoice).getModelName() + "? (1 to 5) ");
					double userRating = scan.nextDouble();

					//rates product using users input
					Shop1.getProduct(4).rateReliability(userRating);

					//shows the user the new rating for the product
					System.out.println("Thank you for your rating, " + Shop1.getProduct(userChoice).getModelName() + " now has a rating of: " + Shop1.getProduct(userChoice).getReliabilityRating() + "\n");
				}
				
				if(userChoice == 5)
				{
					System.out.print("What would you like to rate " + Shop1.getProduct(userChoice).getModelName() + "? (1 to 5) ");
					double userRating = scan.nextDouble();
					
					//rates product using users input
					Shop1.getProduct(5).rateReliability(userRating);

					//shows the user the new rating for the product
					System.out.println("Thank you for your rating, " + Shop1.getProduct(userChoice).getModelName() + " now has a rating of: " + Shop1.getProduct(userChoice).getReliabilityRating() + "\n");
				}
			}
		}
	}
}
	