
/** CSC 385 Module 1
 * Date: 1/17/2020
 * Author: Shawn Crahen
 */
public class Date implements Comparable<Date> {
  
  // private data fields
  private int year; // between 2020 - 2030
  private int month; // between 1 - 12
  private int day; // between 1 - 31
  
  // constructor - initialize year, month, and day
  public Date(int year, int month, int day) throws IllegalArgumentException {
    // validate each argument - throw Exception if invalid
    if (year < 2020 || year > 2030 ||
        month < 1 || month > 12 ||
        day < 1 || day > 31)
      throw new IllegalArgumentException();
    else {
      this.year = year;
      this.month = month;
      this.day = day;
    }
  }
  
  // public accessors
  public int getYear() {
    return year;
  }
  
  public int getMonth() {
    return month;
  }
  
  public int getDay() {
    return day;
  }
  
  // other methods
  // override Object.toString()
  public String toString() {
    return month + "/" + day + "/" + year;
  }
  
  // override Object.equals(Object obj)
  public boolean equals(Object obj) {
    if (obj instanceof Date) // validate type of obj is Date
      return (year == ((Date)obj).year &&
              month == ((Date)obj).month &&
              day == ((Date)obj).day) ? true : false;
    else
      return false;
  }
  
  // implement compareTo(T o) from Comparable<T o> interface
  public int compareTo(Date otherDate) {
    // return 0 if this.equals(otherDate)
    // return -1 if this < otherDate
    // return 1 if this > otherDate
    if (this.equals(otherDate))
      return 0;
    
    if (year < otherDate.year)
      return -1;
    else if (year > otherDate.year)
      return 1;
    else if (year == otherDate.year && month < otherDate.month)
      return -1;
    else if (year == otherDate.year && month > otherDate.month)
      return 1;
    else if (year == otherDate.year && month == otherDate.month && day < otherDate.day)
      return -1;
    else
      return 1;
  }
}
