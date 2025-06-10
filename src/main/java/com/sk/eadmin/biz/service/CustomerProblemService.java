package com.sk.eadmin.biz.service;

import java.util.List;

import com.sk.eadmin.biz.dto.*;

public interface CustomerProblemService {
  public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO param);
  public void updateCustomerProblem(CustomerProblemRegistInputDTO param);

  //public CustomerProblemRegistMapperOutputDTO getCustomerProblemRegistDetail(CustomerProblemRegistInputDTO registID);


  public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO inputDTO);
  public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO inputDTO);
  public void deleteCustomerProblemRegist(Integer registID);
}
