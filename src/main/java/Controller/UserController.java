/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Livre;
import Model.User;
import Services.LivreServices;
import Services.UserServices;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class UserController {

    @Autowired
    UserServices srcc;
    private static final String UPLOAD_DIRECTORY = "/Files";

    public UserServices getSrc() {
        return srcc;
    }

    public void setSrc(UserServices srcc) {
        this.srcc = srcc;
    }
    @Autowired
    LivreServices src;

    public void setSrc(LivreServices src) {
        this.src = src;
    }

    @RequestMapping("/index.htm")
    public String index() {
        return "index";
    }

    @RequestMapping("/registration.htm")
    public String Form() {
        return "registration";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ModelAttribute
    public ModelAndView Save(User c, HttpServletRequest request,
            @RequestParam CommonsMultipartFile fileUpload, HttpSession session) {
        try {
            ServletContext context = session.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);
            String filename = fileUpload.getOriginalFilename();

            byte[] bytes = fileUpload.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(path + "/" + filename)));
            stream.write(bytes);
            stream.flush();
            stream.close();
            User cc = new User();
            cc.setEmail(c.getEmail());
            cc.setNom(c.getNom());
            cc.setPassword(c.getPassword());
            cc.setPrenom(c.getPrenom());
            cc.setImage(filename);
            srcc.insert(cc);

            ModelAndView mav = new ModelAndView();

        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/index.htm");

    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ModelAttribute
    public ModelAndView Save(User c) {
        User cc = new User(c.getEmail(), c.getPassword());
        User list = srcc.Login(cc);
        ModelAndView mav = new ModelAndView();
        if (list == null) {
            return new ModelAndView("redirect:/index.htm");
        } else {
            System.out.println("bonjour youssef" + list);

            List<Livre> mylist = src.Select();
            mav.addObject("listt", mylist);
            mav.addObject("userlist", list);
            mav.setViewName("redirect:/home.htm");
            return mav;
        }
    }

    @RequestMapping(value = "/download.htm", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
        ServletContext context = session.getServletContext();
        String path = context.getRealPath(UPLOAD_DIRECTORY);
        String name = request.getParameter("name");
        String redirectUrl = path + "\\" + name;
        File file = null;

        file = new File(redirectUrl);
        System.out.println("hello from download     " + file);
        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }

}
