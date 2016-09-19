package org.netty.demo;

import org.framework.basic.server.NettyServerBootstrap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        NettyServerBootstrap.createServer().start();
    }
}
