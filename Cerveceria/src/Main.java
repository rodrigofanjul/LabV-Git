import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		BeerHouse cerveceria = new BeerHouse(100);
		
		BeerProducer productor = new BeerProducer(cerveceria);

		List<BeerConsumer> consumidores = new ArrayList<BeerConsumer>();
		consumidores.add(new BeerConsumer(cerveceria,"Rodrigo"));
		consumidores.add(new BeerConsumer(cerveceria,"German"));
		consumidores.add(new BeerConsumer(cerveceria,"Manuel"));

		// Comienzo del negocio
		productor.start();
		int i = 0;
		for (BeerConsumer c: consumidores){
			c.start();
		}
	}
}
