import java.util.Random;

public class SemProducer implements Runnable
{
    private final OneBufSemaphore sembuff;

    public SemProducer(OneBufSemaphore sembuff)
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
                Random r = new Random();
                var randomChar = (char)(r.nextInt(90-65)+65);
                System.out.println("Producer: " + randomChar);
                sembuff.put(String.valueOf(randomChar));
                Thread.sleep(100);
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
