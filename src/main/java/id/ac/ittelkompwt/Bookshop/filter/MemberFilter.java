package id.ac.ittelkompwt.Bookshop.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MemberFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String key = req.getHeader("ROLE");
        if(key ==  null) {
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write("Role haven't filled!".getBytes());
            return;
        } if(!(key == "ADMIN")) {
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write("You can't acces this".getBytes());
            return;
        }

        chain.doFilter(request, response);
    }
}
