import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Press 1 for Producer/Consumer using conditional synchronization");
        System.out.println("Press 2 for Producer/Consumer using semaphores");
        System.out.println("Press 3 for bonus problem");
        System.out.println("Press any other key to exit");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input)
        {
            case 1:
                OneBuf.main();
//                break;
            case 2:
                OneBufSemaphore.main();
//                break;
            case 3:
                System.out.println("Running bonus problem");
                Control.main();
//                break;
            default:
                System.out.println("Exiting");
//                break;
        }
//        if (input == 1)
//        {
//            OneBuf.main();
//        }
//        else if (input == 2)
//        {
//            OneBufSemaphore.main();
//        }
//        else
//        {
//            System.exit(0);
//        }

    }
}