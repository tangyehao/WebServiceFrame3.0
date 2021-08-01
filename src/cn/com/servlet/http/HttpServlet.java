package cn.com.servlet.http;

import cn.com.servlet.ServletException;

import java.io.IOException;

/**
 * @ClassName HttpServlet
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 14:59
 * @Version 1.0
 */
public abstract class HttpServlet {
    protected void init(){

    }
    protected void service(HttpServletRequest request, HttpServletResponse response){
        if(request.getMethod().equalsIgnoreCase("get")){
            try {
                doGet(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(request.getMethod().equalsIgnoreCase("post")){
            doPost(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void destroy(){

    }

}
