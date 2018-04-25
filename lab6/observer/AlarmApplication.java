
public class AlarmApplication {

    public static final int SECONDS_IN_DAY = 86400;

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.setAlarmTime(7, 30, 0);

        Person jack = new Person("Jack");
        jack.goToBed();
        alarmClock.attach(jack);

        Person sukrat = new Person("Sukrat");
        sukrat.goToBed();
        alarmClock.attach(sukrat);

        Person benny = new Person("Benny");
        benny.goToBed();
        alarmClock.attach(benny);

        Cron cron = new Cron(9, 30, 5);
        alarmClock.attach(cron);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 1; i <= SECONDS_IN_DAY; i++) {
            alarmClock.tick();
        }
    }
}