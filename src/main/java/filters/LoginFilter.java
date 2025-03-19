package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            chain.doFilter(request, response);
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("Invalid credentials");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginStudent.html");
            dispatcher.include(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}