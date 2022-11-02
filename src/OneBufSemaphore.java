import java.util.concurrent.Semaphore;

public class OneBufSemaphore
{
    Object slot = null; // buffer
    private final Semaphore empty = new Semaphore(1);
    private final Semaphore full = new Semaphore(0);

    // add your implementation of method: void put(Object o)
    public void put (Object o) throws InterruptedException
    {
        empty.acquire();
        slot = o;
        full.release();
    }


    //add your implementation of method: Object get()
    public Object get () throws InterruptedException
    {
        full.acquire();
        Object o = slot;
        slot = null;
        empty.release();
        return o;
    }

    public static void main()
    {
        OneBufSemaphore sembuff = new OneBufSemaphore();
        SemProducer semprod = new SemProducer(sembuff);
        SemConsumer semcons = new SemConsumer(sembuff);

        Thread semProdThread = new Thread(semprod);
        Thread semConsThread = new Thread(semcons);
        System.out.println("Starting threads using semaphores");
        semProdThread.start();
        semConsThread.start();
    }
}
