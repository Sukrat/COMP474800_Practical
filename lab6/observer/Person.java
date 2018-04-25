
public class Person implements Observer {

    private String name;

    public Person(String a_name) {
        name = a_name;
    }

    public void goToBed() {
        System.out.println(name + " is going to bed...");
    }

    public void wakeUp() {
        System.out.println(name + " has woken up!");
    }

    @Override
    public void update(Subject o, Object args) {
        if (o instanceof AlarmClock) {
            AlarmClock alarmClock = (AlarmClock) o;
            if (alarmClock.alarmReached()) {
                System.out.println("Time is: " + alarmClock.getTime());
                wakeUp();
            }
        }
    }
}
