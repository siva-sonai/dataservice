package com.cts.dataservice.repository;

import com.cts.dataservice.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = "SELECT u FROM Event u ORDER BY id")
    Page<Event> findAllUsersWithPagination(Pageable pageable);

    @Query(value = "SELECT * FROM Event ORDER BY id", countQuery = "SELECT count(*) FROM Event", nativeQuery = true)
    Page<Event> findAllUsersWithPaginationNative(Pageable pageable);

}
