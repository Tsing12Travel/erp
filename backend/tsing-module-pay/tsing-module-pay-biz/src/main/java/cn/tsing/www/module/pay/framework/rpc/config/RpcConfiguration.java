package cn.tsing.www.module.pay.framework.rpc.config;

import cn.tsing.www.module.system.api.social.SocialClientApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {SocialClientApi.class})
public class RpcConfiguration {
}
