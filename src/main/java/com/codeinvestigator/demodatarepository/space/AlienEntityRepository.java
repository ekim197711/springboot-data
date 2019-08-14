package com.codeinvestigator.demodatarepository.space;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienEntityRepository extends CrudRepository<AlienEntity, Integer> {


    public List<AlienEntity> findByName(String name);


    @Query("SELECT A FROM alien A WHERE A.weight > :mw")
    public List<AlienEntity> findOverweight(@Param("mw") Integer maxWeight);


    @Query("SELECT A FROM alien A WHERE A.weight > :mw")
    public Page<AlienEntity> findOverweightWithPagination(Pageable pageRequest,
                                                          @Param("mw") Integer maxWeight
                                                          );


    public void deleteByName(String name);
}
