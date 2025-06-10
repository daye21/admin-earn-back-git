package com.sk.eadmin.biz.controller;

import java.util.ArrayList;
import java.util.List;

import com.sk.eadmin.biz.dto.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.sk.eadmin.biz.service.CustomerProblemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.parser.Entity;

@Tag(name = "customer-problem", description = "고객문의")
@RestController
@RequestMapping("/api/v1/customer/problem-mgmt")
@RequiredArgsConstructor
public class CustomProblemController {
  private final CustomerProblemService customerProblemService;

    @Operation(summary = "고객접수문의 변경", description = "입력조건에 따라 접수된 고객 문의 정보를 변경 한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "OK"),
            @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
    )
    @PatchMapping("/customer-problem/{reqestID}")
    public ResponseEntity<Object> updateCustomerProblemRegist(
            @RequestBody CustomerProblemRegistInputDTO inputDTO
    ){
      customerProblemService.updateCustomerProblem(CustomerProblemRegistInputDTO.builder()
              .reqID(inputDTO.getReqID())
              .customerName(inputDTO.getCustomerName())
                      .customerMobile(inputDTO.getCustomerMobile())
                      .requestDesc(inputDTO.getRequestDesc())
                      .problemCode(inputDTO.getProblemCode())
                      .problemDegree(inputDTO.getProblemDegree())
                      .progressStatusCode(inputDTO.getProgressStatusCode())
              .build()
      );

  return new ResponseEntity<Object>(HttpStatus.OK);
    }


   /*@Operation(summary = "고객접수문의 상세 조회", description = "입력조건에 따라 접수된 고객 문의 상세 정보를 조회한다.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "OK"),
          @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
  }
  )
 @GetMapping("/customer-problem/{id}")
  public ResponseEntity<CustomerProblemRegistInputDTO>getCustomerProblemRegist(
          @PathVariable(name= "id") int registID
  ){
      final CustomerProblemDetailInfoOutputDTO serviceResult =

  }*/



  @Operation(summary = "고객접수문의 리스트 조회", description = "입력조건에 따라 접수된 고객 문의 리스트를 조회한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @GetMapping("/customer-problem")
  public ResponseEntity<List<CustomerProblemRegistResDTO>> getCustomerProblemRegistList(
    @RequestParam(name = "problemCode", required = false)
    @Valid @Pattern(regexp = "^000[1-4]$")
    @Schema(
      description = "문의코드. 0001 - 사용요금관련, 0002 - 통화품질관련, 0003 - 대리점 서비스 관련, 0004 - 해외 로밍 관련",
      name = "problemCode",
      type = "string",
      example = "0001"
    )
    String problemCode,

    @RequestParam(name = "agentRegionCode", required = false)
    @Valid @Pattern(regexp = "^0[1-3]$")
    @Schema(
      description = "담당지역코드. 01 - 서울, 02 - 경기, 03 - 인천",
      name = "agentRegionCode",
      type = "string",
      example = "01"
    )
    String agentRegionCode,

    @RequestParam(name = "progressStatusCode", required = false)
    @Valid @Pattern(regexp = "^0[1-2]$")
    @Schema(
      description = "진행상태코드. 01 - 성공, 02 - 대기",
      name = "progressStatusCode",
      type = "string",
      example = "01"
    )
    String progressStatusCode,

    @Valid
    @Schema(
      description = "요청필터",
      name = "requestFilter",
      type = "string",
      example = "샘플"
    )
    @RequestParam(name = "requestFilter", required = false)
    String requestFilter
  ) {
    final List<CustomerProblemRegistOutputDTO> serviceResults = customerProblemService.getCustomerProblemRegistList(
         CustomerProblemRegistInputDTO.builder()
            .problemCode(problemCode)
            .agentRegionCode(agentRegionCode)
            .progressStatusCode(progressStatusCode)
            .requestDesc(requestFilter).build()
      );
    List<CustomerProblemRegistResDTO> rets = new ArrayList<CustomerProblemRegistResDTO>();      
    for (CustomerProblemRegistOutputDTO serviceResult: serviceResults) {
      final CustomerProblemRegistResDTO retObject = CustomerProblemRegistResDTO.builder()
          .regId(serviceResult.getRegId())
          .custNm(serviceResult.getCustNm())
          .custMbl(serviceResult.getCustMbl())
          .reqDesc(serviceResult.getReqDesc())
          .prbmCd(serviceResult.getPrbmCd())
          .prbmDgr(serviceResult.getPrbmDgr())
          .prgsSts(serviceResult.getPrgsSts())
          .prgsStsVal(serviceResult.getPrgsStsVal())
          .crteDttm(serviceResult.getCrteDttm())
          .agntIcn(serviceResult.getAgntIcn()).build();
      rets.add(retObject);
    }
    return new ResponseEntity<List<CustomerProblemRegistResDTO>>(rets, HttpStatus.OK);
  }




  @PostMapping
  @Operation(
          summary = "고객접수문의 신규 등록",
          description = "입력조건에 따라 접수된 고객 문의 정보를 신규 등록 한다.",
          operationId = "addCustomerProblemRegist",
          responses = {
                  @ApiResponse(responseCode = "204", description = "OK"),
                  @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
          }
  )
  public ResponseEntity<Void> addCustomerProblemRegist(
          @Parameter(description = "고객 문의 정보", required = true, schema = @Schema(implementation = CustomerProblemRegistReqDTO.class)) @RequestBody CustomerProblemRegistReqDTO request) {

    // 1. 요청 데이터 검증 (Validation)
    // 2. 고객 문의 정보 저장 (Service Layer 호출)
    // 3. 성공 응답 반환 (HTTP 상태 코드 204 No Content)

    // 임시 코드 (실제 코드에서는 위 주석 처리된 부분을 구현해야 함)
    return ResponseEntity.noContent().build();
  }



  


}
