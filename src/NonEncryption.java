/**
 * Класс с методом для расшифровки файла
 */
public class NonEncryption implements Cryptable {
    /**
     * Метод расшифровывающий файл с учетом сдвига
     */
    @Override
    public StringBuilder encrypt(String fileText, int key) {
        StringBuilder newFileText = new StringBuilder();
        int newChar;
        for (int i = 0; i < fileText.length(); i++) {
            if ((fileText.charAt(i) < 92 && (fileText.charAt(i) > 64))) {
                if (fileText.charAt(i) - key < 65){
                    newChar = (fileText.charAt(i) - key) + 26;
                } else {
                    newChar = ((fileText.charAt(i) - key) - 65) % 26 + 65;
                }
            } else {
                newChar = fileText.charAt(i);
            }
            newFileText.append((char) newChar);

        }
        return newFileText;
    }
}
