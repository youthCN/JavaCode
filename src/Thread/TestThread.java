package Thread;

public class TestThread {
    public static void main(String[] args) {
        final Thread t1 = new Thread(){
            @Override
            public void run() {

                for (int i=0;i<100;i++){
                    boolean interrupted = isInterrupted();
                    System.out.println("interrupted = "+interrupted);
                    if (interrupted){
                        return;
                    }
                    System.out.println("i="+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        interrupt();
                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

}

