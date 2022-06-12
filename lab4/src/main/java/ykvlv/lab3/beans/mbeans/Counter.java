package ykvlv.lab3.beans.mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Counter extends NotificationBroadcasterSupport implements CounterMBean {
    private int allHits = 0;
    private int failHits = 0;
    private boolean wasInArea = true;

    private long sequence = 0;

    public void countHits(boolean isInArea) {
        allHits++;
        failHits += !isInArea ? 1 : 0;
        if (!wasInArea && !isInArea) {
            Notification notification = new Notification("someType", this, ++sequence,
                    System.currentTimeMillis(),
                    "Two fail hits happened");
            sendNotification(notification);
        }
        wasInArea = isInArea;
    }

    @Override
    public int getAllHits() {
        return allHits;
    }

    @Override
    public int getFailHits() {
        return failHits;
    }
}
