import java.util.Stack;

public class BeerHouse
{
	private static final int MAX_STOCK = 100;
	private int initialStock = 50;
	private Stack stock = new Stack();

	public BeerHouse(int InitialStock)
	{
		setInitialStock(InitialStock);
	}

	public int getInitialStock()
	{
		return initialStock;
	}

	public void setInitialStock(int initialStock)
	{
		for(int i=0; i < getInitialStock(); i++)
		{
			stock.push("Botella de Cerveza");
		}
		this.initialStock = initialStock;
	}

	public Stack getStock()
	{
		return stock;
	}

	public void setStock(Stack stock)
	{
		this.stock = stock;
	}
	
	public synchronized void agregarCerveza()
	{
		System.out.println(ConsoleColors.BLUE + "El stock es de " + stock.size() + ConsoleColors.RESET);
		
		if(stock.size() < MAX_STOCK)
		{
			stock.push("Botella de Cerveza");
			notifyAll();
		}
		else
		{
			try
			{
				wait();
			} catch (InterruptedException e) {}
		}
	}
	
	public synchronized void sacarCerveza()
	{
		System.out.println(ConsoleColors.BLUE + "El stock es de " + stock.size() + ConsoleColors.RESET);

		while(stock.empty())
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		stock.pop();
		notifyAll();
	}
}
