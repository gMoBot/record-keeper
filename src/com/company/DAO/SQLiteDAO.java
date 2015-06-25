package com.company.DAO;

import com.company.FarmProfileDao;
import com.company.Models.ApplicationProfile;
import com.company.Models.BlockProfile;
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
@Repository
public class SQLiteDAO implements FarmProfileDao {
//    SQLiteDAO sqLiteDAO;
//

    @Autowired
    private SessionFactory sessionFactoryBean;


    public List<FarmProfile> getFarmProfile() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(FarmProfile.class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void saveFarmProfile(FarmProfile farmProfile){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().saveOrUpdate(farmProfile);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<FarmProfile> getSelectedFarmProfile(String selectedFarmName) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(FarmProfile.class);
        criteria.add(Restrictions.eq("farmName", selectedFarmName));
        criteria.setMaxResults(1);
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public List<BlockProfile> getBlockProfile() {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(BlockProfile.class);
        criteria.add(Restrictions.isNotNull("id"));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public List<BlockProfile> getFarmBlockProfiles(String selectedFarmId) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(BlockProfile.class);
        criteria.add(Restrictions.eq("farmId", selectedFarmId));
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

    public void saveBlockProfile(BlockProfile blockProfile) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        sessionFactoryBean.getCurrentSession().saveOrUpdate(blockProfile);
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
    }

    public List<ApplicationProfile> getOverviewApplicationProfiles(String selectedFarmId){
        sessionFactoryBean.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactoryBean.getCurrentSession().createCriteria(ApplicationProfile.class);
        criteria.add(Restrictions.eq("farmId", selectedFarmId));
        criteria.setMaxResults(10);
        List list = criteria.list();
        sessionFactoryBean.getCurrentSession().getTransaction().commit();
        return list;
    }

}
