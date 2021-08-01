package cn.com.servlet;

/**
 * @ClassName ServletException
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 15:26
 * @Version 1.0
 */
public class ServletException extends Throwable{
    public ServletException(){

    }
    public ServletException(String msg){
        super(msg);
    }

}
