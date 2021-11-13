/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Livre;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author YOUSSEF
 */
public class LivreDAO implements IDAO<Livre> {

    public LivreDAO() {

    }

    public int insert(Livre M) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.persist(M);
        tx.commit();
        return 0;
    }

    public int update(Livre M) {
        Session s3 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s3.beginTransaction();
        s3.update(M);
        tx.commit();
        return 0;
    }

    public int delete(Livre M) {
        Session s2 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s2.beginTransaction();
        int id = M.getId();
        Livre p1 = (Livre) s2.load(Livre.class, new Integer(id));
        if (p1 != null) {
            s2.delete(p1);
        }
        tx.commit();
        return 0;
    }

    public Livre getone(Livre M) {
        Session s5 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s5.beginTransaction();
        int id = M.getId();
        Livre p1 = (Livre) s5.get(Livre.class, new Integer(id));
        tx.commit();
        return p1;
    }

    public List<Livre> Select() {
        Session s1 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s1.beginTransaction();
        List<Livre> LivreList = s1.createQuery("from Livre").list();
        tx.commit();
        return LivreList;
    }

 

}
