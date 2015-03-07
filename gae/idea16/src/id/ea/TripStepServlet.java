package id.ea;

import id.ea.model.TripStepModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class TripStepServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Gson gson = new Gson();

        TripStepModel ts;
        try {
            ts = TripStepModel.get(Long.valueOf(req.getParameter("id")));
        } catch (NumberFormatException e) {
            resp.setContentType("text/plain");
            resp.getWriter().println("NumberFormatException: " + e.getMessage());

            e.printStackTrace();
            return;
        } catch (EntityNotFoundException e) {
            resp.setContentType("text/plain");
            resp.getWriter().println("EntityNotFoundException: " + e.getMessage());

            e.printStackTrace();
            return;
        }

        req.setAttribute("tsjson", gson.toJson(ts));
        req.setAttribute("ts", ts);

        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/tripstep.jsp");

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
