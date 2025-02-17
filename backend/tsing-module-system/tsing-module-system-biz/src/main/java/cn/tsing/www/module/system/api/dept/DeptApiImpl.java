package cn.tsing.www.module.system.api.dept;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.framework.common.util.object.BeanUtils;
import cn.tsing.www.module.system.api.dept.dto.DeptRespDTO;
import cn.tsing.www.module.system.dal.dataobject.dept.DeptDO;
import cn.tsing.www.module.system.service.dept.DeptService;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class DeptApiImpl implements DeptApi {

    @Resource
    private DeptService deptService;

    @Override
    public CommonResult<DeptRespDTO> getDept(Long id) {
        DeptDO dept = deptService.getDept(id);
        return success(BeanUtils.toBean(dept, DeptRespDTO.class));
    }

    @Override
    public CommonResult<List<DeptRespDTO>> getDeptList(Collection<Long> ids) {
        List<DeptDO> depts = deptService.getDeptList(ids);
        return success(BeanUtils.toBean(depts, DeptRespDTO.class));
    }

    @Override
    public CommonResult<Boolean> validateDeptList(Collection<Long> ids) {
        deptService.validateDeptList(ids);
        return success(true);
    }

    @Override
    public CommonResult<List<DeptRespDTO>> getChildDeptList(Long id) {
        List<DeptDO> depts = deptService.getChildDeptList(id);
        return success(BeanUtils.toBean(depts, DeptRespDTO.class));
    }

}
