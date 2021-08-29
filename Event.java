
/** CSC 385 Module 1
 * Date: 1/17/2020
 * Author: Shawn Crahen
 */
public class Event {
  
  // private data fields
  private Date date;
  private int start, end; // must be between 0 - 23
  private String description;
  
  // constructor
  public Event(Date date, int start, int end, String description) throws IllegalArgumentException {
    // validate "start" and "end" - if (start > end) throw Exception
    //                            - if (start/end < 0 || start/end > 23) throw Exception
    if (start < 0 || start > 23 ||
        end < 0 || end > 23 ||
        start > end)
      throw new IllegalArgumentException();
    else {
      this.date = date;
      this.start = start;
      this.end = end;
      this.description = description;
    }
  }
  
  // public accessors
  public Date getDate() {
    return date;
  }
  
  public int getStart() {
    return start;
  }
  
  public int getEnd() {
    return end;
  }
  
  public String getDescription() {
    return description;
  }
  
  // public mutators
  public void setDescription(String newDescription) {
    description = newDescription;
  }
  
  // other methods
  // override Object.toString()
  public String toString() {
    return date.toString() + " " + start + "--" + end + ":" + description;
  }
  
  // override Object.equals(Object obj)
  public boolean equals(Object obj) {
    if (obj instanceof Event)
      return (date.equals(((Event)obj).date) &&
              start == ((Event)obj).start &&
              end == ((Event)obj).end &&
              description.equals(((Event)obj).description)) ? true : false;
    else
      return false;
  }
}
