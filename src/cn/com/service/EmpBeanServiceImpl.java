package cn.com.service;

import cn.com.dao.EmpBeanDAOImpl;
import cn.com.dao.EmpBeanDAOInf;
import cn.com.db.DBUtil;
import cn.com.pojo.EmpBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmpBeanServiceImpl
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 16:03
 * @Version 1.0
 */
public class EmpBeanServiceImpl implements EmpBeanServiceInf{
    private EmpBeanDAOInf dao;
    public EmpBeanServiceImpl(){
        dao = new EmpBeanDAOImpl();
    }
    @Override
    public List<EmpBean> getAllEmpInfo() {
            Connection conn = null;
            List<EmpBean> list = null;
            String sql = "select * from emp";
            try {
                conn = DBUtil.getConn();
                conn.setAutoCommit(false);
                list = dao.getAllEmpInfo(conn,sql);
                conn.commit();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } finally {
                try {
                    DBUtil.freeConnection(conn);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return list;
        }
    }
