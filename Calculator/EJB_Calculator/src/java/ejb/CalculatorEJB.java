/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Stack;
import javax.ejb.Stateless;

/**
 *
 * @author amministratore
 */
@Stateless
public class CalculatorEJB implements CalculatorEJBRemote {
    private Stack<Float> s;
    
    public CalculatorEJB(){
        s = new Stack<>();
    }
    
    @Override
    public Float pop(){
        
        return s.pop();
    }
    
    
    @Override
    public void push(Float num){
        s.push(num);
    }
    
    @Override
    public void sum(){
        Float n1 = pop();
        Float n2 = pop();
        push(n1+n2);
    }
    
    @Override
    public void sub(){
       
        push(pop()-pop());
    }
    
    @Override
    public void mul(){
      
        push(pop()*pop());
    }
}
