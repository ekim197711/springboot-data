package com.codeinvestigator.demodatarepository.space;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlienEntityRepositoryTest {

    @Autowired
    AlienEntityRepository alienEntityRepository;


    @Test
    @Transactional
    public void testRepository(){
        alienEntityRepository.deleteAll();

        alienEntityRepository.save(new AlienEntity(null, "mike", 100, 41));
        alienEntityRepository.save(new AlienEntity(null, "mike", 90, 45));
        alienEntityRepository.save(new AlienEntity(null, "sandra", 80, 37));
        alienEntityRepository.save(new AlienEntity(null, "louise", 60, 100));

        alienEntityRepository.save(new AlienEntity(null, "mike", 50, 25));
        alienEntityRepository.save(new AlienEntity(null, "jens", 80, 35));
        alienEntityRepository.save(new AlienEntity(null, "ole", 70, 29));
        alienEntityRepository.save(new AlienEntity(null, "maria", 65, 75));

//        alienEntityRepository.findByName("mike").forEach(a -> System.out.println(a));

//        alienEntityRepository.findOverweight(70).forEach(a -> System.out.println(a));


        alienEntityRepository.deleteByName("mike");

        Page<AlienEntity> pageOfAliens = alienEntityRepository.findOverweightWithPagination(
                PageRequest.of(1, 3), 10);
        System.out.println("Total elements: " + pageOfAliens.getTotalElements());
        System.out.println("We got: " + pageOfAliens.getPageable().getPageSize());
        pageOfAliens.getContent().forEach(a -> System.out.println(a));




    }
}