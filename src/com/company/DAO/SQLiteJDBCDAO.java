package com.company.DAO;

import com.company.FarmProfileDao;
import com.company.Models.FarmProfile;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by garrettcoggon on 6/9/15.
 */

//@Transactional
//@Component
@Repository
public class SQLiteJDBCDAO implements FarmProfileDao {

    public SQLiteJDBCDAO(){}

    @Autowired
    private SessionFactory sessionFactoryBean;


    public List<FarmProfile> getFarmProfile() {
//        List list = Collections.emptyList();
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(FarmProfile.class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
//        if (list.isEmpty()){
//            return Collections.EMPTY_LIST;
//        }
        return list;
    }

    public void saveFarmProfile(FarmProfile farmProfile){
        sessionFactoryBean.getCurrentSession().beginTransaction();
//        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(FarmProfile.class);
        sessionFactoryBean.getCurrentSession().saveOrUpdate(farmProfile);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }
}
