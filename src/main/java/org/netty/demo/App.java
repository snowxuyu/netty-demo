package org.netty.demo;

import org.framework.basic.server.NettyServerBootstrap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	// 创建->设置application父容器->设置springmvc子容器->设置server参数->启动
        NettyServerBootstrap.createServer()
        	.setSpringApplicationContext("classpath:/springs/applicationContext.xml")
        	.setSpringServletContext("classpath:/springs/springmvc-servlet.xml")
        	.parseCommondArguments(args)
        	.start();
    }
}
