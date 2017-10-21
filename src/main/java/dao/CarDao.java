package dao;

import model.Car;
import util.DButil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pc on 21.09.2017.
 */
public class CarDao {
    private static Connection connection;
    int cacheDriverId;

    public CarDao() {
        connection = DButil.getConnection();

    }

    public List<Car> getCarsByDriverId(int driverid) {
        if (driverid != 0) {
            cacheDriverId = driverid;
        }

        List<Car> cars = new ArrayList<Car>();
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM cars WHERE driverid = ?");
            pr.setInt(1, cacheDriverId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarName(rs.getString("car"));
                car.setModeleCar(rs.getString("modeleCar"));
                car.setTimeArrival(rs.getString("timeArrival"));
                car.setCarid(rs.getInt("carid"));
                car.setDriverid(rs.getInt("driverid"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void addCar(Car car) {
        try {
            PreparedStatement pr = connection
                    .prepareStatement("INSERT INTO cars (car, modelecar, timearrival,driverid )VALUES (?,?,?,?)");
            pr.setString(1, car.getCarName());
            pr.setString(2, car.getModeleCar());
            pr.setString(3, car.getTimeArrival());
            pr.setInt(4, cacheDriverId);
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        try {
            PreparedStatement pr = connection
                    .prepareStatement("UPDATE cars SET car=?,modelecar=?,timearrival=? WHERE carid=?");
            pr.setString(1, car.getCarName());
            pr.setString(2, car.getModeleCar());
            pr.setString(3, car.getTimeArrival());
            pr.setInt(4, car.getCarid());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCarId(int carid) {
        Car car = new Car();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cars WHERE carid=?");
            ps.setInt(1, carid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setCarid(rs.getInt("carid"));
                car.setDriverid(rs.getInt("driverid"));
                car.setCarName(rs.getString("carName"));
                car.setModeleCar(rs.getString("modeleCar"));
                car.setTimeArrival(rs.getString("timeArrival"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void deleteCar(int carid) {

        try {
            PreparedStatement pr = connection.prepareStatement("DELETE FROM cars WHERE carid = ?");
            pr.setInt(1, carid);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*public int calculatePrice(int cacheDriverId) {
        int b = Integer.parseInt("timeArrival");
        int a = Integer.parseInt("timeDeparture");
        int payment = (b - a) * 10;

        Car car = new Car();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT DISTINCT timeArrival,timeDeparture FROM cars WHERE driverid = ?");
            ps.setInt(1, cacheDriverId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setTimeArrival(rs.getTimestamp("timeArrival"));
                car.setTimeDeparture(rs.getTimestamp("timeDeparture"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }*/
}

