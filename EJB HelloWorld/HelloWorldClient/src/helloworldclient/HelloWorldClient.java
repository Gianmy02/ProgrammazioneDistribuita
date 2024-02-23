package helloworldclient;

import hello.HelloWorldBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class HelloWorldClient {
public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        HelloWorldBeanRemote helloBean = (HelloWorldBeanRemote)ctx.lookup("java:global/HelloWorldBean/HelloWorldBean!hello.HelloWorldBeanRemote");
        System.out.println("Ora invoco...");
        System.out.println(helloBean.sayHello("Ciao!"));
    }
}
