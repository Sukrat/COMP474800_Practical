import static java.lang.String.format;

public class Cron implements Observer {

    private int hours;
    private int minutes;
    private int seconds;

    public Cron(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public void update(Subject o, Object args) {
        if (o instanceof AlarmClock) {
            AlarmClock alarmClock = (AlarmClock) o;
            if (alarmClock.timeIs(hours, minutes, seconds)) {
                System.out
                        .println(format("Hello, the time is %s and I am cron at your service.", alarmClock.getTime()));
            }
        }
    }

}