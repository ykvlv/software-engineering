package ykvlv.lab3.dao;

import ykvlv.lab3.bean.ResponseBean;
import ykvlv.lab3.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResponseDao {
    public void save(ResponseBean bean) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(bean);
        tx1.commit();
        session.close();
    }

    public List<ResponseBean> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<ResponseBean> list = session.createQuery("FROM ResponseBean ", ResponseBean.class).list();
        tx1.commit();
        session.close();
        return list;
    }

    public void delete() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("DELETE FROM ResponseBean").executeUpdate();
        tx1.commit();
        session.close();
    }
}
