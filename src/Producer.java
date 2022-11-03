import java.util.Random;

public class Producer implements Runnable
{
    private final OneBuf buffer;

    public Producer(OneBuf buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
       try
       {
            while(true)
            {
                Random r = new Random();
                char randomChar = (char)(r.nextInt(90-65)+65);
                System.out.println("Producer: " + randomChar);
                buffer.put(String.valueOf(randomChar));
                Thread.sleep(500);
            }
       } catch (InterruptedException e)
       {
           throw new RuntimeException(e);
       }
    }
}
