/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310.GSON_practice;
import com.google.gson.Gson;
/**
 *
 * @author User
 */
public class test_GSON {
    
    public static void main(String[] args){
        System.out.println("GSON trial");
        serializeUserSimple();
    }
    private static void serializeUserSimple(){
        UserSimple user = new UserSimple("Saadat", "saadat@email.com", 24, true);
        Gson gson = new Gson(); 
        String json = gson.toJson(user);
        System.out.println(json);
    }
    private void deSerializeUserSimple(){
        String userJson = "{'name':'Saadat','email':'saadat@email.com','age':24,'isDeveloper':true}";
        
        Gson gson = new Gson();
        gson.fromJson(userJson, UserSimple.class);
    }
}
