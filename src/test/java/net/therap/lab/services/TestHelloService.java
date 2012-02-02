package net.therap.lab.services;

import org.testng.annotations.Test;

import javax.ejb.EJB;

/**
 * @author jahangir
 * @since 2/2/12 1:53 PM
 */
public class TestHelloService {

    @EJB
    HelloService helloService;

    @Test(groups = {"all"})
    public void testSayHello() {
//        assert helloService != null;
        System.out.println(helloService.sayHello("TestNG"));
    }
}
