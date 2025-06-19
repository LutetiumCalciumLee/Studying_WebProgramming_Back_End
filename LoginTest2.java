package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {
    public void init() {
        System.out.println("init method called");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        System.out.println("ID: " + id);
        System.out.println("Password: " + pw);

        if (id != null && id.length() != 0) {
            if (id.equals("admin")) {
                out.print("<html><body>");
                out.print("<font size='12'>You have logged in as administrator!!</font><br>");
                out.print("<input type='button' value='Edit member info' />");
                out.print("<input type='button' value='Delete member info' />");
                out.print("</body></html>");
            } else {
                out.print("<html><body>");
                out.print(id + " has logged in.");
                out.print("</body></html>");
            }
        } else {
            out.print("<html><body>");
            out.print("Please enter your ID!!!<br>");
            out.print("<a href='http://localhost:8090/pro06/test01/login.html'>");
            out.print("Go to login window</a>");
            out.print("</body></html>");
        }
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}