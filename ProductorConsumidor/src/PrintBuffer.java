public class PrintBuffer {

    private String data;
    private boolean available = false;

    public synchronized void setData(String value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Generando trabajo");
        this.data = value;
        available = true;
        notifyAll();
    }

    public synchronized String getData() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String currData = this.data;
        available = false;
        notifyAll();
        return currData;
    }
}
