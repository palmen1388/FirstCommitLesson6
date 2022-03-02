import java.io.*;
/**
 * Класс читающий документ в кодировке
 */
public class MyReader {

    private String codeValue;
    /**
     * Метод для указания кодировки читаемого файла
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
    /**
     * Метод читающий документ в кодировке
     */
    public StringBuilder readFile() {
        StringBuilder container = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream("FileForRead.txt"), codeValue))) {
            String text = in.readLine();
            for (int i = 0; i < text.length(); i++){
                container.append(text.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(container);
        return container;
    }
}
