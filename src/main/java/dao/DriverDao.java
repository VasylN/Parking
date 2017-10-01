package dao;

import modele.Driver;
import util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pc on 21.09.2017.
 */
public class DriverDao {
    private static Connection connection;
    private CarDao carDao;

    public DriverDao() {
        this.carDao = new CarDao();
        connection = DButil.getConnection();
    }

    public void addDriver(Driver driver) {
        try {
            PreparedStatement pr = connection
                    .prepareStatement("INSERT INTO userscars (firstname, lastname, tel) VALUES (?,?,?)");
            pr.setString(1, driver.getFirstName());
            pr.setString(2, driver.getLastName());
            pr.setString(3, driver.getTel());
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDriver(int driverid) {
        carDao.deleteCar(driverid);
        try {
            PreparedStatement pr = connection.prepareStatement("DELETE FROM userscars WHERE driverid = ?");
            pr.setInt(1, driverid);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Driver> getAllDrivers() {
        List<Driver> userscars = new ArrayList<Driver>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userscars");
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setDriverid(resultSet.getInt("driverid"));
                driver.setFirstName(resultSet.getString("firstname"));
                driver.setLastName(resultSet.getString("lastname"));
                driver.setTel(resultSet.getString("tel"));
                userscars.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userscars;
    }

    public void updateDriver(Driver driver) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE userscars SET firstname = ?, lastname = ?,tel = ? WHERE driverid = ?");
            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setString(3, driver.getTel());
            preparedStatement.setInt(4, driver.getDriverid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver getDriverById(int driverid) {
        Driver driver = new Driver();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM userscars WHERE driverid = ?");
            ps.setInt(1, driverid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                driver.setDriverid(rs.getInt("driverid"));
                driver.setFirstName(rs.getString("firstname"));
                driver.setLastName(rs.getString("lastname"));
                driver.setTel(rs.getString("tel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }


}

