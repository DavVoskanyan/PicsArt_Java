import java.io.File;

public class SizeReader{
    public static int size = 0;
    public static boolean works = true;
    public void ReadSize(File folder) {
        for(File fileEntry : folder.listFiles()) {
            if(fileEntry.isDirectory()) {
                ReadSize(fileEntry);
            }
            else {
                this.size += fileEntry.length();
            }
        }
        this.works = false;
    }
}
