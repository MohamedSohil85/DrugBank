package com.drugs.drugsrepository.persistence;

import com.drugs.drugsrepository.entity.DrugsBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugsBankRepository extends JpaRepository<DrugsBank,Long> {


}
