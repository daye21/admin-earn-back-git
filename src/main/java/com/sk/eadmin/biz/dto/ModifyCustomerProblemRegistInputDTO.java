package com.sk.eadmin.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ModifyCustomerProblemRegistInputDTO {

    private Integer registID;
    private String customerName;
    private String customerMobile;
    private String requestDesc;
    private String problemCode;
    private String problemDegree;
}
