package com.cts.dataservice.service;


import com.cts.dataservice.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataService {
    Page<Event> findPaginated(Pageable pageable);
}
