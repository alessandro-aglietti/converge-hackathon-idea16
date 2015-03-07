package id.ea;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@SuppressWarnings("serial")
public class ImageProxyServlet extends HttpServlet {
    public static final String CACHE_CONTROL = "cache-control";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URL url = new URL(req.getParameter("url"));

        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(550000);

        HTTPRequest httpreq = new HTTPRequest(url, HTTPMethod.GET, FetchOptions.Builder.followRedirects().setDeadline((double) 60000));

        OutputStream os = resp.getOutputStream();

        IOUtils.copy(new ByteArrayInputStream(URLFetchServiceFactory.getURLFetchService().fetch(httpreq).getContent()), os);

        IOUtils.closeQuietly(os);
    }
}
