package com.kim.dani.repository;

import com.kim.dani.entity.MemberV2;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberV2Repository extends JpaRepository<MemberV2,Long> {
}
