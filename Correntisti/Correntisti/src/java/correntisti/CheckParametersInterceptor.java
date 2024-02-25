/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correntisti;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;



@Interceptor
@CheckParameters
public class CheckParametersInterceptor {
    @AroundInvoke
    public Object check(InvocationContext ic) throws Exception{
        Integer param = (Integer) ic.getParameters()[1];
        if(param > 15000){
            System.out.println("Operzione non andata a buon fine");
            return false;
        }
        return ic.proceed();
    }
}
