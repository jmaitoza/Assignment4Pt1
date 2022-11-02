import java.io.IOException;

public class OneBuf
{
    private String slot; // buffer
    private boolean empty = true; // buffer is empty

    public synchronized String get() throws InterruptedException
    {
        while (empty)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.err.println("InterruptedException caught");
            }
        }
        empty = true;
        notifyAll();
        return slot;
    }

    public synchronized void put(String item) throws InterruptedException
    {
        while (!empty)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.err.println("InterruptedException caught");
            }
        }
        slot = item;
        empty = false;
        notifyAll();
    }

    public static void main()
    {
        OneBuf buffer = new OneBuf();
        Producer prod = new Producer(buffer);
        Consumer cons = new Consumer(buffer);

        Thread prodThread = new Thread(prod);
        Thread consThread = new Thread(cons);
        System.out.println("Starting threads using condition synchronization");
        prodThread.start();
        consThread.start();


    }
}
