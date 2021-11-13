/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.LivreDAO;
import Model.Livre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author YOUSSEF
 */
public class LivreServices implements IServices<Livre> {
    @Autowired
    LivreDAO dao;

    public LivreDAO getDao() {
        return dao;
    }

    public void setDao(LivreDAO dao) {
        this.dao = dao;
    }

    public int insert(Livre C) {
        dao.insert(C);
        return 0;
    }

    public int update(Livre C) {
        dao.update(C);
        return 0;
    }

    public int delete(Livre C) {
        dao.delete(C);
        return 0;
    }

    public List<Livre> Select() {
        List<Livre> LivreList = dao.Select();
        return LivreList;
    }

    public Livre getone(Livre C) {
        return dao.getone(C);
    }

}
