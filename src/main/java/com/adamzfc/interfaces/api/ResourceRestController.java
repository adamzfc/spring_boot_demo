package com.adamzfc.interfaces.api;

import com.adamzfc.domain.model.Resource;
import com.adamzfc.domain.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adamzfc on 4/8/17.
 */
@RestController
@RequestMapping(value = "/api/resource")
public class ResourceRestController {
    @Autowired
    ResourceRepository resourceRepository;

    public List<Resource> getResources() {
        return resourceRepository.getEnableResources();
    }
}
