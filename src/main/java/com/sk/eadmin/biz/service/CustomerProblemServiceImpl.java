package com.sk.eadmin.biz.service;

import java.util.ArrayList;
import java.util.List;

import com.sk.eadmin.biz.dto.*;
import org.springframework.stereotype.Service;

import com.sk.eadmin.biz.mapper.CustomerProblemMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProblemServiceImpl implements CustomerProblemService {
  private final CustomerProblemMapper customerProblemMapper;
  public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(@NonNull CustomerProblemRegistInputDTO input) {
	log.debug(">>>>> {}.getCustomerProblemRegistList Start <<<<<", this.getClass().getName());
	log.debug("    Parameter 1 - input[{}]", input);
    final CustomerProblemRegistMapperInputDTO mapperInput = CustomerProblemRegistMapperInputDTO.builder()
    	.problemCode(input.getProblemCode())
    	.agentRegionCode(input.getAgentRegionCode())
    	.progressStatusCode(input.getProgressStatusCode())
    	.requestDesc(input.getRequestDesc())
        .build();
    log.debug("mapperInput - {}", mapperInput);
	final List<CustomerProblemRegistMapperOutputDTO> mapperResults = customerProblemMapper.getCustomerProblemRegistList(mapperInput);
    log.debug("mapperResults - {}", mapperResults);
	List<CustomerProblemRegistOutputDTO> retList = new ArrayList<CustomerProblemRegistOutputDTO>();
	for (CustomerProblemRegistMapperOutputDTO mapperResult: mapperResults) {
		final CustomerProblemRegistOutputDTO ret = CustomerProblemRegistOutputDTO.builder()
			.regId(mapperResult.getRegId()) 
		    .custNm(mapperResult.getCustNm())
			.crteDttm(mapperResult.getCrteDttm())
			.agntIcn(mapperResult.getAgntIcn())
			.prbmDgr(mapperResult.getPrbmDgr())
			.prgsSts(mapperResult.getPrgsSts()).build();
		retList.add(ret);
	}
    log.debug("retList - {}", retList);
	log.debug(">>>>> {}.getCustomerProblemRegistList Finish <<<<<", this.getClass().getName());
    log.debug("    return - [{}]", retList);
    return retList;
  }

	@Override
	public void updateCustomerProblem(@NonNull CustomerProblemRegistInputDTO param) {
		log.debug(">>>>> {}.update CustomerProblemRegist Start <<<<<", this.getClass().getName());
		log.debug("    Parameter 1 - input[{}]", param);
		final CustomerProblemRegistMapperInputDTO mapperInput = CustomerProblemRegistMapperInputDTO.builder()
				.registID(param.getRegistID())
				.customerName(param.getCustomerName())
				.customerMobile(param.getCustomerMobile())
				.requestDesc(param.getRequestDesc())
				.problemCode(param.getProblemCode())
				.problemDegree(param.getProblemDegree())
				.progressStatusCode(param.getProgressStatusCode())
				.agentRegionCode(param.getAgentRegionCode())
				.build();
		log.debug("mapperInput - {}", mapperInput);
		customerProblemMapper.updateCustomerProblem(mapperInput);


	}

	@Override
	public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO inputDTO) {
		customerProblemMapper.modifyCustomerProblemRegist(inputDTO);
	}

	@Override
	public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO inputDTO) {
		customerProblemMapper.addCustomerProblemRegist(inputDTO);
	}

	@Override
	public void deleteCustomerProblemRegist(Integer registID) {
	   customerProblemMapper.deleteCustomerProblemRegist(registID);

	}



/*	@Override
	public CustomerProblemRegistMapperOutputDTO getCustomerProblemRegistDetail(CustomerProblemRegistInputDTO registID) {

	  final CustomerProblemRegistMapperInputDTO mapperInput = CustomerProblemRegistMapperInputDTO.builder().registID(registID.getRegistID()).build();

		CustomerProblemRegistMapperOutputDTO mapperResult=customerProblemMapper.getCustomerProblemRegistDetail(mapperInput);
		final CustomerProblemRegistResDTO regi = CustomerProblemRegistResDTO.builder()
				.custNm(mapperResult.getCustNm())
				.custMbl(mapperResult.getCustMbl())
				.prgsSts(mapperResult.getPrgsSts())
				.reqDesc(mapperResult.getReqDesc())
				.crteDttm(mapperResult.getCrteDttm()).build();

		final List<CustomerProblemMappingAgentResDTO> agetRestList = new ArrayList<CustomerProblemMappingAgentResDTO>();

		*//*final CustomerProblemDetailInfoOutputDTO response = CustomerProblemDetailInfoOutputDTO.builder().customerProblemRegistResDTO(regi).build();
		);
				;*//*



	  return null;
	}*/


}
