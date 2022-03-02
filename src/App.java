import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Это программа шифр цезаря");
        System.out.println("Введите признак шифровать или расшифровывать и размер сдвига");
        System.out.print("Признак шифрования: ");
        Scanner scanner = new Scanner(System.in);
        MyFileReader myFileReader = new MyFileReader();
        MyFileWriter myFileWriter = new MyFileWriter(myFileReader);
        myFileReader.setCryptValue(scanner.nextLine());
        /**
         * привязал выбор файлов для чтения и записи к признаку кодировки, легко можно переделать на входной параметр "путь до файла"
         */
        if ("зашифровать".equalsIgnoreCase(myFileReader.getCryptValue())) {
            myFileReader.setFileForReadName("NonEncrypted.txt");
            myFileWriter.setFileForWriteName("Encrypted.txt");
        } else if ("расшифровать".equalsIgnoreCase(myFileReader.getCryptValue())) {
            myFileReader.setFileForReadName("Encrypted.txt");
            myFileWriter.setFileForWriteName("NonEncrypted.txt");
        }
        System.out.print("Размер сдвига: ");
        myFileReader.setKey(scanner.nextInt());
        myFileWriter.writeFile();
    }
}
