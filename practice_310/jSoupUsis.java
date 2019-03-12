/*
 * this works only :p
 */
package practice_310;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



/**
 *
 * @author User
 */
public class jSoupUsis {
     public static void main(String[] args) throws Exception {
        String urlIndex = "http://usis.bracu.ac.bd/academia/";
        String pass = "87jTXnWZ";
//        String url = "http://usis.bracu.ac.bd/academia/j_spring_security_check"; // formURL= /academia/j_spring_security_check /academia/j_spring_security_check
        String url = "http://usis.bracu.ac.bd/academia/j_spring_security_check";
        String routineURL = "http://usis.bracu.ac.bd/academia/studentCourse/showCourseStatusByStudent";
        

           Connection.Response loginForm = Jsoup.connect(urlIndex) //"https://www.desco.org.bd/ebill/login.php"
            .method(Connection.Method.GET)
            .execute();

           Document document = Jsoup.connect(url) //"https://www.desco.org.bd/ebill/authentication.php"
            .data("j_username", "s.saadathussain.95@gmail.com")
            .data("j_password", "87jTXnWZ")
            
            .cookies(loginForm.cookies())
            .post();
           System.out.println(document);
           
//           Document document2 = Jsoup.connect(url)
//                   .cookies(loginForm.cookies())
//                   .post();
//           System.out.println(document2);
       }
}
