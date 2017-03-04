package org.netty.demo;

import org.framework.basic.server.NettyApplication;
import org.framework.basic.server.annotation.NettyBootstrap;

/**
 * Hello world!
 *
 */
@NettyBootstrap(applicationContext = "classpath:/springs/applicationContext.xml",
        servletContext = "classpath:/springs/springmvc-servlet.xml",
        serverConfig = "configs/server.properties")
public class App {
    public static void main( String[] args ){
		NettyApplication.run(App.class, args);
    }
}
