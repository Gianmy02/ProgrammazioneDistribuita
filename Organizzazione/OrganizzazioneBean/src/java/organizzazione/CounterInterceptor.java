package organizzazione;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
   Integer counter = 0;
   @AroundInvoke
   public Object notify(InvocationContext ic) throws Exception{
       if(ic.getMethod().getName().equals("stampaBilancioMaggiore"))
           counter++;
       System.out.println("Numero di volte che stampaBilancioMaggiore è stata invocata: "+counter);
       return ic.proceed();
   }
}
