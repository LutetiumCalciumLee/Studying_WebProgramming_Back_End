package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiplicationTest")
public class MultiplicationTable extends HttpServlet {

    public void init() {
        System.out.println("init method called");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int multiplicationNumber = Integer.parseInt(request.getParameter("multiplicationNumber"));
        out.print("<table border=1 width=800 align=center>");
        out.print("<tr align=center bgcolor='#FFFF66'>");
        out.print("<td colspan=2>Multiplication Table for " + multiplicationNumber + "</td>");
        out.print("</tr>");

        for (int i = 1; i < 10; i++) {
            // 짝수 행과 홀수 행 배경색 번갈아 적용
            if (i % 2 == 0) {
                out.print("<tr align=center bgcolor='#ACFA58'>");
            } else {
                out.print("<tr align=center bgcolor='#81BEF7'>");
            }
            out.print("<td width=400>");
            out.print(multiplicationNumber + " × " + i);
            out.print("</td>");
            out.print("<td width=400>");
            out.print(i * multiplicationNumber);
            out.print("</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
