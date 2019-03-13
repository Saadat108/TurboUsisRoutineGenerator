/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author User
 */
public class web_scrape {
//    print("running");
    public static void main(String args[]){
		print("running...");
		Document document;
                Document wiki ;
		try {
			//Get Document object after parsing the html from given url.
                        wiki = Jsoup.connect("http://en.wikipedia.org/").get();
                        print("wiki:=    "+wiki.title());
                        Elements newsHeadlines = wiki.select("mp-itn b a");
                        for(Element headline : newsHeadlines){
                            System.out.println(headline.text());
                        }
                        
			document = Jsoup.connect("http://usis.bracu.ac.bd/academia/dashBoard/show#/academia/studentCourse/showClassScheduleInTabularFormatByStudent?456&4560.7105001654858532").get();
                        String dash="ui-header-title";
                        Elements dashG = document.select("ui-header-title"); //dashboard name
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
                        print("dash: " + dashG.text());

		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
	}

	public static void print(String string) {
		System.out.println(string);
}
}

