package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {

    /*@RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World ~");
        return "Hello World ~";
    }

    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return addr;
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr1 = new Address();
        addr1.setProvince("广东");
        addr1.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("四川");
        addr2.setCity("成都");

        list.add(addr1);
        list.add(addr2);

        return list;
    }*/

    @RequestMapping("/hello")
    public Result hello() {
        System.out.println("Hello World ~");
        return Result.success("Hello World ~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();

        Address addr1 = new Address();
        addr1.setProvince("广东");
        addr1.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("四川");
        addr2.setCity("成都");

        list.add(addr1);
        list.add(addr2);

        return Result.success(list);
    }
}
