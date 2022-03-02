/**
 * Класс с методом кодировки текста
 */
public class Encryption implements Cryptable {
    /**
     * Метод Кодирующий текст учитывая размер сдвига
     */
    @Override
    public StringBuilder encrypt(String fileText, int key) {
        StringBuilder newFileText = new StringBuilder();
        int newChar;
        for (int i = 0; i < fileText.length(); i++) {
            if ((fileText.charAt(i) < 92 && (fileText.charAt(i) > 64))) {
                newChar = ((fileText.charAt(i) + key) - 65) % 26 + 65;
            } else {
                newChar = fileText.charAt(i);
            }
            newFileText.append((char) newChar);
        }
        return newFileText;
    }
}
