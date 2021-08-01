package cn.com.servlets;

import cn.com.servlet.ServletException;
import cn.com.servlet.http.HttpServlet;
import cn.com.servlet.http.HttpServletRequest;
import cn.com.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName HelloServlet
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 15:31
 * @Version 1.0
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Hello</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Hello</h1>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
