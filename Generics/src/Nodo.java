public class Nodo<T> {

	private T element;
	private Nodo<T> next;
	
	public Nodo(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public Nodo<T> getNext(){
		return next;
	}
	
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}
