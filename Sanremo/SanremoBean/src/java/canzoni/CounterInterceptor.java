package canzoni;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private Integer counter = 0;
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        ++counter;
        System.out.println("Chiamata numero: "+counter+" metodo: "+ic.getMethod().getName());
        return ic.proceed();
    }
}
