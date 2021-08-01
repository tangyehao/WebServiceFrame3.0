package cn.com.dao;

import cn.com.db.DBUtil;
import cn.com.pojo.EmpBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmpBeanDAO
 * @Description TODO
 * @Author lishan
 * @DATE 2021-08-01 15:53
 * @Version 1.0
 */
public class EmpBeanDAOImpl implements EmpBeanDAOInf{

    @Override
    public List<EmpBean> getAllEmpInfo(Connection conn, String sql) {
        List<EmpBean> list = new ArrayList<EmpBean>();
        EmpBean eb = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                eb = new EmpBean();
                eb.setEmpNo(rs.getInt("empno"));
                eb.seteName(rs.getString("ename"));
                eb.setJob(rs.getString("job"));
                eb.setMgr(rs.getInt("mgr"));
                eb.setHiredate(rs.getString("hiredate"));
                eb.setSal(rs.getFloat("sal"));
                eb.setSal(rs.getFloat("comm"));
                eb.setDeptNo(rs.getInt("deptno"));
                list.add(eb);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
