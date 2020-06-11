package common.Reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class TestReference {
    public static void main(String[] args) {
        //创建一个引用队列
        ReferenceQueue queue = new ReferenceQueue();
        //创建弱引用，此时状态为Active，并且Reference.pending为空，当前Reference.queue = 上面创建的queue，并且next=null
        WeakReference reference = new WeakReference(new Object(), queue);
        System.out.println(reference);
        //当GC执行后，由于是弱引用，所以回收该object对象，并且置于pending上，此时reference的状态为PENDING
        System.gc();

        /* ReferenceHandler从pending中取下该元素，并且将该元素放入到queue中，此时Reference状态为ENQUEUED，common.Reference.queue = ReferenceENQUEUED */
        /* 当从queue里面取出该元素，则变为INACTIVE，common.Reference.queue = common.Reference.NULL */
        Reference reference1 = null;//reference1和reference指向同一个对象
        try {
            reference1 = queue.remove();
            System.out.println(reference1);
            System.out.println(reference1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
