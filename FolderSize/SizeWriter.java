public class SizeWriter extends Thread{
    @Override
    public void run() {
        while(SizeReader.works) {
            System.out.println(SizeReader.size);
        }
    }
}