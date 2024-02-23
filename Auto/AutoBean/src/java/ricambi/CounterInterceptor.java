package ricambi;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@Counter
public class CounterInterceptor {
    private HashMap<String, Integer> counterMap = new HashMap<String, Integer>();
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception{
        if(!counterMap.containsKey(ic.getMethod().getName()))
            counterMap.put(ic.getMethod().getName(), 0);
        counterMap.put(ic.getMethod().getName(), counterMap.get(ic.getMethod().getName())+1);
        
        System.out.println("Chiamata numero " +counterMap.get(ic.getMethod().getName())+ ": " +ic.getMethod().getName());
        
        return ic.proceed();
    }
}