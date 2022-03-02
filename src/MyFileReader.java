import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс читающий закодированный или требующий кодировки файл
 */
public class MyFileReader {

    private String fileForReadName;
    private int key;
    private String cryptValue;
    private Encryption encryption = new Encryption();
    private NonEncryption nonEncryption = new NonEncryption();
    /**
     * @return размер сдвига
     */
    public int getKey() {
        return key;
    }
    /**
     * Метод для задачи размера сдвига
     */
    public void setKey(int key) {
        this.key = key;
    }
    /**
     * @return признак кодировки
     */
    public String getCryptValue() {
        return cryptValue;
    }
    /**
     * Метод для задачи признака кодировки
     */
    public void setCryptValue(String cryptValue) {
        this.cryptValue = cryptValue;
    }
    /**
     * @return имя файла для чтения
     */
    public String getFileForReadName() {
        return fileForReadName;
    }
    /**
     * Метод для задачи имени файла для чтения
     */
    public void setFileForReadName(String fileForReadName) {
        this.fileForReadName = fileForReadName;
    }
    /**
     * Метод для определения метода чтения по признаку кодировки
     */
    public StringBuilder determinateCryptAndReadFile() {
        if ("зашифровать".equalsIgnoreCase(cryptValue)) {
            return this.nonEncryptedFileRead();
        }
        if ("расшифровать".equalsIgnoreCase(cryptValue)) {
            return this.EncryptedFileRead();
        }
        return null;
    }
    /**
     * Метод чтения незакодированного файла
     */
    public StringBuilder nonEncryptedFileRead() {
        StringBuilder newFileText = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(fileForReadName))) {
            String fileText = in.readLine().toUpperCase();
            newFileText = encryption.encrypt(fileText, key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileText;
    }
    /**
     * Метод чтения закодированного файла
     */
    public StringBuilder EncryptedFileRead() {
        StringBuilder newFileText = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(fileForReadName))) {
            String fileText = in.readLine().toUpperCase();
            newFileText = nonEncryption.encrypt(fileText, key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileText;
    }
}
