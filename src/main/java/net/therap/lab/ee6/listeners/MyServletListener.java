package net.therap.lab.ee6.listeners;

/**
 * @author jahangir
 * @since 1/31/12 1:52 PM
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Map;

@WebListener()
public class MyServletListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public MyServletListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, ? extends ServletRegistration> servletRegistrationMap = sce.getServletContext().getServletRegistrations();
        for (String servletName : servletRegistrationMap.keySet()) {
            System.out.println(servletName);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is invoked when the Servlet Context 
           (the Web application) is undeployed or 
           Application Server shuts down.
        */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute 
           is added to a session.
        */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute
           is removed from a session.
        */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is invoked when an attribute
           is replaced in a session.
        */
    }
}
