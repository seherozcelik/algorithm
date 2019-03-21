public class ThreadTester2 {

    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable2();
        Thread myThread = new Thread(threadJob);
        
        myThread.start();
        
        System.out.println("back in main");
    }

}
