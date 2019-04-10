/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310.GSON_practice;

/**
 *
 * @author User
 */
public class UserSimple {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;
    
    public UserSimple(String name, String email, int age, boolean isDeveloper){
    this.name = name;
    this.age = age;
    this.email = email;
    this.isDeveloper = isDeveloper;
    }
    
}
