/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Saadat
 */
public class jSoupWithDescoStOverflow {
    public static void main(String[] args) throws Exception {
        
        String urlIndex = "http://usis.bracu.ac.bd/academia/"; // index
        String pass = "87jTXnWZ"; 
        String UserId = "s.saadathussain.95@gmail.com";
        String StudentProfile = "http://usis.bracu.ac.bd/academia/academia/student/showProfile";
//        String url = "http://usis.bracu.ac.bd/academia/j_spring_security_check"; // formURL= /academia/j_spring_security_check /academia/j_spring_security_check
        String urlLoginAction = "http://usis.bracu.ac.bd/academia/j_spring_security_check";
        String routineURL = "http://usis.bracu.ac.bd/academia/studentCourse/showCourseStatusByStudent";
        
        
        Connection.Response loginForm = Jsoup.connect(urlIndex) //"https://www.desco.org.bd/ebill/login.php"
                .method(Connection.Method.GET)
                .execute();

        Document document = Jsoup.connect(urlLoginAction) // Logs in
                .data("j_username", "s.saadathussain.95@gmail.com")
                .data("j_password", "87jTXnWZ")
                .cookies(loginForm.cookies())
                .post();
//        System.out.println(document.select("a[href]")); // prints out the links
//        System.out.println(document); //JSESSIONID    // prints out the index page after logging in

        Map cookieS = loginForm.cookies(); // Cookies stored in this String
        System.out.println(loginForm.cookies());
        System.out.println(cookieS.get("JSESSIONID"));
        document = Jsoup.connect("http://usis.bracu.ac.bd/academia/academicSection/listAcademicSectionWithSchedule?query=cse310&academiaSession=627107&_search=false&nd=1553452671624&rows=20&page=1&sidx=course_code&sord=asc")
                .cookies(cookieS)
                .get();
        System.out.println("document");
        System.out.println("documentz: "+document);
        
        
        Document document2 = Jsoup.connect(routineURL) 
                .data("j_username", "s.saadathussain.95@gmail.com")
                .data("j_password", "87jTXnWZ")
                .cookies(cookieS)
                .post();
        System.out.println(document2);

        Connection.Response res = Jsoup.connect(urlLoginAction)
        .data("j_username", "s.saadathussain.95@gmail.com", "j_password", "87jTXnWZ")
        .method(Connection.Method.POST)
        .execute();

        Document doc = res.parse();
        String sessionId = res.cookie("JSESSIONID");
        System.out.println("second way: " + sessionId);
        
//        Document doc2 = Jsoup.connect(StudentProfile)
//        .cookie("JSESSIONID", sessionId)
//        .get();
//        System.out.print(doc2);
    }

}
