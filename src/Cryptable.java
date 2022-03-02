/**
 * Интерфейс объявляющий метод кодировки
 */
public interface Cryptable {
    /**
     * Метод кодировки
     */
    StringBuilder encrypt(String fileText, int key);
}
