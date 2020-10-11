import java.util.Scanner;
import java.util.ArrayList;

class main
{
    static Scanner sc = new Scanner(System.in);
    int n;
    String str;
    static ArrayList<intialTask> brainDump = new ArrayList<intialTask>();
    //genTask lists
    static ArrayList<genTask> nextAction = new ArrayList<genTask>();
    static ArrayList<genTask> holdUps = new ArrayList<genTask>();
    static ArrayList<genTask> someday = new ArrayList<genTask>();
    //other lists
    static ArrayList<calendarTask> calendar = new ArrayList<calendarTask>();
    static ArrayList<deadTask> history =new ArrayList<deadTask>();
    static ArrayList<deadTask> graveyard =new ArrayList<deadTask>();
    static Boolean keepRunning = true;

    public static void main(String[] args)
    {
        intialTask sadness;
        genTask yikes;
        project oof;
        calendarTask helpMe;
        deadTask alas;
        ArrayList killMePlease;
        menu();
    }

    public static void menu()
    {
        String str; 
        System.out.println("Menu");
        System.out.println("1. Brain Dump a Task");
        System.out.println("2. Display Brain Dump List");
        System.out.println("3. View Lists");
        System.out.println("4. Process Brain Dump");
        System.out.println("5. Review lists");
        System.out.println("6. End Session");
        System.out.println("Please make your choice here");
        int  n = sc.nextInt();
        if(n == 1)
        {
            brainDumpTask();
        }
        else if(n == 2)
        {
            displayTask(brainDump);
        }
        else if(n == 3)
        {
            listsMenu();
        }
        else if(n == 4)
        {
            processBrainDump(brainDump);
        }
        else if(n == 5)
        {

        }
        else if(n == 6)
        {
            keepRunning = false;

        }
        else
        {
            System.out.print("Please enter a valid input");
            menu();
        }
        if(keepRunning)
        {
            menu();
        }

    }

    static void brainDumpTask()
    {
        String str;
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Enter Task Name:");
        str = in.nextLine();
        intialTask newIT = new intialTask(str,0);
        brainDump.add(newIT);

        System.out.println("Press 1 to continue");
        n = sc.nextInt();
        if(n==1)
        {
            System.out.println("Task Added!"); 

        }

    }

