/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.UserDAO;
import Model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;




public class UserServices {
    
    @Autowired
    UserDAO daoo;

    public UserServices() {
        this.daoo=new UserDAO();
    }

    
    public UserDAO getDao() {
        return daoo;
    }

    public void setDao(UserDAO daoo) {
        this.daoo = daoo;
    }

    public int insert(User C) {
        daoo.insert(C);
        return 0;
    }
    public User Login(User C) {
        return daoo.Login(C);
    }
    
    public List<User> getone(User C) {
        return daoo.getone(C);
    }
    
}
