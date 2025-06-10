package com.sk.eadmin.biz.mapper;

import java.util.List;

import com.sk.eadmin.biz.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerProblemMapper {
	List<CustomerProblemRegistMapperOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistMapperInputDTO param);
    void updateCustomerProblem (CustomerProblemRegistMapperInputDTO param);
    CustomerProblemRegistMapperOutputDTO getCustomerProblemRegistDetail(CustomerProblemRegistMapperInputDTO registID);


    CustomerProblemRegistMapperOutputDTO getCustomerProblemRegist();
    CustomerProblemRegistMapperOutputDTO getCustomerProblemRegistDetail (Integer registID);
    List<CustomerProblemMappingAgentMapperOutputDTO> getCustomerProblemMappingAgentList(Integer registID );
    void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO param);
    void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO param);
    void deleteCustomerProblemRegist(Integer registID);
}
