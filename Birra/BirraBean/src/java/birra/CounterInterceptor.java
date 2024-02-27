package birra;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private Integer counter = 0;
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        if(ic.getMethod().getName().equals("getByRegione"))
            ++counter;
        System.out.println("numero di volte che getByRegione invoato: "+counter);
        return ic.proceed();
    }
}
