package com.acme.bank.loan.web.resource;

import com.acme.bank.loan.domain.model.ManageLoan;
import com.acme.bank.loan.service.service.ManageLoanService;
import com.acme.bank.loan.web.helper.WebHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(value = "Manage Loan API", tags = {"loans", "manage"})
@RequestMapping(path = "${acme.loan.management.api.url:/api/1.0/loans}")
@RestController
public class ManageLoanResource {

    private final ManageLoanService service;

    @Autowired
    public ManageLoanResource(final ManageLoanService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find managed loans by person ID", httpMethod = "GET", response = ManageLoan.class, responseContainer = "List")
    @GetMapping(params = "personId")
    public ResponseEntity<List<ManageLoan>> find(@RequestParam("personId") UUID personId) {
        return ResponseEntity.ok(service.find(personId));
    }

    @ApiOperation(value = "Find all managed loans", httpMethod = "GET", response = ManageLoan.class, responseContainer = "List")
    @GetMapping
    public ResponseEntity<List<ManageLoan>> find() {
        return ResponseEntity.ok(service.find());
    }

    @ApiOperation(value = "Get managed loan by event ID", httpMethod = "GET", response = ManageLoan.class)
    @GetMapping(path = "/{eventId}")
    public ResponseEntity<ManageLoan> get(@PathVariable("eventId") String eventId) {
        ManageLoan event = service.get(WebHelper.parseUUID(eventId));
        return event != null ? ResponseEntity.ok(event) : ResponseEntity.noContent().build();
    }
}
