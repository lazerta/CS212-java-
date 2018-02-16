import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class ProductSort 
{
	static void sortId(Product[] list)
	{
		for(int i = 1; i < list.length; i++)
		{     int j = i-1;
		        Product tem = null;
			while(j >= 0 && (list[j].getId() > list[i].getId()) )
			{
			       tem = list[i];
			       list[i] = list[j];
			       list[j] = tem;
			        i = j;
			        j--;
			}
		}
	}
	static void sortPrice(Product[] list)
	{
		for(int i = 1; i < list.length; i++)
		{     int j = i-1;
		      Product tem = null;		   
			while(j >= 0 && (list[j].getPrice() > list[i].getPrice()) )
			{
				 tem = list[i];
			       list[i] = list[j];
			       list[j] = tem;
			        i = j;
			        j--;
			}
		}
	}
	static void sortBrand(Product[] list)
	{
		for(int i = 1; i < list.length; i++)
		{     int j = i-1;
			  Product tem = null;
			while(j >= 0 && (0 > list[j].getBrand().compareTo(list[i].getBrand())) )
			{
				 tem = list[i];
			       list[i] = list[j];
			       list[j] = tem;
			        i = j;
			        j--;
			}
		}
	}
  static void sortProduct(Product[] list)
  {
	  for(int i = 1; i < list.length; i++)
		{     int j = i-1;
		     Product tem = null;
			while(j >= 0 && (0 > list[j].getProduct().compareTo(list[i].getProduct())) )
			{
				 tem = list[i];
			       list[i] = list[j];
			       list[j] = tem;
			        i = j;
			        j--;
			}
		}
  }
	public static void main(String[] args)
	{                                          
		Scanner input = null;
		PrintWriter output = null;
		File out = null;
		File in = null;
		int counter = 0;
		String criteria = null;
		
		//  args test for input and output
		switch(args.length)
		{
		case 1:
		{
			input = new Scanner(System.in);
			output = new PrintWriter(System.out);
			criteria = args[0];
			break;
		}
		case 3:
		{   criteria = args[0];
			in = new File(args[1]);
			out = new File(args[2]);
		   try 
		   {
			input = new Scanner(in);
			output = new PrintWriter(out);
		   }
		   catch(Exception e)
		   {
			   System.err.print("Invalid input or output files\n");
		   }
		   break;
		}
		 default:
		 {
			 System.err.print("Learn how to use the program\n");
			  System.exit(1);
		 }
			 
		}
		
		// the end of input and output setup.
		int n = 0;
		try
		{
		 n = Integer.parseInt(input.nextLine());
		 if(n == 0)
		 {
			 System.exit(1);
		 }
		}
		catch(Exception e)
		{
			System.err.println("Can not parse into int");
			System.exit(1);
			
		}
		Product[] list = new Product[n];
		// set up array for product objects and check if the input is valid or not.
		for(int i = 0; i < n; i++)
		{
			list[i] = new Product();
			if(list[i].read(input))
			{
			 counter++;
			}
			else
			{
				list[i] = null;
			}
		}
		input.close();
		// the end of initialized the Product array and input.
		
		// create an new array of valid input and delete original array/
		Product[]validList = new Product[counter];
		int valid = 0;
		for(int i = 0; i < n; i++)
		{
			if(list[i] != null)
			{
			  validList[valid] = list[i];
			  valid++;
			}
		}
		  list = null;
		// end of creating array for valid product
		criteria = criteria.toLowerCase(); 
		// calling sort method using different criteria.
		
		switch(criteria)
		{
		case "price":
		 {
			sortPrice(validList);
		 }
			break;
		case "brand":
		{
			sortBrand(validList);
		}
		    break;
		case "product":
		{
			sortProduct(validList);
		}
			break;
		case "id":
		{
			sortId(validList);
		}
			break;
		default:
		{
			System.err.println("No such criteria !");
			System.exit(1);
		}
		}
		// the end of determining  appropriate sorting method
		
	// initialized array	
	
	//write out the result
	 output.println(" Number of products entered "+n);
	 output.println(" Number of valid products "+ counter);
	 for(int i = 0; i < counter; i++)
	 {
			 validList[i].write(output);
	 }
	     output.close();
}
}
