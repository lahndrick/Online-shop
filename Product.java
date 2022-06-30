/***

 * 

 * Lahndrick Hendricks

 * Student ID: 18954796

 * COMP503

 * Assessment Item: Individual Programming Assignment Part A

 * 
 **/

/*
 * This class is used for gathering information about each individual product
 * The variable and method names are extensive to ensure full explanation for what each is used for
 * 
 * The math behind reliability is:
 * New value of reliability rating = ((Old value of reliability rating * Old value of number of customers) + Reliability rating by this customer) / New value of numberof customers.
 * when a rating is not between 1 and 5 it will not be registered and a message describing that the given rating is not acceptable for the product
 * 
 * There is no default constructor, at the very minimum a model and manufacturer name is required
 * 
 * there are only two set methods (overall rating and retail price) but there are get methods for every instance variable
 */

public class Product 
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
