import java.util.Iterator;

public class Pila<T>{
	
	Nodo<T> bottom;
	Nodo<T> top;
	
	public void push(T element) {
		
		Nodo<T> nodo = new Nodo<T>(element);
		
		if(bottom == null) {
			bottom = top = nodo;
		}else {
			top.setNext(nodo);
			top = nodo;
		}
	}
	
	public T pop() {
		
		if(bottom != null) {
			return bottom.getElement();
		}
		
		return null;
	}
	
	public int size() {
		
		int count = 0;
		Nodo<T> aux = bottom;
		
		while(aux != null) {
			
			aux = aux.getNext(); 
			count++;
		}
		
		return count;
	}
	
	
}
