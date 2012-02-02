package net.therap.lab.services;

import javax.ejb.Stateless;

/**
 * @author jahangir
 * @since 2/2/12 1:21 PM
 */
@Stateless
public class HelloService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
