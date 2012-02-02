package net.therap.lab.listeners;

/**
 * @author jahangir
 * @since 1/31/12 1:52 PM
 */

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.io.IOException;
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

        ServletContext servletContext = sce.getServletContext();
        Map<String, ? extends ServletRegistration> servletRegistrationMap = servletContext.getServletRegistrations();

        System.out.println("Registered Servlets");
        for (String servletName : servletRegistrationMap.keySet()) {
            ServletRegistration sr = servletRegistrationMap.get(servletName);
            System.out.println(servletName + " : " + sr.getClassName());
        }

        System.out.println("Registered Filters");
        Map<String, ? extends FilterRegistration> filterRegistrations = servletContext.getFilterRegistrations();
        for (String filterName : filterRegistrations.keySet()) {
            FilterRegistration fr = filterRegistrations.get(filterName);
            System.out.println(filterName + " : " + fr.getClassName());
        }

        ServletRegistration.Dynamic dynamicServlet = servletContext.addServlet("DynamicServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.getWriter().println("Hello. This is from dynamic Servlet!");
            }
        });

        dynamicServlet.addMapping("/dynamic");

//        FilterRegistration.Dynamic dynamicFilter = servletContext.addFilter("DynamicFilter", new Filter() {
//            @Override
//            public void init(FilterConfig filterConfig) throws ServletException {
//            }
//
//            @Override
//            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//                    throws IOException, ServletException {
//                System.out.println("Dynamic filter start");
//                chain.doFilter(request, response);
//                System.out.println("Dynamic filter end");
//            }
//
//            @Override
//            public void destroy() {
//            }
//        });
//
//        dynamicFilter.addMappingForServletNames(null, true, "DynamicServlet");

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
