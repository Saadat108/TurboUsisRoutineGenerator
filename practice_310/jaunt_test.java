/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;
import com.jaunt.*;
import com.jaunt.component.Form;
import com.google.gson.Gson;


/**
 *
 * @author User
 */
public class jaunt_test {
    public static void main(String[]args){
        int Sun=0, Mon=1, Tue=2, Wed=3, Thu=4, Fei=5, Sat=6;
        int faculty = 7;
        int facultyInitials = 8;
        
        Gson gson = new Gson();
        String routineREQ = "http://usis.bracu.ac.bd/academia/academicSection/listAcademicSectionWithSchedule?query=cse310&academiaSession=627107&_search=false&nd=1553452671624&rows=20&page=1&sidx=course_code&sord=asc";
        try{
            UserAgent userAgent = new UserAgent(); 
            userAgent.visit("http://usis.bracu.ac.bd/academia/");

            Form form = userAgent.doc.getForm(0);       //get the document's first Form
            form.setTextField("j_username", "s.saadathussain.95@gmail.com"); //or form.set("email", "tom@mail.com");
            form.setPassword("j_password", "87jTXnWZ");           //or form.set("pw", "secret");
//            form.setCheckBox("remember", true);         //or form.set("remember", "on");
//            form.setSelect("account", "advanced");      //or form.set("account", "advanced");
//            form.setTextArea("comment", "no comment");  //or form.set("comment", "no comment");
//            form.setRadio("inform", "no");              //or form.set("inform", "no");
            form.submit();        //click the submit button labelled 'create trial account'
//            System.out.println(userAgent.getLocation());//print the current location (url)
            userAgent.sendGET(routineREQ);   //send request
            System.out.println("JSON");
            int resSize = userAgent.json.get("rows").findEach("cell").size();
            String got = userAgent.json.get("rows").findEach("cell").get(0).get(2).toString();
            for(int i=0; i<resSize; i++){
                System.out.println(userAgent.json.get("rows").findEach("cell").get(i).get(2)); 
               
//                System.out.println(userAgent.json.get("rows").findEach("cell").get(i).get(2).toString());
                
                if(userAgent.json.get("rows").findEach("cell").get(i).get(2).toString() == "OBJECT ORIENTED PROGRAMMING"){
                    System.out.println("haha very true it is OOP!");
                }
            }
            if(got=="OBJECT ORIENTED PROGRAMMING"){
            System.out.println("2haha very true it is OOP!");
            }
            System.out.println("GOT: "+got.getClass());
            
            System.out.println(userAgent.json.get("rows").findEach("cell")); 
            System.out.println("end_JSON");
            String response = userAgent.json.toString();
            System.out.println("JSON string");
            System.out.println(response);
            gson.fromJson(response, Routine_json.class);
            System.out.println("GSON");
            System.out.println(gson);
        }
        catch(JauntException e){                   
          System.err.println(e);
        }
            }

}
