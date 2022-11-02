import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Press 1 for Producer/Consumer using conditional synchronization");
        System.out.println("Press 2 for Producer/Consumer using semaphores");
        System.out.println("Press any other key to exit");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1)
        {
            OneBuf.main();
        }
        if (input == 2)
        {
            OneBufSemaphore.main();
        }
        else
        {
            System.exit(0);
        }

    }
}