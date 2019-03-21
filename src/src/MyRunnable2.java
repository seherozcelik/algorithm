
public class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        go();
    }
    
    public void go(){
            
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        doMore();
    }
    
    public void doMore(){
        System.out.println("top o' the stack");
    }

}
