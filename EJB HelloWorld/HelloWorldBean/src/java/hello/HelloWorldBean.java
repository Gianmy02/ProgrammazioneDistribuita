/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {
    @Override
    public String sayHello(String name){
        return "Hello "+name+"!";
    }
}
