package com.cts.dataservice.controller;

import com.cts.dataservice.model.Event;
import com.cts.dataservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class DataController {

    private DataService dataService;

    @Autowired
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET,  produces = { "application/json" })
    public Page<Event> getEvents(@RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "limit", defaultValue = "30") int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Event> eventPage = dataService.findPaginated(pageable);
        return eventPage;
    }

}
