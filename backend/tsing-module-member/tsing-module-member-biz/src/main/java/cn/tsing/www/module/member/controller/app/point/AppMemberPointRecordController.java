package cn.tsing.www.module.member.controller.app.point;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.framework.common.pojo.PageParam;
import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.framework.common.util.object.BeanUtils;
import cn.tsing.www.module.member.controller.app.point.vo.AppMemberPointRecordPageReqVO;
import cn.tsing.www.module.member.controller.app.point.vo.AppMemberPointRecordRespVO;
import cn.tsing.www.module.member.convert.point.MemberPointRecordConvert;
import cn.tsing.www.module.member.dal.dataobject.point.MemberPointRecordDO;
import cn.tsing.www.module.member.service.point.MemberPointRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;
import static cn.tsing.www.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "用户 App - 签到记录")
@RestController
@RequestMapping("/member/point/record")
@Validated
public class AppMemberPointRecordController {

    @Resource
    private MemberPointRecordService pointRecordService;

    @GetMapping("/page")
    @Operation(summary = "获得用户积分记录分页")
    public CommonResult<PageResult<AppMemberPointRecordRespVO>> getPointRecordPage(
            @Valid AppMemberPointRecordPageReqVO pageReqVO) {
        PageResult<MemberPointRecordDO> pageResult = pointRecordService.getPointRecordPage(getLoginUserId(), pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppMemberPointRecordRespVO.class));
    }

}
