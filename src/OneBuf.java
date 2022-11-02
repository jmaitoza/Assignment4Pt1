public class OneBuf
{
    private int slot; // buffer
    private boolean empty = true; // buffer is empty

    public synchronized int get() throws InterruptedException
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

    public synchronized void put(int item) throws InterruptedException
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
}
