
/** CSC 385 Module 1
 * Date: 1/17/2020
 * Author: Shawn Crahen
 */
public class Calendar {

  // constant data field
  public static final int MAXEVENTS = 4;
  
  // private data fields
  private Event[] events;
  private int numEvents;
  
  // constructor
  public Calendar() {
    events = new Event[MAXEVENTS];
    numEvents = 0;
  }
  
  // methods
  // adds new event in first null index - return true if successful and false if fails
  public boolean addEvent(Event e) {
    // if array !full add an event to events
    if (numEvents == MAXEVENTS)
      return false;
    else
      for (int i = 0; i < MAXEVENTS; i++) {
        if (events[i] == null) {
          events[i] = e;
          numEvents++;
          return true;
        }
      }
    return false;
  }
  
  // returns index of Event e or -1 if e doesn't exist
  public int findEvent(Event e) {
    for (int i = 0; i < MAXEVENTS; i++) {
      if (events[i] != null)
        if (events[i] == e)
          return i;      
    }
    return -1;
  }
  
  // finds index for event and removes if it exists - return true for success, false for fail
  public boolean removeEvent(Event e) {
    int event = findEvent(e);
    if (event == -1)
      return false;
    else {
      events[event] = null;
      numEvents--;
      return true;
    }
  }
  
  // prints all non-null entries in events array
  public void dump() {
    for (int i = 0; i < MAXEVENTS; i++) {
      if (events[i] != null)
        System.out.println(events[i]);
    }
  }
}
