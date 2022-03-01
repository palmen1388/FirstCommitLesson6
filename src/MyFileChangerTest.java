import org.junit.Test;
import org.junit.Assert;

public class MyFileChangerTest {

    @Test
    public void readFile() {
        MyFileChanger myFileChanger = new MyFileChanger();
        myFileChanger.readFile();
        Assert.assertEquals("Строка 1 8\n" + "Это строка 2 12\n", myFileChanger.readFile());
    }
}