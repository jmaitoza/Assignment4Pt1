public class Consumer implements Runnable
{
    private final OneBuf buffer;

    public Consumer(OneBuf buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                String s = buffer.get();
                System.out.println("Consuming: " + s);
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
