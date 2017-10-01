package modele;

import java.sql.Timestamp;

/**
 * Created by Pc on 21.09.2017.
 */
public class Car {
    private int carid;
    private int driverid;
    private String carName;
    private String modeleCar;
    private Timestamp timeArrival;
    private Timestamp timeDeparture;
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

    public Timestamp getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(Timestamp timeArrival) {
        this.timeArrival = timeArrival;
    }

    public Timestamp getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(Timestamp timeDeparture) {
        this.timeDeparture = timeDeparture;
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

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", driverid=" + driverid +
                ", carName='" + carName + '\'' +
                ", modeleCar='" + modeleCar + '\'' +
                ", timeArrival=" + timeArrival +
                ", timeDeparture=" + timeDeparture +
                ", payment=" + payment +
                ", numberParking='" + numberParking + '\'' +
                '}';
    }
}
