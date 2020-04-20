import javax.xml.transform.sax.SAXSource;
import java.util.Random;

public class BeerProducer extends Thread
{
	public static final String PRODUCER_NAME = "Antares";
	public static final int PRODUCER_SPEED = 500;
	private BeerHouse cerveceria;
	
	public BeerProducer(BeerHouse cerveceria)
	{
		setCerveceria(cerveceria);
	}

	public BeerHouse getCerveceria()
	{
		return cerveceria;
	}

	public void setCerveceria(BeerHouse cerveceria)
	{
		this.cerveceria = cerveceria;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				cerveceria.agregarCerveza();
				System.out.println(ConsoleColors.GREEN + "El productor" + PRODUCER_NAME + " ha fabricado 1 cerveza" + ConsoleColors.RESET);
				BeerProducer.sleep((long)aleatorio());
			}
			
		} catch (InterruptedException e) {}
	}

	private int aleatorio()
	{
		Random rand = new Random();
		int val = rand.nextInt(PRODUCER_SPEED)+PRODUCER_SPEED;
		return val;
	}
}
