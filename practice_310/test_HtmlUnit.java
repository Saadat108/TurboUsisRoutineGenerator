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
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

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
//            page = page.get("Show Class Schedule").click();
            
            // calls JSON API
//            HtmlPage routinepage = client.getPage("http://usis.bracu.ac.bd/academia/academicSection/listAcademicSectionWithSchedule?query=cse310&academiaSession=627107&_search=false&nd=1553452671624&rows=20&page=1&sidx=course_code&sord=asc");
            page.asXml();
            
            
            Gson gson = new Gson();
            
            String query_url = "http://usis.bracu.ac.bd/academia/academicSection/listAcademicSectionWithSchedule?query=cse310&academiaSession=627107&_search=false&nd=1553452671624&rows=20&page=1&sidx=course_code&sord=asc";
           
           try {
           URL url = new URL(query_url);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setConnectTimeout(5000);
           conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
           conn.setDoOutput(true);
           conn.setDoInput(true);
           conn.setRequestMethod("POST");
           OutputStream os = conn.getOutputStream();
           
           os.close(); 
           // read the response
           InputStream in = new BufferedInputStream(conn.getInputStream());
           String result = IOUtils.toString(in, "UTF-8");
           gson.fromJson(result, Routine_json.class);
           System.out.println("GSON");
           System.out.println(gson);
           System.out.println("GSON");
           System.out.println(result);
           System.out.println("result after Reading JSON Response");
           JSONObject myResponse = new JSONObject(result);
           System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
           System.out.println("id- "+myResponse.getInt("id"));
           System.out.println("result- "+myResponse.getString("result"));
           in.close();
           conn.disconnect();
           } catch (Exception e) {
   			System.out.println(e);
   		}
            
            
//        gson.fromJson(routinepage, Routine_json.class);
            
            
            // goes to find class timing
            //method 1
//            HtmlSelect select = (HtmlSelect) page.getElementById("accordion1");
//            HtmlOption option = select.getOptionByValue("Student");
//            select.setSelectedAttribute(option, true);
            
            // method 2
//            HtmlAnchor anchor = page.getAnchorByName("Show Class Schedule");
//            HtmlPage page3 = anchor.click();
//            System.out.println(page3.asText());
            
            System.out.println(page.asText());
//            System.out.println(page.asXml());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        
}
}
