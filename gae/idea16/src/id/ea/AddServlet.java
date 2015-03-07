package id.ea;

import id.ea.model.TripStepModel;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

    private static final String PROXY = "/img?url=";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TripStepModel ts = new TripStepModel(req.getParameter("name"), PROXY + URLEncoder.encode(req.getParameter("imageuri"), "UTF-8"), req.getParameter("sounduri"));

        ts.save();

        resp.sendRedirect("/");
    }
}
