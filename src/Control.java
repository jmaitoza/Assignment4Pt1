public class Control implements Runnable
{
    private final static int MaxPeople = 4;
    private Control museumControl;
    private boolean isMuseumOpen; // true if museum is open
    private int peopleInside;

    public Control()
    {
        museumControl = new Control();
    }

    synchronized void enterMuseum() throws InterruptedException
    {
        while (peopleInside < MaxPeople)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.err.println("InterruptedException caught");
            }
            peopleInside++;
            notifyAll();
            System.out.println("Person " + peopleInside + " has entered the museum");
        }
    }
    synchronized void leaveMuseum() throws InterruptedException
    {
        while (peopleInside > 0)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                System.err.println("InterruptedException caught");
            }
            peopleInside--;
            notifyAll();
            System.out.println("People inside: " + peopleInside);
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (isMuseumOpen)
            {
                System.out.println("Museum is open");
                try
                {
                    enterMuseum();
                    if (peopleInside == MaxPeople)
                    {
                        System.out.println("Museum is full");
                        isMuseumOpen = false;
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            if (!isMuseumOpen)
            {
                System.out.println("Museum is closed");
                try
                {
                    if (peopleInside < MaxPeople)
                        isMuseumOpen = true;
                    if (peopleInside == 0)
                    {
                        System.out.println("Museum is empty");
                        isMuseumOpen = true;
                    }
                    leaveMuseum();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main()
    {
//        Control arrivals = new Control();
//        Control departures = new Control();
        Control control = new Control();
        Thread arrivalsThread = new Thread(control);
        Thread departuresThread = new Thread(control);

        arrivalsThread.start();
        departuresThread.start();
    }
}
