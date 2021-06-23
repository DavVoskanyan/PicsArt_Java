import java.io.File;

public class SizeReader extends Thread{
    public static int size = 0;
    public static boolean works = true;
    public static File folder;
    SizeReader(File f) {
        this.folder = f;
    }
    public void run() {
        read(this.folder);
        this.works = false;
        System.out.printf("\n%d byte",this.size);
    }
    public void read(File fold) {
        for(File fileEntry : fold.listFiles()) {
            if(fileEntry.isDirectory()) {
                read(fileEntry);
            }
            else {
                this.size += fileEntry.length();
            }
        }
    }
}
