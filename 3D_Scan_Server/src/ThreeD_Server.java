

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


import  org.jboss.netty.bootstrap.ServerBootstrap;
import  org.jboss.netty.channel.ChannelPipeline;
import  org.jboss.netty.channel.ChannelPipelineFactory;
import  org.jboss.netty.channel.Channels;
import  org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
/**
 * Discards any incoming data.
 */
public class ThreeD_Server {
    public static void main(String[] args) throws Exception {
    	System.out.println("Server started...");
    	
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
			public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new ThreeD_ServerHandler());
           }
        });
        bootstrap.bind(new InetSocketAddress(4444));
        System.out.println("Server binded...");
    }   	
}