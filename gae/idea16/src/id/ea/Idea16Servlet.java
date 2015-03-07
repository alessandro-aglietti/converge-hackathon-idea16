package id.ea;

import id.ea.model.TripStepModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Idea16Servlet extends HttpServlet {
    
    public static final String DRIVE_HOST = "https://googledrive.com/host/0B-udBnWnmH6JfmJWNnBKQTh4dXJnRnJnWUpnVktvNUpMdUdyNjBPdzM4cjFIVFk1SG1wa3c/image-host/"; 
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<TripStepModel> tripSteps = TripStepModel.list();
        
//        tripSteps.add(new TripStepModel(1, "mystep", DRIVE_HOST + "PANO_20150207_152435.jpg", "https://soundcloud.com/aqquadro/why-dont-work-for-nsa"));

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
        
        TripStepModel ts = new TripStepModel(req.getParameter("name"), req.getParameter("imageuri"), req.getParameter("sounduri"));
        
        ts.save();

        resp.sendRedirect("/");
    }
}
