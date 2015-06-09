package com.company.DAO;

import com.company.FarmProfileDao;
import com.company.Models.FarmProfile;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 6/9/15.
 */

@Repository
public class SQLiteJDBCDAO implements FarmProfileDao {
    @Autowired
    private SessionFactory sessionFactoryBean;


    public List<FarmProfile> getFarmProfile() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(FarmProfile.class);
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }


}
