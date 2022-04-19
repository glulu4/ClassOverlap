import java.util.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;


public class ClassTime
{
  String className;
  DayOfWeek day; // an all caps text of day
  LocalTime startTime; // parsed string into a LocalTime
  LocalTime endTime; // parsed string into a LocalTime

  public ClassTime(String className, String day, String startTime, String endTime )
  {
    setLabel(className);
    setDay(day);
    setStartTime(startTime);
    setEndTime(endTime);
  }

  // setters
  public void setLabel( String className )
  {
    className = className.toLowerCase();
    this.className = className.substring(0, 1).toUpperCase() + className.substring(1); // stores capitalized version
  }

  public void setDay( String day )
  {
    day = day.toUpperCase();
    this.day = DayOfWeek.valueOf(day);
  }

  public void setStartTime( String startTime )
  {
    this.startTime = LocalTime.parse(startTime);
  }

  public void setEndTime( String endTime )
  {
    this.endTime = LocalTime.parse(endTime);
  }

  // getters
  public String getClassName()
  {
    return className;
  }
  public String getDayName()
  {
    String dayOfWeekName = day.getDisplayName(TextStyle.FULL, Locale.getDefault());
    return dayOfWeekName;
  }

  public int getDayVal()
  {
    return day.getValue();
  }

  public LocalTime getStartTime()
  {
    return startTime;
  }
  public LocalTime getEndTime()
  {
    return endTime;
  }

  public String toString()
  {
    String result = "";
    return result + this.getClassName() + " " + this.getDayName()  + " " + this.getStartTime()  + " "+ this.getEndTime();
  }

  public boolean isOverlapping( ClassTime other )
  {
    if ( this.getDayVal() != other.getDayVal() ) // if they're not on the same day ... later change to if they are not on the same 2 day cycle
      return false;
    // you make it past here there they're on the same day

    return !( this.getStartTime().isAfter(other.getEndTime()) ) && !(other.getStartTime().isAfter(this.getEndTime()) );
  }
  // notes about above function...
  // 1) if it either starts or ends at the same time, it will be considered overlapping and return false
  // this == day1
  // other == day2
  // time1.isOverlapping(time2) == if time1 is overlapping time 2 aka time 1 is crossing over into t2 - return true


} // End of Class