    static void displayTask(ArrayList<intialTask> list)
    {
        int n;
        if (list.isEmpty())
        {
            System.out.println("Error: No contents on this list.");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i+1)+". "+list.get(i).getTaskName());
            }
        }
        System.out.println("Press 1 to continue");
        n = sc.nextInt();
    }

    public static void displayTaskGen(ArrayList<genTask> list)
    {
        if (list.isEmpty())
        {
            System.out.println("Error: No contents on this list.");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i+1)+". "+list.get(i).getTaskName());
            }
        }

    }

    public static void displayTaskListCal(ArrayList<calendarTask> list)
    {
        if (list.isEmpty())
        {
            System.out.println("Error: No contents on this list.");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i+1)+". "+ list.get(i).getTaskName() +" Date: "+ list.get(i).getMonth()+"/"+list.get(i).getDay()+"/"+list.get(i).getYear());  
            }
        }

    }

    public static void displayTaskDead(ArrayList<deadTask> list)
    {
        if (list.isEmpty())
        {
            System.out.println("Error: No contents on this list.");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i+1)+". "+list.get(i).getTaskName());
            }
        }

    }

    public static void listsMenu()
    {
        System.out.println("Which menu would you like to see?");
        System.out.println("1. Next Action");
        System.out.println("2. Calendar");
        System.out.println("3. Holdups");
        System.out.println("4. Someday");
        System.out.println("5. Task History");
        System.out.println("6. Graveyard");
        int n = sc.nextInt();
        if(n == 1)
        {
            displayTaskGen(nextAction);
        }
        else if( n == 2)
        {
            displayTaskListCal(calendar);
        }
        else if( n == 3)
        {
            displayTaskGen(holdUps);
        }
        else if( n == 4)
        {
            displayTaskGen(someday);
        }
        else if( n == 5)
        {
            displayTaskDead(history);
        }
        else if( n == 6)
        {
            displayTaskDead(graveyard);
        }
        else
        {
            System.out.println("Please make a valid choice:");
            listsMenu();
        }

    }
    public static void processBrainDump(ArrayList<intialTask> list)
    {
        ArrayList<genTask> tempUrgent = new ArrayList<genTask>();

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getTaskName());
            System.out.println("Do you want to or need to do this task?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int n = sc.nextInt();
            if(n == 1)
            { 
                genTask tempGTU = new genTask((list.get(i).getTaskName()) ,2, 0, null);
                tempUrgent.add(tempGTU);
            }
            if(n == 2)
            {
                genTask tempGTN = new genTask((list.get(i).getTaskName()) ,1, 0, null);
                someday.add(tempGTN);
            }
        }
        for(int i = 0; i < tempUrgent.size(); i++)
        {
            System.out.println(tempUrgent.get(i).getTaskName());
            System.out.println("Do you have the means to complete this task currently?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int n = sc.nextInt();
            if(n == 1)
            {
                tempUrgent.get(i).setPossible(true);
            }
            if(n == 2)
            {
                genTask tempGTU = new genTask((list.get(i).getTaskName()) ,2, 0, false);
                holdUps.add(tempGTU);
                tempUrgent.remove(i);
            }

        }
        System.out.println("Time to complete the easy tasks");
        for(int i = 0; i < tempUrgent.size(); i++)
        {
            int t;
            int n;
            System.out.println(tempUrgent.get(i).getTaskName());
            System.out.println("Will this take less than 2 minutes to complete?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            n = sc.nextInt();
            if(n == 1)
            {
                System.out.println("Complete the task now.");
                System.out.println("Press 1 to continue");
                t = sc.nextInt();
                tempUrgent.remove(i);
            }

        }
        System.out.println("Plan next steps:");
        for(int i = 0; i < tempUrgent.size(); i++)
        {
            int n;
            String str;
            System.out.println(tempUrgent.get(i).getTaskName());
            System.out.println("Will this task require followup tasks");
            System.out.println("1. Yes");
            System.out.println("2. No");
            n = sc.nextInt();
            if(n == 1)
            {
                System.out.println("Would you like to add subtasks now?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                n = sc.nextInt();
                ArrayList<genTask> subtasks = new ArrayList<genTask>();
                project tempProject = new project(tempUrgent.get(i).getTaskName(),2,2,true,subtasks);

                boolean stasks;
                if(n== 1)
                {
                    stasks = true;
                }
                else 
                {
                    stasks = false;
                }
                while(stasks == true)
                {
                    int t;
                    System.out.println("Enter task name");
                    str = sc.nextLine();
                    genTask a = new genTask(str,0,0,null); 
                    tempProject.addSubTask(a);
                    System.out.println("Add another subtask?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    n = sc.nextInt();
                    System.out.println("Press 1 to continue");
                    t = sc.nextInt();
                    if(n== 1)
                    {
                        stasks = true;
                    }
                    else 
                    {
                        stasks = false;
                    }
                    

                }
                tempUrgent.remove(i);
            }

        }
        System.out.println("Organize the tasks");
        for(int i = 0; i < tempUrgent.size(); i++)
        { 
            int n;
            int m;
            int d;
            int y;
            System.out.println(tempUrgent.get(i).getTaskName());
            System.out.println("Is this task on a specific date?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            n = sc.nextInt();
            if(n == 1)
            {
                calendarTask event = new calendarTask(tempUrgent.get(i).getTaskName(),2,0,true,0,0,0); 
                System.out.println("Enter the month of the task 1-12");
                m = sc.nextInt();
                event.setMonth(m);
                d = sc.nextInt();
                event.setDay(d);
                y = sc.nextInt();
                event.setYear(y);
                calendar.add(event);
                tempUrgent.remove(i);
            }
            if(n == 2)
            {
                genTask tempGTU = new genTask((tempUrgent.get(i).getTaskName()) ,3, 0, false);
                nextAction.add(tempGTU);
                tempUrgent.remove(i);
            }

        }
        }
}