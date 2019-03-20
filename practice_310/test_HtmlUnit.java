/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
//import com.gargoylesoftware.htmlunit.html.*;

/**
 *
 * @author Saadat
 */
public class test_HtmlUnit {
    public static void main(String[] args) {
        String baseUrl = "https://news.ycombinator.com/";
        String usisIndexUrl = "http://usis.bracu.ac.bd/academia/";
        String password = "87jTXnWZ"; 
        String UserId = "s.saadathussain.95@gmail.com";
        
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        
        try {
            HtmlPage page = client.getPage(usisIndexUrl);
//            System.out.println(page.asXml());
//            System.out.println(page.asText());
            
            HtmlForm form = page.getHtmlElementById("loginForm");
            form.getInputByName("j_username").setValueAttribute(UserId);
            HtmlInput passwordInput = form.getInputByName("j_password");
            passwordInput.setValueAttribute(password);
//            System.out.println(page.asText()); // to test whether name ans password have been entered
            page = page.getHtmlElementById("ctl00_leftColumn_ctl00_btnLogin").click(); // clicks on submit button
            // goes to find class timing
            
            HtmlAnchor htmlAnchor = page.getAnchorByHref("#/academia/academicSection/showSectionForStudent"); 
            HtmlPage page3 = htmlAnchor.click();
            page3 = htmlAnchor.click();
            
            System.out.println(page3.asText());
//            System.out.println(page.asXml());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        
}
}
