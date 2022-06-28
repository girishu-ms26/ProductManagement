package com.selflearn.productmanagement.controller;

import com.selflearn.productmanagement.model.Admin;
import com.selflearn.productmanagement.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAdmins")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/adminRegister")
    public ResponseEntity adminRegister(@RequestBody Admin newAdmin){
        return adminService.adminRegister(newAdmin);
    }

    @PostMapping("/adminSignin")
    public ResponseEntity adminSignIn(@RequestBody Admin admin){
        return adminService.adminSignIn(admin);
    }
}
