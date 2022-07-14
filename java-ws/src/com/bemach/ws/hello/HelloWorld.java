package com.bemach.ws.hello;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public class HelloWorld {
    private static final Logger LOG = Logger.getLogger(HelloWorld.class.getName());
    @WebMethod
    public String say (@WebParam(name="name") String name) {
        LOG.info("Web service is called!");
        return String.format("Hello, %s!", name);
    }
    public static void main (String[] args) {
        String msg = new HelloWorld().say("Johnny, B. Good");
        LOG.info(msg);
    }
}

