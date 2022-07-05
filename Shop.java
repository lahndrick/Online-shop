/************************************************************************
*			Shop CLASS STARTS HERE
************************************************************************/

/* This is used for the online store(s) the products are stored in
 * 
 * it includes a method to rate a product, a method to add a new product to a store, the ability to retrieve an item from a store as well as a change to the default toString
 * 
 * the products are the elements of an array called inventory, with a limit of five products per store
 * if adding a new product to the store means surpassing the limit of the store, the user will be notified with a message
 * 
 * products are retrieved using the numbers 1 to 5 instead of 0 to 4, using number 1 will retrieve array element 0, using number 2 will mean element 1 and so forth
 * if a number that is not between 1 and 5 (inclusive), null is returned
 * */

import java.util.Scanner;

public class Shop 
{

	//private instance variable/array for this class
	private Product[] inventory = new Product[5];
	private int nProduct = 0;
	
	// default constructor for initialising inventory and setting nproduct to 0
	public Shop() 
	{
		this.nProduct = 0;
		
		for(int x = 0;x < inventory.length; x++)
		{
			this.inventory[x] = null;
		}
	}
	
	//adds a new product to inventory, if inventory is not full
	public void addNewProduct(Product object)
	{
		if(this.nProduct <= 4)
		{
			//nProduct used to specify which element in array
			this.inventory[this.nProduct] = object;
			this.nProduct += 1;
		}
		else
		{
			System.out.println("This store has reached its limit of inventory, " + object.getModelName() + " can not be added.\n");
		}
	}
	
	// toString method to return all products in inventory
	public String toString() 
	{
		//for loop used to only show the products in store/elements in array that are not null
		for(int x = 0; x < this.nProduct; x++)
		{
			System.out.println(x + 1 +  ". " + this.inventory[x]);
		}

		//return statement creating a seperation line after
		return "\n";
	}
	
	//returns the product, if input is between 1 and 5(inclusive)
	public Product getProduct(int x)
	{
		if(x > 0 && x <= 5)
		{
			return this.inventory[x-1];
		}
		
		return null;
	}
}

/************************************************************************
*			Product CLASS STARTS HERE
************************************************************************/

/*
 * This class is used for gathering information about each individual product
 * The variable and method names are extensive to ensure full explanation for what each is used for
 * 
 * The math behind reliability is:
 * New value of reliability rating = ((Old value of reliability rating * Old number of customers before rating) + Reliability rating by this customer) / New number of customers after rating.
 * when a rating is not between 1 and 5 it will not be registered and a message describing that the given rating is not acceptable for the product will be given
 * 
 * There is no default constructor, at the very minimum a model and manufacturer name is required
 * 
 * there are only two set methods (overall rating and retail price) but there are get methods for every instance variable
 */

class Product 
{
	private String modelName;
	private String manufacturerName;
	private Double retailPrice;
	private String overallRating;
	private double reliabilityRating;
	private int numberOfConsumers;
	
	//for retrieving model name
	public String getModelName() 
	{
		return this.modelName;
	}

	//for retrieving manufacturer name
	public String getManufacturerName() 
	{
		return this.manufacturerName;
	}

	//for retrieving retail price
	public Double getRetailPrice() 
	{
		return this.retailPrice;
	}

	//for retrieving overal rating
	public String getOverallRating() 
	{
		return this.overallRating;
	}
	
	//for retrieving reliability rating
	public double getReliabilityRating() 
	{
		return this.reliabilityRating;
	}

	//for retrieving current number of customers
	public int getNumberOfConsumers() 
	{
		return this.numberOfConsumers;
	}
	
	//for setting retail price
	public void setRetailPrice(Double retailPrice) 
	{
		this.retailPrice = retailPrice;
	}
	
	//for setting overall rating
	public void setOverallRating(String overallRating) 
	{
		this.overallRating = overallRating;
	}

	//3 input constructor for model name, manufacturer name and retail price, default value the rest of the instance variables
	public Product(String modelName, String manufacturerName, double retailPrice)
	{
		this.modelName = modelName;
		this.manufacturerName = manufacturerName;
		this.retailPrice = retailPrice;
		this.overallRating = "F";
		this.reliabilityRating = 0;
		this.numberOfConsumers = 0;
	}
	
	//2 input constructor for model and manufacturer name, default value the rest of the instance variables
	public Product(String modelName, String manufacturerName)
	{
		this.modelName = modelName;
		this.manufacturerName = manufacturerName;
		this.retailPrice = 0.0;
		this.overallRating = "F";
		this.reliabilityRating = 0;
		this.numberOfConsumers = 0;
	}
	
	//a toString method to describe the product
	public String toString()
	{
		return this.getModelName() + ", " +  this.getManufacturerName() + ", $" + this.getRetailPrice() + ", " + this.getOverallRating() + ", " + this.getReliabilityRating() + " (based on " + this.getNumberOfConsumers() + " customer ratings)";
	}
	
	//this is used to rate the reliability, math is broken up to parts to ensure accuracy as well as simplify readability
	public double rateReliability(double userRating)
	{
		//variables used for this equation
		
		int newNumberOfConsumers;
		double newReliabilityrating;
		
		if(userRating > 0 && userRating <= 5)
		{
			newReliabilityrating = this.getReliabilityRating() * this.getNumberOfConsumers();
			newReliabilityrating += userRating;
			newNumberOfConsumers = this.getNumberOfConsumers() + 1;
			newReliabilityrating = newReliabilityrating / newNumberOfConsumers;
			
			//incrementing number of customers each time a rating is conducted
			this.numberOfConsumers += 1;
			
			this.reliabilityRating = newReliabilityrating;
			
			//if statements to set the overall rating of a product according to reliability rating
			if(this.reliabilityRating == 5)
			{
				this.setOverallRating("A");
			}
			else if(this.reliabilityRating >= 4)
			{
				this.setOverallRating("B");
			}
			else if(this.reliabilityRating >= 3)
			{
				this.setOverallRating("C");
			}
			else if(this.reliabilityRating >= 2)
			{
				this.setOverallRating("D");
			}
			else if(this.reliabilityRating >= 1)
			{
				this.setOverallRating("E");
			}
			else
			{
				this.setOverallRating("F");
			}
		}
		else
		{
			System.out.println("The rating of: " + userRating + ", on product: " + this.modelName +", is not acceptable.\n");
			
		}
			
		return this.reliabilityRating;
	}
}

/************************************************************************
*			App CLASS STARTS HERE
************************************************************************/

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



class App 
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
		Shop Shop1 = new Shop();

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
