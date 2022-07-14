package com.bemach.ws.hello.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.bemach.ws.hello.HelloWorld;
import com.bemach.ws.hello.HelloWorldService;
/**
 * The following code is a normal way of going about to call
 * a web services using Java code.
 * It is much easier to comprehend.
 *
 */
public class HelloWorldClient {
    private static final Logger LOG = Logger.getLogger(HelloWorldClient.class.getName());
    public static void main(String[] args) {
        HelloWorldClient client = new HelloWorldClient();
        try {
            client.say("Johnny B. Good");
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"ERROR:"+e);
        }
    }
    public void say (String name) throws MalformedURLException {
        LOG.info("service ... ");
        QName qName = new QName("http://hello.ws.bemach.com/", "HelloWorldService");
        URL url = new URL("http://localhost:9999/java-ws/hello");
        Service service = HelloWorldService.create(url, qName);
        HelloWorld port = (HelloWorld)service.getPort(HelloWorld.class);
        String returnMsg = port.say(name);
        LOG.info("return: "+returnMsg);
    }
}
