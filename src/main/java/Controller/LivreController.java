/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Livre;
import Services.LivreServices;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author YOUSSEF
 */
@Controller
public class LivreController {

    @Autowired
    LivreServices src;

    public LivreServices getSrc() {
        return src;
    }

    public void setSrc(LivreServices src) {
        this.src = src;
    }

    @RequestMapping("/home.htm")
    public ModelAndView Listar(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        List<Livre> mylist = src.Select();
        mav.addObject("listt", mylist);
        mav.setViewName("Home");
        return mav;
    }

    @RequestMapping("/Ajouter.htm")
    public String Form() {

        return "Ajouter";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ModelAttribute
    public ModelAndView Save(Livre c){
            src.insert(c);
            ModelAndView mav = new ModelAndView();
        return new ModelAndView("redirect:/home.htm");
    }



    @RequestMapping(value = "/Delete")
    public ModelAndView delete(HttpServletRequest request) {
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        Livre c = new Livre(id);
        src.delete(c);
        return new ModelAndView("redirect:/home.htm");
    }

    @RequestMapping(value = "Update.htm", method = RequestMethod.GET)
    public ModelAndView Formedit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        Livre c = new Livre(id);
        Livre mycontact = src.getone(c);
        mav.addObject("listt", mycontact);
        mav.setViewName("Update");
        return mav;
    }

    @RequestMapping(value = "/editt", method = RequestMethod.POST)
    public ModelAndView Formedit(Livre c){
            src.update(c);
        ModelAndView mav = new ModelAndView();
        return new ModelAndView("redirect:/home.htm");
    }

    @RequestMapping(value = "deleteall.htm", method = RequestMethod.POST)
    public ModelAndView deleteall(HttpServletRequest request) {
        int id;
        for (String idd : request.getParameterValues("box")) {
            id = Integer.parseInt(idd);
            Livre c = new Livre(id);
            src.delete(c);
        }
        return new ModelAndView("redirect:/home.htm");
    }

}
