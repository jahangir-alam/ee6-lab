package net.therap.lab.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jahangir
 * @since 2/1/12 11:55 AM
 */
@WebServlet(name = "SimpleAsyncServlet", urlPatterns = "/asyncServlet", asyncSupported = true)
public class SimpleAsyncServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(1000);
        asyncContext.dispatch("/home.jsp");
    }
}
