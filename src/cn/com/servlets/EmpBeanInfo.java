package cn.com.servlets;

import cn.com.pojo.EmpBean;
import cn.com.service.EmpBeanServiceImpl;
import cn.com.service.EmpBeanServiceInf;
import cn.com.servlet.ServletException;
import cn.com.servlet.http.HttpServlet;
import cn.com.servlet.http.HttpServletRequest;
import cn.com.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName EmpBeanInfo
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 16:07
 * @Version 1.0
 */
public class EmpBeanInfo extends HttpServlet {

    private EmpBeanServiceInf service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service = new EmpBeanServiceImpl();
        List<EmpBean> list = service.getAllEmpInfo();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>EmpInfo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>emp info</h1>");
        out.println("<table border= '1' cellSpacing = '0' cellPadding = '0'");
        out.println("<tr>");
        out.println("<th>empno</th>");
        out.println("<th>ename</th>");
        out.println("<th>job</th>");
        out.println("<th>mgr</th>");
        out.println("<th>hiredate</th>");
        out.println("<th>sal</th>");
        out.println("<th>comm</th>");
        out.println("<th>deptno</th>");
        out.println("</tr>");
        for (EmpBean e : list){
            out.println( "<tr>");
            out.println( "<td>"+e.getEmpNo());
            out.println( "<td>"+e.geteName());
            out.println( "<td>"+e.getJob());
            out.println( "<td>"+e.getMgr());
            out.println( "<td>"+e.getHiredate());
            out.println( "<td>"+e.getSal());
            out.println( "<td>"+e.getComm());
            out.println( "<td>"+e.getDeptNo());
            out.println( "</tr>");
        }
        out.println( "</table>" );
        out.println( "</body>" );
        out.println( "</html>");


    }
}
