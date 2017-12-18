package com.acme.bank.loan.management.web.resource;

import com.acme.bank.loan.management.domain.model.ManageLoan;
import com.acme.bank.loan.management.service.service.ManageLoanService;
import com.acme.bank.loan.management.web.helper.WebHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Manage Loan API", tags = {"loans", "manage"})
@RequestMapping(path = "${acme.loan.registration.api.url:/api/1.0/loans}")
@RestController
public class ManageLoanResource {

    private final ManageLoanService service;

    @Autowired
    public ManageLoanResource(final ManageLoanService service) {
        this.service = service;
    }

    @ApiOperation(value = "Find managed loans by personal ID", httpMethod = "GET", response = ManageLoan.class, responseContainer = "List")
    @GetMapping(params = "personalId")
    public ResponseEntity<List<ManageLoan>> find(@RequestParam("personalId") String personalId) {
        return ResponseEntity.ok(service.find(personalId));
    }

    @ApiOperation(value = "Find all managed loans", httpMethod = "GET", response = ManageLoan.class, responseContainer = "List")
    @GetMapping
    public ResponseEntity<List<ManageLoan>> find() {
        return ResponseEntity.ok(service.find());
    }

    @ApiOperation(value = "Get managed loan by UUID", httpMethod = "GET", response = ManageLoan.class)
    @GetMapping(path = "/{uuid}")
    public ResponseEntity<ManageLoan> get(@PathVariable("uuid") String uuid) {
        ManageLoan event = service.get(WebHelper.parseUUID(uuid));
        return event != null ? ResponseEntity.ok(event) : ResponseEntity.noContent().build();
    }
}
