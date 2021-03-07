package common.Thread;

import java.util.concurrent.Executor;

public class TestExecutor {
    public static void main(String[] args) {
        Executor executor1 = new DirExecutor();
        executor1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("curThread execute1 ="+Thread.currentThread().getName());
            }
        });
        executor1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("curThread execute2 ="+Thread.currentThread().getName());
            }
        });
    }
}
class DirExecutor implements Executor{

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}