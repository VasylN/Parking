package controller;

import dao.CarDao;
import modele.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pc on 21.09.2017.
 */
public class CarController extends HttpServlet {
    private CarDao dao;
    private static int PRICE = 10;
    private static String LIST_CAR = "/listCar.jsp";
    private static String UPDATE_CAR = "/updateCar.jsp";
    private static String CalculatePrice = "/calculatePrice";

    public CarController() {
        this.dao = new CarDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("review")) {
            forward = LIST_CAR;
            int driverid = Integer.parseInt(req.getParameter("driverid"));
            req.setAttribute("cars", dao.getCarsByDriverId(driverid));
        } else if (action.equalsIgnoreCase("delete")) {
            int carid = Integer.parseInt(req.getParameter("carid"));
            int driverid = Integer.parseInt(req.getParameter("driverid"));
            dao.deleteCar(carid);
            forward = LIST_CAR;
            req.setAttribute("cars", dao.getCarsByDriverId(driverid));
        } else if (action.equalsIgnoreCase("edit")) {
            forward = UPDATE_CAR;
            int carid = Integer.parseInt(req.getParameter("carid"));
            Car car = dao.getCarId(carid);
            req.setAttribute("car", car);
        } else if (action.equalsIgnoreCase("listCar")) {
            forward = LIST_CAR;
            int driverid = Integer.parseInt(req.getParameter("driverid"));
            req.setAttribute("cars", dao.getCarsByDriverId(driverid));
        } else if (action.equalsIgnoreCase("calculate")) {
            forward = CalculatePrice;
            int payment = Integer.parseInt(req.getParameter("payment"));
            /*int driverid = Integer.parseInt(req.getParameter("driverid"));
            int timeArrival = Integer.parseInt(req.getParameter("timeArrival"));
            int timeDeparture = Integer.parseInt(req.getParameter("timeDeparture"));
            int payment = (timeDeparture - timeArrival) * PRICE;*/
            req.setAttribute("payment", dao.calculatePrice(payment));
        } else {
            forward = UPDATE_CAR;
        }

        RequestDispatcher rd = req.getRequestDispatcher(forward);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        car.setCarName(req.getParameter("carName"));
        car.setModeleCar(req.getParameter("modeleCar"));
        car.setTimeArrival(req.getParameter);
        car.setTimeDeparture(req.getParameter("timeDeparture"));
        String carid = req.getParameter("carid");
        if (carid == null || carid.isEmpty()) {
            dao.addCar(car);
        } else {
            car.setCarid(Integer.parseInt(carid));
            dao.updateCar(car);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(LIST_CAR);
        req.setAttribute("cars", dao.getCarsByDriverId(0));
        requestDispatcher.forward(req, resp);
    }
}

