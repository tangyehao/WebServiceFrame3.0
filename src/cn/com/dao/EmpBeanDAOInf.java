package cn.com.dao;

import cn.com.pojo.EmpBean;

import java.sql.Connection;
import java.util.List;

public interface EmpBeanDAOInf {
    List<EmpBean> getAllEmpInfo(Connection conn,String sql);
}
