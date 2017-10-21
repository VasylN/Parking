package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Pc on 21.09.2017.
 */
public class Car {
    private int carid;
    private int driverid;
    private String carName;
    private String modeleCar;
    private long currentTime = System.currentTimeMillis();
    String timeArrival = new SimpleDateFormat("HH.mm").format(new Date(currentTime));
    private int payment;
    private String numberParking;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModeleCar() {
        return modeleCar;
    }

    public void setModeleCar(String modeleCar) {
        this.modeleCar = modeleCar;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getNumberParking() {
        return numberParking;
    }

    public void setNumberParking(String numberParking) {
        this.numberParking = numberParking;
    }
}
