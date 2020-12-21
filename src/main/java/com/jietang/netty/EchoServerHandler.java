package com.jietang.netty;


import java.io.UnsupportedEncodingException;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author: jietang
 * @create: 2020/12/4-2:57 下午
 **/

@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    //接收请求后的处理类
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));

/*

        String msg1 = "hello world,this is netty server";
        byte[] bytes = msg1.getBytes(CharsetUtil.UTF_8);
        ByteBuf buf = Unpooled.wrappedBuffer(bytes);
        ctx.writeAndFlush(buf);
*/
        sendAnalyseRet(ctx);
        //ctx.writeAndFlush(Unpooled.copiedBuffer("hello world,this is nettyServer",CharsetUtil.UTF_8));

    }


    /**
     * 向客户端发送返回码, 告知mediahandler继续发送字节流
     * 对业务端来说就是打断系统提示音的播报
     */
    private void sendAnalyseRet(ChannelHandlerContext ctx) {
        try {
            String iatRet = "event.getRealIatRet()";
            ByteBuf content = Unpooled.copiedBuffer(iatRet.getBytes("utf-8"));
            DefaultFullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            resp.headers().add("Content-Length", content.readableBytes());
            resp.headers().set("Connection", "Close");
            resp.headers().set("SID", "11111");
            resp.headers().set("Server", String.format("AispEngineProxy[%s]@%s", "127.0.0.1", "127.0.0.1"));
            ctx.writeAndFlush(resp);
        } catch (Exception ex) {
        }
    }



    //读取完成后处理方法
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        System.out.println("EchoServerHandler.channelReadComplete");
        //ctx.flush();
    }

    //异常捕获处理方法
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
