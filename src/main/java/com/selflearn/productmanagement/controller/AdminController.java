package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Admin;
import com.selflearn.productmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity adminRegister(@RequestBody Admin newAdmin){
        return adminService.adminRegister(newAdmin);
    }

    @PostMapping
    public ResponseEntity adminSignIn(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(HttpStatus.ACCEPTED);
    }
}
