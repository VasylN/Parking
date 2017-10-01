package controller;

import dao.DriverDao;
import modele.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pc on 21.09.2017.
 */
public class DriverController extends HttpServlet {
    private DriverDao dao;
    private static String INSERT_OR_EDIT = "/updateDriver.jsp";
    private static String LIST_DRIVER = "/listDriver.jsp";

    public DriverController() {
        this.dao = new DriverDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            int driverid = Integer.parseInt(req.getParameter("driverid"));
            dao.deleteDriver(driverid);
            forward = LIST_DRIVER;
            req.setAttribute("userscars", dao.getAllDrivers());
        } else if (action.equalsIgnoreCase("listDriver")) {
            forward = LIST_DRIVER;
            req.setAttribute("userscars", dao.getAllDrivers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int driverid = Integer.parseInt(req.getParameter("driverid"));
            Driver driver = dao.getDriverById(driverid);
            req.setAttribute("driver", driver);
            req.setAttribute("driverid", driverid);
        } else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher rd = req.getRequestDispatcher(forward);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Driver driver = new Driver();
        driver.setFirstName(req.getParameter("firstName"));
        driver.setLastName(req.getParameter("lastName"));
        driver.setTel(req.getParameter("tel"));
        String driverid = req.getParameter("driverid");
        if (driverid == null || driverid.isEmpty()) {
            dao.addDriver(driver);
        } else {
            driver.setDriverid(Integer.parseInt(driverid));
            dao.updateDriver(driver);
        }
        RequestDispatcher rd = req.getRequestDispatcher(LIST_DRIVER);
        req.setAttribute("userscars", dao.getAllDrivers());
        rd.forward(req, resp);
    }
}