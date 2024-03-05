/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cani;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckParameters
public class CheckParametersInterceptor{ 
    @Inject
    private CaneEJB ejb;
    @AroundInvoke
    public Object check(InvocationContext ic) throws Exception{
        Integer id = (Integer) ic.getParameters()[0];
        Cane c = ejb.getCaneById(id);
        if(c.isStatus()){
            System.out.println("Cane di id: "+c.getId()+" Operazione non andata a buon fine");
            return false;
        }
        return ic.proceed();
    }
}
