import java.util.*;
import java.io.*;

public class ActivitySelection2
{
  static ArrayList<ClassTime> classes = new ArrayList<ClassTime>();
  public static void main(String[] args)
  {
    promptUserForInputs();
    checkForOverlap();
  }
  public static void promptUserForInputs() // static is not used like t1.isAfter(t2)... just called
  {

    boolean moreInput = false;
    System.out.println("Hi, enter your classes and requested info! ");

    do {
      Scanner kbd = new Scanner(System.in); // have to reset scanner each iteration
      // getting class name
      System.out.print("Class Name: ");
      String className = kbd.nextLine();
      //getting class date
      System.out.print("What day is " + className + " on: ");
      String day = kbd.nextLine();
      // getting class start
      System.out.print("When does "+ className + " start: ");
      System.out.print("Please enter in the form --> '00:00' ");
      String startTime = kbd.nextLine();

      System.out.print("When does "+ className + " end: ");
      System.out.print("Please enter in the form --> '00:00' ");
      String endTime = kbd.nextLine();


      ClassTime class1 = new ClassTime( className, day, startTime, endTime);
      classes.add(class1);
      System.out.println("Are you adding more classes? \n1) Yes\n2) No");

      int response = promptForResponse();

      if ( response == 1 )
        moreInput = true;
      else
        moreInput = false;


    } while ( moreInput );



  }
  // O(N^2) because won't be that many classes to check... like 4 - 7 AT MOST
  public static void checkForOverlap()
  {
    if ( classes.size() < 2 ) return;

    for ( int i = 0; i < classes.size(); i++ )
    {
      for ( int j = 1+i; j < classes.size(); j++ )
      {
        if ( classes.get(i).isOverlapping( classes.get(j) ) )
          System.out.println( classes.get(i).getClassName() + " is overlapping with " + classes.get(j).getClassName() );
      }
    }
  } // end of checkForOverlap()
  static int promptForResponse()
  {
    int response = 0;
    boolean isInt = true;
    do
    {
    try
    {
      Scanner in = new Scanner ( System.in );
      System.out.print("Enter either a one or a two: ");
      response = in.nextInt();

      if ( response == 1 || response == 2 )
        isInt = true;
      else
        throw new Exception();
    }
    catch ( Exception e)
    {
      //System.out.println("Enter a number: ");
      Scanner in = new Scanner ( System.in );
      isInt = false;
    }

  } while ( !isInt );
  return response;

  } // End of promptUser
} // End of Class ActivitySelection2
