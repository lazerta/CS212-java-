import java.util.Scanner;
import java.io.PrintWriter;

public class Product {
		private String brand = "";
		private int price = -1;
		private String product = "";
		private long id = 0;  
Product()
	{
		
	}

Product(int id, String brand, String product, int price)
	{
	 this.id = id;
	 this.brand = brand;
	 this.product = product;
	 this.price = price;
	}

void setBrand(String a)
	{
		brand = a;
	}

void setProduct(String product)
	{
		this.product = product;
	}

void setPrice(int price)
	{
		this.price = price;
	}

void setId( long id)
	{
	  this.id = id;
	}
String getBrand()

	{
		return brand;
	}
String getProduct()

	{
		return product;
	}
int getPrice()

	{
		return price;
	}
long getId()

	{
	
	 return id;	
	}
boolean read(Scanner input )
	
{
	     String tem = input.nextLine();
	     
		Scanner tokenized = new Scanner(tem).useDelimiter("\t");
	     String token = tokenized.next();
	    if(token.length() != 10)
	    {
	    	return false;
	    }
try { 

	    {  
	    
	    	id = Long.parseLong(token);
	    }
	    brand = tokenized.next();
	    product = tokenized.next();
	    price = Integer.parseInt(tokenized.next());
	   }
catch(Exception e)
	   {
		 return false;
	   }
      tokenized.close();
	    if(brand.length() == 0 || product.length() == 0 || price < 0 || id < 0)
	    {
	    	return false;
	    }
	    
	   return true;
	}
void write(PrintWriter out)
{
	
try
	{
		out.printf("%010d\t%s\t%-10s\t%d%n",id,brand,product,price);
		out.flush();
	}
catch(Exception e)
{
	System.err.println("Error!");
}
}
}


