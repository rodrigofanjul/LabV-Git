import java.util.Random;

public class BeerConsumer extends Thread{

	public static final int CONSUMER_SPEED = 750;
	private String nombre;
	private BeerHouse cerveceria;
	
	public BeerConsumer(BeerHouse cerveceria, String nombre)
	{
		setCerveceria(cerveceria);
		setNombre(nombre);
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
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
				cerveceria.sacarCerveza();
				System.out.println(ConsoleColors.RED + nombre + " se tomo una cerveza." + ConsoleColors.RESET);
				BeerConsumer.sleep((long)aleatorio());
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
	
	private int aleatorio()
    {
        Random rand = new Random();
        int val = rand.nextInt(CONSUMER_SPEED)+CONSUMER_SPEED;
        return val;
    }
}


