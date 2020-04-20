//GUIA DE EJERCICIOS UNIDAD 5(TIPOS GENERICOS)
//1) Y 2)

import java.util.ArrayList;
import java.util.List;

public class Generics<T extends Comparable> {
	
	private List<T> lista = new ArrayList<T>();
	
	public void add(T element) {
		lista.add(element);
	}
	
	public boolean exists(T element) {
		
		for (T value : lista) {
			if(value.equals(element)) {
				return true;
			}
		}
		
		return false;
	}
	
	public T getMax() {
		
		if(lista.size() > 0) {
			
			T maxValue = lista.get(lista.size()-1);
			
			for (T value : lista) {
				if(maxValue.compareTo(value) < 0) {
					maxValue = value;
				}
			}
			
			return maxValue;
		}
		
		return null;
	}
	
	public T getMin() {
		
		if(lista.size() > 0) {
			
			T minValue = lista.get(lista.size()-1);
			
			for (T value : lista) {
				if(minValue.compareTo(value) > 0) {
					minValue = value;
				}
			}
			
			return minValue;
		}
		
		return null;
	}
	
	public T deleteLast() {
		
		if(lista.size() > 0) {
			return lista.remove(lista.size()-1);
		}
		
		return null;
	}
	
	
}
