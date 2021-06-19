public class SizeWriter extends Thread{
    @Override
    public void run() {
        while(SizeReader.works) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(SizeReader.size);
        }
        System.out.printf("%d byte",SizeReader.size);
    }
}