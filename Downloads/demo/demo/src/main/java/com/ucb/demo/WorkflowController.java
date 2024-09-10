package com.ucb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/work-flow")
public class WorkflowController {

    WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @GetMapping()
    public List list() {
        return workflowService.obtainList();
    }

    @PostMapping()
    public void save(
            @RequestBody WorkflowDto workflowDto
    ) {
        Workflow workflow = new Workflow(
                workflowDto.name(),
                workflowDto.description()
        );
        this.workflowService.create(
                workflow
        );
    }
}