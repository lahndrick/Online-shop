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
