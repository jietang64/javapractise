package com.jietang.netty;

/**
 * @author: jietang
 * @create: 2020/12/4-2:59 下午
 **/

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

//    private final ByteBuf firstMessage;

    /**
     * Creates a client-side handler.
     * @throws Exception
     */

    //客户端连接服务器后调用，简单的就ctx.writeAndFlush(ByteBuf)，复杂点就自定义编解码器
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "hello world,this is netty client";
        byte[] bytes = msg.getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = Unpooled.wrappedBuffer(bytes);
        ctx.writeAndFlush(buf);
        Thread.sleep(10000);
    }

    //接收到数据后调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
    }

    //完成时调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("channelReadComplete");
        ctx.flush();
    }

    //发生异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }



}
