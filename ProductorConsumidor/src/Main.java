import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<String> lines = new ArrayList<String>();
        lines.add("Linea 1");
        lines.add("Linea 2");
        lines.add("Linea 3");
        lines.add("Linea 4");
        lines.add("Linea 5");
        lines.add("Linea 6");
        lines.add("Linea 7");
        lines.add("Linea 8");
        lines.add("Linea 9");

        List<String> lines2 = new ArrayList<String>();
        lines2.add("Linea 21");
        lines2.add("Linea 22");
        lines2.add("Linea 23");
        lines2.add("Linea 24");
        lines2.add("Linea 25");
        lines2.add("Linea 26");
        lines2.add("Linea 27");
        lines2.add("Linea 28");
        lines2.add("Linea 29");

        PrintBuffer buffer = new PrintBuffer();
        Printer printer = new Printer(buffer);

        PrintJob job = new PrintJob(lines, buffer);
        PrintJob job2 = new PrintJob(lines2, buffer);
        job2.start();
        job.start();
        printer.start();




    }
}
