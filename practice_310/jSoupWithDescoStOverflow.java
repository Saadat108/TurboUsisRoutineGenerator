/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author Saadat
 */
public class jSoupWithDescoStOverflow {
    public static void main(String[] args) throws Exception {
        
        String urlIndex = "http://usis.bracu.ac.bd/academia/"; // index
        String pass = "87jTXnWZ"; 
        String UserId = "s.saadathussain.95@gmail.com";
//        String url = "http://usis.bracu.ac.bd/academia/j_spring_security_check"; // formURL= /academia/j_spring_security_check /academia/j_spring_security_check
        String urlLoginAction = "http://usis.bracu.ac.bd/academia/j_spring_security_check";
        String routineURL = "http://usis.bracu.ac.bd/academia/studentCourse/showCourseStatusByStudent";
        
        
        Connection.Response loginForm = Jsoup.connect(urlIndex) //"https://www.desco.org.bd/ebill/login.php"
                .method(Connection.Method.GET)
                .execute();

        Document document = Jsoup.connect(urlLoginAction) //"https://www.desco.org.bd/ebill/authentication.php"
                .data("j_username", "s.saadathussain.95@gmail.com")
                .data("j_password", "87jTXnWZ")
                .cookies(loginForm.cookies())
                .post();
//        System.out.println(document);
        System.out.println(document.body());

    }

}
