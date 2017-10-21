package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Pc on 21.10.2017.
 */
public class PriceParking {
    long currentTime = System.currentTimeMillis();
    String time = new SimpleDateFormat("HH.mm").format(new Date(currentTime));

    public long getCurTime() {
        return currentTime;
    }

    public void setCurTime(long curTime) {
        this.currentTime = curTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
