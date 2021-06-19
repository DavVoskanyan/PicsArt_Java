import java.io.File;

public class Test {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\User\\Desktop\\fileWork");
        SizeReader sr = new SizeReader();
        sr.ReadSize(folder);
        SizeWriter sw = new SizeWriter();
        sw.run();
    }
}
