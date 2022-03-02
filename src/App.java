import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyReader reader = new MyReader();
        MyWriter writer = new MyWriter(reader);
        reader.setCodeValue(scanner.nextLine());
        writer.setCodeValue(scanner.nextLine());
        writer.writeFile();

    }
}
