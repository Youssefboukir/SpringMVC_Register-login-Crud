package DAO;

import Model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author YOUSSEF
 */
public class UserDAO {

    public UserDAO() {
    }

    public int insert(User M) {
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.persist(M);
        tx.commit();
        return 0;
    }

    public User Login(User M) {
        Session s36 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction txx = s36.beginTransaction();
        String emai = M.getEmail();
        String pwd = M.getPassword();
        Criteria cr = s36.createCriteria(User.class);
        Criterion email = Restrictions.like("email", emai);
        Criterion password = Restrictions.like("password", pwd);
        LogicalExpression andExp = Restrictions.and(email, password);
        cr.add(andExp);
        List<User> results = cr.list();
        User usr = null;
        for (User cc:results ){
             usr=new User(cc.getNom(),cc.getPrenom(),cc.getEmail(),cc.getPassword(),cc.getImage());
        }
        txx.commit();

        return usr;
    }

    public List<User> getone(User M) {
        Session s5 = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s5.beginTransaction();
        String email = M.getEmail();
        List<User> p1 = (List<User>) s5.get(User.class, email);
        tx.commit();
        return p1;
    }

}
