package com.example.demo.service;

import com.example.demo.domain.Staff;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StaffServices {


    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createStaff();
        String stringJson = mapper.writeValueAsString(staff);
        System.out.println("Object to JSON" + stringJson);
        System.out.println("check git hub");

        ObjectMapper mapper1 = new ObjectMapper();
        String jsonInString = "{\"name\":\"mkyong\",\"age\":38,\"position\":[\"Founder\",\"CTO\",\"Writer\"],\"skills\":[\"java\",\"python\",\"node\",\"kotlin\"],\"salary\":{\"2018\":14000,\"2012\":12000,\"2010\":10000}}";
        Staff staff1 = mapper1.readValue(jsonInString, Staff.class);
        System.out.println(staff1.getName());

      //  /Users/henokgebremenfes
        // Java object to JSON file
        mapper.writeValue(new File("Users\\henokgebremenfes\\staff.json"), new Staff());

        String prettyStaff1 = mapper1.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
        System.out.println(prettyStaff1);

    }

    private static Staff createStaff() {

        Staff staff = new Staff();
        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

}
