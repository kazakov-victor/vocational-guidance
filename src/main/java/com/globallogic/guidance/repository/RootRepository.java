package com.globallogic.guidance.repository;

import com.globallogic.guidance.entity.Root;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RootRepository extends CrudRepository<Root, Long> {
    @Query(value = "SELECT r FROM Root r WHERE r.root_number = ?1")
    Root findNextById(@Param("root_number") Long root_number);
}
