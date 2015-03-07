package id.ea;

import id.ea.model.TripStepModel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Idea16Servlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<TripStepModel> tripSteps = TripStepModel.list();

        req.setAttribute("tss", tripSteps);

        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/index.jsp");

        try {
            view.forward(req, resp);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            resp.setContentType("text/plain");
            resp.getWriter().println("ServletException: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
