package module5_event_competition;

abstract class Event {
    private int eventId;
    private String title, date, venue;
    public Event(int id, String title, String date, String venue) {
        this.eventId=id; this.title=title; this.date=date; this.venue=venue;
    }
    public String getTitle(){ return title; }
    public abstract void scheduleEvent();
}

class Competition extends Event {
    public Competition(int id,String t,String d,String v){super(id,t,d,v);}
    @Override public void scheduleEvent(){System.out.println("Competition scheduled: "+getTitle());}
}
class Workshop extends Event {
    public Workshop(int id,String t,String d,String v){super(id,t,d,v);}
    @Override public void scheduleEvent(){System.out.println("Workshop scheduled: "+getTitle());}
}
class EventRegistration { public void register(Event e){System.out.println("Registered for: "+e.getTitle());} }
class EventManager { public void schedule(Event e){e.scheduleEvent();} }
class Notification { public void send(String msg){System.out.println("Notification: "+msg);} }

public class Main {
    public static void main(String[] args) {
        Event e = new Competition(1,"Coding Competition","20-09-2026","College Lab");
        new EventManager().schedule(e);
        new EventRegistration().register(e);
        new Notification().send("Registration confirmed");
    }
}
