/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package filter;

import entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is an implementation of <code>Filter</code> interface and has
 * function to check user's access permission.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
public class PermissionFilter implements Filter {

    /**
     * This method will be called after instantiating the filter. The init
     * method must complete successfully before the filter is asked to do any
     * filtering work.
     *
     * @param filterConfig is a filter configuration object used by a servlet
     * container to pass information to a filter during initialization.
     * @throws javax.servlet.ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * This method is called by the container each time a request/response pair
     * is passed through the chain due to a client request for a resource at the
     * end of the chain.
     *
     * @param request The servlet request we are processing. It is a
     * <code>javax.servlet.ServletRequest</code>
     * @param response The servlet response we are creating. It is a
     * <code>javax.servlet.FilterChain</code>
     * @param chain The filter chain we are processing. Filters use the
     * FilterChain to invoke the next filter in the chain. It is a
     * <code>javax.servlet.FilterChain</code>
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String url = req.getServletPath();

        if (user == null && (url.equals("/home") || url.equals("/takequiz")
                || url.equals("/makequiz") || url.equals("/managequiz"))) {
            res.sendRedirect("login");
        } else if (url.equals("/makequiz") || url.equals("/managequiz")) {
            if (user != null && user.getType() != 1) {
                res.sendRedirect("home");
            } else {
                chain.doFilter(request, response);
            }
        } else if (url.endsWith(".jsp")) {
            res.sendRedirect("home");
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * This method is only called once all threads within the filter's doFilter
     * method have exited or after a timeout period has passed.
     */
    @Override
    public void destroy() {
    }

}
