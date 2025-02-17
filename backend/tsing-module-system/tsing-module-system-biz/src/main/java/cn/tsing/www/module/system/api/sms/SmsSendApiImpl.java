package cn.tsing.www.module.system.api.sms;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.module.system.api.sms.dto.send.SmsSendSingleToUserReqDTO;
import cn.tsing.www.module.system.service.sms.SmsSendService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class SmsSendApiImpl implements SmsSendApi {

    @Resource
    private SmsSendService smsSendService;

    @Override
    public CommonResult<Long> sendSingleSmsToAdmin(SmsSendSingleToUserReqDTO reqDTO) {
        return success(smsSendService.sendSingleSmsToAdmin(reqDTO.getMobile(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

    @Override
    public CommonResult<Long> sendSingleSmsToMember(SmsSendSingleToUserReqDTO reqDTO) {
        return success(smsSendService.sendSingleSmsToMember(reqDTO.getMobile(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

}
