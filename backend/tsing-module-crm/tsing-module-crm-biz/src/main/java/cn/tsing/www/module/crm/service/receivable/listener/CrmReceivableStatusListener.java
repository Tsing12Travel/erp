package cn.tsing.www.module.crm.service.receivable.listener;

import cn.tsing.www.module.bpm.event.BpmProcessInstanceStatusEvent;
import cn.tsing.www.module.bpm.event.BpmProcessInstanceStatusEventListener;
import cn.tsing.www.module.crm.service.receivable.CrmReceivableService;
import cn.tsing.www.module.crm.service.receivable.CrmReceivableServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 回款审批的结果的监听器实现类
 *
 * @author HUIHUI
 */
@Component
public class CrmReceivableStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private CrmReceivableService receivableService;

    @Override
    public String getProcessDefinitionKey() {
        return CrmReceivableServiceImpl.BPM_PROCESS_DEFINITION_KEY;
    }

    @Override
    public void onEvent(BpmProcessInstanceStatusEvent event) {
        receivableService.updateReceivableAuditStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
