/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canzoni;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckParameters
public class CheckParametersInterceptor {
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        Integer voto = (Integer) ic.getParameters()[0];
        if(voto<10){
            System.out.println("Impedimento della chiamata getVoto con parametro inviato: "+voto);
            return null;
        }
        return ic.proceed();
    }
    
}
