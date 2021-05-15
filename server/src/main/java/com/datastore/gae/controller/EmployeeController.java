package com.datastore.gae.controller;

import com.datastore.gae.entity.Employee;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final String PROJECT_ID = "tp4-springboot-datastore";
    private final Datastore datastore;

    public EmployeeController() {
        this.datastore = DatastoreOptions
                .newBuilder()
                .setProjectId(PROJECT_ID)
                .build()
                .getService();;
    }

    @GetMapping()
    public String get() {
        final String kind = "Employee";
        final String name = "employee";

        final Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);
        return datastore.get(taskKey).getString("name");
    }

    @PostMapping
    public void save(@RequestBody Employee employee) {
        employee.setUuid(UUID.randomUUID().toString());

        final String kind = "Employee";
        final String name = "employee";
        final Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);

        final Entity employeeToSave = Entity.newBuilder(taskKey)
                .set("name", employee.getName())
                .set("id", employee.getUuid())
                .build();

        datastore.put(employeeToSave);
    }
}
