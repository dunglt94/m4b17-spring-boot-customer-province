package com.example.repository;

import com.example.model.DTO.ProvinceDTO;
import com.example.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    @Query(nativeQuery = true, value = "select p.id, name, count(first_name) as count " +
            "from province p " +
            "left join customers c on p.id = c.province_id\n" +
            "group by p.id")
    Iterable<ProvinceDTO> countCustomerByProvince();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call delete_province(:id)")
    void deleteProvinceById(@Param("id") Long id);
}
