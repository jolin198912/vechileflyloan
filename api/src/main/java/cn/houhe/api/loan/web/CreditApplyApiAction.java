package cn.houhe.api.loan.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.entity.LoanContract;
import cn.houhe.api.loan.service.CreditApplyService;
import cn.houhe.api.loan.service.LoanContractService;
import cn.houhe.api.loan.service.LoanRecordExtService;
import cn.houhe.api.loan.web.bo.*;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T05:36:23.626Z")

@Controller
public class CreditApplyApiAction implements CreditApplyApi {


    @Autowired
    private CreditApplyService creditApplyService;

    @Autowired
    private LoanRecordExtService loanRecordExtService;

    @Autowired
    private LoanContractService loanContractService;

    public ResponseEntity<ResultDto> creditApplyIdCardPost(@ApiParam(value = "请求信息", required = true) @Valid @RequestBody RequestDto<CreditApplyIdCardDto> apply) throws Exception {

        CreditApplyIdCard card = creditApplyService.applyIdCard(apply.getData());
        return new ResponseEntity<ResultDto>(new ResultDto().data(card), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResultDto> creditApplyDriving(@ApiParam(value = "请求信息") @Valid @RequestBody RequestDto<CreditApplyDrivingDto> apply) throws Exception {
        creditApplyService.applyDriving(apply.getData());
        return new ResponseEntity<ResultDto>(new ResultDto(), HttpStatus.OK);
    }

    public ResponseEntity<ResultDto> creditApplyStatePost(@ApiParam(value = "请求信息") @Valid @RequestBody RequestDto<CreditApplyInfoDto> info) throws Exception {

        CreditApplyInfo applyInfo = creditApplyService.applyInfo(info.getData());
        return new ResponseEntity<ResultDto>(new ResultDto().data(applyInfo), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResultDto> creditApplyPersonalInfo(@Valid @RequestBody RequestDto<CreditApplyPersonalInfoDto> info) throws Exception {

        creditApplyService.applyPersonalInfo(info.getData());
        return new ResponseEntity<ResultDto>(new ResultDto(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResultDto> creditApplyAuth(@RequestBody RequestDto<CreditApplyAuthDto> info) throws Exception {
        creditApplyService.applyAuth(info.getData());
        Map result = new HashMap();
        result.put("contracts", info.getData().getContracts());
        return new ResponseEntity<ResultDto>(new ResultDto().data(result), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResultDto> creditApplyFace(@RequestBody RequestDto<CreditApplyFaceDto> info) throws Exception {

        creditApplyService.face(info.getData());
        return new ResponseEntity<ResultDto>(new ResultDto(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResultDto> creditApplyContract(@RequestBody RequestDto<CreditApplyContractDto> contract) throws Exception {
        creditApplyService.contract(contract.getData());
        return new ResponseEntity<ResultDto>(new ResultDto(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResultDto> creditApplyPreviewContract(@RequestBody RequestDto<CreditApplyContractDto> contract) throws Exception {

        Map result = new HashMap();
        result.put("url", loanContractService.preview("credit", contract.getData().getTid()));
        return new ResponseEntity<ResultDto>(new ResultDto().data(result), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResultDto> loanApplyPreviewContract(RequestDto<CreditApplyContractDto> contract) throws Exception {
        Map result = new HashMap();
        result.put("url", loanContractService.preview("loan", contract.getData().getTid()));
        return new ResponseEntity<ResultDto>(new ResultDto().data(result), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResultDto> loanApply(@RequestBody RequestDto<LoanApplyDto> applyDto) throws Exception {
        loanRecordExtService.loanApply(applyDto.getData());
        return new ResponseEntity<ResultDto>(new ResultDto(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResultDto> loanApplyFace(@RequestBody RequestDto<CreditApplyFaceDto> info) throws Exception {
        loanRecordExtService.face(info.getData());
        Map result = new HashMap();
//        result.put("confidence",info.getData().getConfidence());
        return new ResponseEntity<ResultDto>(new ResultDto().data(result), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResultDto> creditApplyAlCallback(@RequestParam CreditApplyAlCallbackDto info) throws Exception {
        //TODO 保存芝麻信用open_id, 暂不实现，由客户端传递
        return null;
    }
}
