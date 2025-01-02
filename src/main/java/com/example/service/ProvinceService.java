package com.example.service;

import com.example.model.DTO.ProvinceDTO;
import com.example.model.Province;
import com.example.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Iterable<ProvinceDTO> countCustomerByProvince() {
        return provinceRepository.countCustomerByProvince();
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteProvinceById(id);
    }
}
