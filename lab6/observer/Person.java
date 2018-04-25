import static java.lang.String.format;

public class Person implements Observer {

    private String name;
    private String alarmTime;

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
        if (o instanceof AlarmClock && args instanceof String) {
            AlarmClock alarmClock = (AlarmClock) o;
            if (args.equals("tick") && alarmClock.alarmReached()) {
                System.out.println("Time is: " + alarmClock.getTime());
                wakeUp();
            } else if (args.equals("setAlarmTime")) {
                alarmTime = alarmClock.getAlarmTime();
                System.out.println(format("Alarm time set for %s is: %s", name, alarmTime));
            }
        }
    }
}
