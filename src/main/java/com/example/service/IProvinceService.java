package com.example.service;

import com.example.model.DTO.ProvinceDTO;
import com.example.model.Province;

public interface IProvinceService extends IGenerateService<Province>{
    Iterable<ProvinceDTO> countCustomerByProvince();

    void deleteProvince(Long id);
}
