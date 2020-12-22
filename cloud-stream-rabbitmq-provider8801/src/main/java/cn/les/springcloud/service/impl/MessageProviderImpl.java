package cn.les.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import cn.les.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author
 * @version v1.0.0
 * @descripton 生产者
 * @2020/12/22 9:37
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider
{
    @Resource
    private MessageChannel output; // 消息发送管道，output名字需跟配置文件一样

    @Override
    public String send()
    {
        String serial = UUID.fastUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }
}

