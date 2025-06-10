package com.sk.eadmin.biz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class CustomerProblemMappingAgentResDTO {
  @Schema(
    description = "agentCD",
    name = "agntRegnCd",
    type = "string",
    example = "01"
  )
  private String agntRegnCd;

  @Schema(
	description = "Agent 명",
	name = "agntNm",
	type = "string",
    example = "홍길순"
  )
  private String agntNm;

  @Schema(
	description = "agent 지역",
	name = "agentRegnVal",
	type = "string",
    example = "서울",
    nullable = true
  )
  private String agentRegnVal;


}
