/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private HashMap<String, Integer> counterMap = new HashMap<String, Integer>();
    int max = 0;
    String metodo ="";
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception{
        if(!counterMap.containsKey(ic.getMethod().getName()))
            counterMap.put(ic.getMethod().getName(), 0);
        counterMap.put(ic.getMethod().getName(), counterMap.get(ic.getMethod().getName())+1);
        
        if(counterMap.get(ic.getMethod().getName()) > max){
            max = counterMap.get(ic.getMethod().getName());
            metodo = ic.getMethod().getName();
        }
        
        System.out.println("Invocato Metodo: "+ic.getMethod().getName()+ "() numero invocazione: "+counterMap.get(ic.getMethod().getName())+ ". \nMetodo Con maggior numero di "
                + "invocazioni : "+metodo+" numero: "+max);
        return ic.proceed();
    }
}
