package com.sk.eadmin.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemMappingAgentMapperOutputDTO {
    private String agentNm;
    private String agentRegnCd;
    private String agentRegnVal;

}
