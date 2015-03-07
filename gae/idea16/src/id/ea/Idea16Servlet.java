package id.ea;

import id.ea.model.TripStepModel;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Idea16Servlet extends HttpServlet {

    public static final String DRIVE_HOST = "https://googledrive.com/host/0B-udBnWnmH6JfmJWNnBKQTh4dXJnRnJnWUpnVktvNUpMdUdyNjBPdzM4cjFIVFk1SG1wa3c/image-host/";
    private static final String PROXY = "/img?url=";

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

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TripStepModel ts = new TripStepModel(req.getParameter("name"), PROXY + URLEncoder.encode(req.getParameter("imageuri"), "UTF-8"), req.getParameter("sounduri"));

        ts.save();

        resp.sendRedirect("/");
    }
}
