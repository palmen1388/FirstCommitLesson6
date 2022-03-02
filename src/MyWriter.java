import java.io.*;

/**
 * Класс записывающий документ в кодировке
 */
public class MyWriter {

    private MyReader reader = new MyReader();
    private String codeValue;
    /**
     * Конструктор
     */
    public MyWriter(MyReader reader) {
        this.reader = reader;
    }
    /**
     * Метод для указания кодировки записываемого файла
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
    /**
     * Метод записывающий файл с учетом кодировки
     */
    public void writeFile() {
        try (BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream("FileForWrite.txt"), codeValue))) {
            StringBuilder newText = reader.readFile();
            out.write(String.valueOf(newText));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
