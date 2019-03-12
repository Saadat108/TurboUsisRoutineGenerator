/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *This class is used for HTML parsing from URL using Jsoup.
 * @author User
 */
public class ParseZillowGuide {
    public static void main(String args[]){
        String s = "87jTXnWZ";
		print("running...");
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("http://www.zillow.com/denver-co/").get();

			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
                        
                        Elements price = document.select(".zsg-photo-card-price:contains($)"); //Get price
			Elements address = document.select("span[itemprop]:contains(DenverCO)");  //Get address
                        System.out.println("sizeA: " + address.size());
                        System.out.println("sizeP: " + price.size());
			
			for (int i=0; i < price.size(); i++) {
				print( price.get(i).text());
                        }
                        
                        // creating the CSV file
                        FileOutputStream  fout = new FileOutputStream("outpur_zillow.csv");
                        PrintStream csv = new PrintStream(fout);
                        csv.println("name	price	number sold");
                        for (int i=0; i<price.size()-2; i++){
                            csv.println(price.get(i).text());
                        }
                        fout.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
	}

	public static void print(String string) {
		System.out.println(string);
}
}
