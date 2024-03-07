/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    Integer count = 0;
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        if(ic.getMethod().getName().equals("printByCountry"))
            count++;
        
        System.out.println("Numero di volte che printByCountry() è stato invocato: "+count);
        return ic.proceed();
    }
}
