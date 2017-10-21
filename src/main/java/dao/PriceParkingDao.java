package dao;

import model.Car;
import sun.nio.cs.ext.MacUkraine;
import util.DButil;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Pc on 21.10.2017.
 */
public class PriceParkingDao {
    private static Connection connection;
    private CarDao carDao;

    public PriceParkingDao() {
      this.carDao = new CarDao();
        connection = DButil.getConnection();
    }
    public int calculatePrice(int cacheDriverId) {
        int b = Integer.parseInt("timeArrival");
        int a = Integer.parseInt("timeDeparture");
        int payment = (b - a) * 10;

        Car car = new Car();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT DISTINCT timearrival FROM cars WHERE driverid = ?");
            ps.setInt(1, cacheDriverId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setTimeArrival(rs.getString("timeArrival"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }



}
