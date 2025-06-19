package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    private static final float USD_RATE = 1400.0f;
    private static final float JPY_RATE = 9.5f;
    private static final float CNY_RATE = 180.0f;
    private static final float GBP_RATE = 1700.0f;
    private static final float EUR_RATE = 1400.0f;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        if (command != null && command.equals("calculate")) {
            String result = calculate(Float.parseFloat(won), operator);
            pw.print("<html><font size=10>Conversion Result</font><br>");
            pw.print("<font size=10>" + result + "</font><br>");
            pw.print("<a href='/pro06/calc'>Currency Converter</a>");
            pw.print("</html>");
            return;
        }

        pw.print("<html><title>Currency Converter</title>");
        pw.print("<font size=5>Currency Converter</font><br>");
        pw.print("<form name='frmCalc' method='get' action='/pro06/calc'>");
        pw.print("Amount(WON): <input type='text' name='won' size=10 />");
        pw.print("<select name='operator'>");
        pw.print("<option value='dollar'>Dollar</option>");
        pw.print("<option value='en'>Yen</option>");
        pw.print("<option value='wian'>Yuan</option>");
        pw.print("<option value='pound'>Pound</option>");
        pw.print("<option value='euro'>Euro</option>");
        pw.print("</select>");
        pw.print("<input type='hidden' name='command' value='calculate' />");
        pw.print("<input type='submit' value='Convert' />");
        pw.print("</form>");
        pw.print("</html>");
        pw.close();
    }

    private static String calculate(float won, String operator) {
        String result = null;
        if (operator.equals("dollar")) {
            result = String.format("%.6f", won / USD_RATE);
        } else if (operator.equals("en")) {
            result = String.format("%.6f", won / JPY_RATE);
        } else if (operator.equals("wian")) {
            result = String.format("%.6f", won / CNY_RATE);
        } else if (operator.equals("pound")) {
            result = String.format("%.6f", won / GBP_RATE);
        } else if (operator.equals("euro")) {
            result = String.format("%.6f", won / EUR_RATE);
        }
        return result;
    }
}