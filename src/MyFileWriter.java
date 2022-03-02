import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Класс записывающий преобразованный текст в файл
 */
public class MyFileWriter {

    private MyFileReader myFileReader;
    private String fileForWriteName;
    /**
     * Конструктор класса
     */
    public MyFileWriter(MyFileReader myFileReader) {
        this.myFileReader = myFileReader;
    }
    /**
     * @return имя файла для записи
     */
    public String getFileForWriteName() {
        return fileForWriteName;
    }
    /**
     * Метод для задачи имени файла для записи
     */
    public void setFileForWriteName(String fileForWriteName) {
        this.fileForWriteName = fileForWriteName;
    }
    /**
     * Метод записывающий преобразованный тест
     */
    public void writeFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileForWriteName))) {
            StringBuilder newValue = myFileReader.determinateCryptAndReadFile();
            out.write(String.valueOf(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
