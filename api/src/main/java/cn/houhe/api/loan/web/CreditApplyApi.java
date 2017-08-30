package cn.houhe.api.loan.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.web.bo.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T05:36:23.626Z")

@Api(value = "creditApply", description = "the creditApply API")
@RequestMapping("repay")
public interface CreditApplyApi {

    @ApiOperation(value = "上传身份证", notes = "关联用户的身份证图片 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "正确响应,\"0\"：成功，\"1\"：识别失败", response = ResultDto.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/idCard",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyIdCardPost(@ApiParam(value = "请求信息", required = true) @Valid @RequestBody RequestDto<CreditApplyIdCardDto> apply) throws Exception;


    @ApiOperation(value = "上传行驶证", notes = "关联用户的行驶证图片 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "正确响应,\"0\"：成功，\"1\"：识别失败", response = ResultDto.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/driving",
        produces = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyDriving(@ApiParam(value = "请求信息", required = true) @Valid @RequestBody RequestDto<CreditApplyDrivingDto> apply) throws Exception;



    @ApiOperation(value = "信用申请的状态", notes = "返回用户信用的状态 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/state",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyStatePost(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyInfoDto> info) throws Exception;



    @ApiOperation(value = "信用申请填写个人信息", notes = "信用申请填写个人信息 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/persInfo",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyPersonalInfo(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyPersonalInfoDto> info) throws Exception;

@ApiOperation(value = "信用申请保存授权信息", notes = "信用申请保存授权信息 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/auth",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyAuth(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyAuthDto> info) throws Exception;



    @ApiOperation(value = "信用申请上传头像", notes = "信用申请上传头像 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/face",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyFace(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyFaceDto> info) throws Exception;


    @ApiOperation(value = "信用申请合同", notes = "信用申请合同 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/contract",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyContract(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyContractDto> contract) throws Exception;


    @ApiOperation(value = "信用申请预览合同", notes = "信用申请预览合同 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/contract/preview",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> creditApplyPreviewContract(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyContractDto> contract) throws Exception;


@ApiOperation(value = "贷款预览合同", notes = "贷款预览合同 ", response = ResultDto.class, tags={ "loan apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/loan/contract/preview",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> loanApplyPreviewContract(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyContractDto> contract) throws Exception;



    @ApiOperation(value = "贷款申请", notes = "贷款申请 ", response = ResultDto.class, tags={ "loan apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/loan/apply",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> loanApply(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<LoanApplyDto> applyDto) throws Exception;


    @ApiOperation(value = "贷款申请上传头像", notes = "贷款申请上传头像 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/loan/apply/face",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResultDto> loanApplyFace(@ApiParam(value = "请求信息"  ) @RequestBody RequestDto<CreditApplyFaceDto> info) throws Exception;


    @ApiOperation(value = "授信申请芝麻信息授权回调", notes = "授信申请芝麻信息授权回调 ", response = ResultDto.class, tags={ "credit apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "正确响应", response = ResultDto.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = ResultDto.class) })
    @RequestMapping(value = "/creditApply/alcallback",
            produces = { "application/json" })
    ResponseEntity<ResultDto> creditApplyAlCallback(@ApiParam(value = "请求信息"  )@RequestParam  CreditApplyAlCallbackDto info) throws Exception;



}
