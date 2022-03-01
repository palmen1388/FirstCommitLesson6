import java.io.*;

/**
 * Класс, который читает файл построчно, считает количество
 * элементов в строке и записывает все
 * в новый файл добавляя значения количества символов в строке
 */

public class MyFileChanger {
    /**
     * @return метод, который читает файл и считает количество символов в строке
     */
    public String readFile() {
        int counter = 0;
        /**
         * объявляем StringBuilder, чтобы использовать метод append для прибавления нужных символов и значений к строке
         */
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader("myFile.txt"))) {
            String value = in.readLine();
            while (value != null) {
                /**
                 * Разбиваем строку на символы и добавляем в массив для подсчета символов
                 */
                char[] values = value.toCharArray();
                /**
                 * Считаем символы
                 */
                for (int i = 0; i <= values.length; i++) {
                    /**
                     * Собираем строку для записи в новый файл
                     */
                    if (i == values.length) {
                        result.append(value).append(" ").append(i).append("\n");
                    }
                }
                value = in.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * Метод записывающий новый файл построчно
     */
    public void writeFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("newFileWithCountedCharsInLines"))) {
            String newValue = this.readFile();
            out.write(newValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
