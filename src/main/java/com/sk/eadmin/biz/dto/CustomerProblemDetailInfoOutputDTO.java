package com.sk.eadmin.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemDetailInfoOutputDTO {
    private CustomerProblemRegistResDTO customerProblemRegistResDTO;
    private List<CustomerProblemMappingAgentResDTO> customerProblemMappingAgentResDTO;
}
