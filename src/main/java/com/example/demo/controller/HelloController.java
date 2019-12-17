package com.example.demo.controller;

import com.example.demo.domain.Staff;
import com.example.demo.service.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hello")
public class HelloController {
      @Autowired
      private StaffServices staffServices;

        @RequestMapping("/world")
        public String GetHello(){
            return "Hello world";
        }

        @RequestMapping("/{age}")
        public List<Staff> getStaff(@PathVariable("age") int age ){
            List<Staff> staffs = staffServices.createStaffList(age);
            return staffs;
        }

        @RequestMapping("/{age}/{name}")
        public List<Staff> getStaffs(@PathVariable("age") int age, @PathVariable("name")String name ){

            List<Staff> staffs = staffServices.createStaffListTwo(age,name);
            return staffs;
        }
    }

