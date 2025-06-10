package com.sk.eadmin.biz.dto;



 import io.swagger.v3.oas.annotations.media.Schema;
 import lombok.Data;

    @Data
    public class CustomerProblemRegistReqDTO {

        @Schema(description = "고객 이름", example = "홍길동", required = true)
        private String customerName;

        @Schema(description = "고객 휴대폰 번호", example = "01098765432", required = true)
        private String customerMobile;

        @Schema(description = "요청 설명", example = "요청설명 샘플", required = true)
        private String requestDesc;

        @Schema(description = "문제 코드", example = "01", required = true)
        private String problemCode;

        @Schema(description = "문제 심각도", example = "1", required = true)
        private Integer problemDegree;

        @Schema(description = "진행 상태 코드", example = "01", required = true)
        private String progressStatusCode;

        @Schema(description = "테스트 ID", example = "hongkildong", required = true)
        private String testID;


    }



