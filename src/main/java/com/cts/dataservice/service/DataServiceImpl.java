package com.cts.dataservice.service;

import com.cts.dataservice.model.Event;
import com.cts.dataservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private EventRepository eventRepository;

    @Autowired
    public void setProductRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public Page<Event> findPaginated(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }
}
