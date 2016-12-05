package org.netty.demo;

import org.framework.basic.server.NettyApplication;
import org.framework.basic.server.annotation.NettyBootstrap;

/**
 * Hello world!
 *
 */
@NettyBootstrap(applicationContext = "classpath:/springs/applicationContext.xml", servletContext = "classpath:/springs/springmvc-servlet.xml")
public class App {
    public static void main( String[] args ){


		NettyApplication.run(App.class, args);
    	// 创建->设置application父容器->设置springmvc子容器->设置server参数->启动
      /*  NettyServerBootstrap.createServer()
        	.setSpringApplicationContext("classpath:/springs/applicationContext.xml")
        	.setSpringServletContext("classpath:/springs/springmvc-servlet.xml")
        	.parseCommondArguments(args)
        	.start();*/
    }
}
