public class SemConsumer implements Runnable
{
    private final OneBufSemaphore sembuff;

    public SemConsumer(OneBufSemaphore sembuff)
    {
        this.sembuff = sembuff;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                String s = (String) sembuff.get();
                System.out.println("Consuming: " + s);
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
