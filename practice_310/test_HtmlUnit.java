/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.*;

/**
 *
 * @author Saadat
 */
public class test_HtmlUnit {
    public static void main(String[] args) {
        String baseUrl = "https://news.ycombinator.com/";
        // http://usis.bracu.ac.bd/academia/
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page = client.getPage(baseUrl);
            System.out.println(page.asXml());
//            System.out.println(page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
}
}
