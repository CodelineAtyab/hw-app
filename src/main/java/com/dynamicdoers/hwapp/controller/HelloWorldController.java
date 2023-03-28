package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Bot;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/hw")
public class HelloWorldController {

    @Operation(summary = "Just GETs a name",
               description = "Gives you a name with Hello, the name can be passed as a query string")
    @GetMapping
    public String handleGetRequest(@Parameter(description = "String name")
                                   @RequestParam(value = "myname", defaultValue = "Mr") String name){
        return "Hello " + name + " !";
    }

    @PostMapping
    public String handlePostRequest() {
        return "This is my response against a POST request!";
    }

    @PutMapping
    public String handlePutRequest() {
        return "This is my response against a PUT request!";
    }

    @DeleteMapping
    public String handleDeleteRequest() {
        return "This is my response against a DELETE request!";
    }
}
