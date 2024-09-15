package com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.repository;

import com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

}
