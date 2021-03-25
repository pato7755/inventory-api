package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/shoes")
public class GetShoes {

    @Autowired
    ShoeRepository shoeRepository;

    @GetMapping(path = "/get", produces = "application/json", consumes = "application/json")
    public ResponseClass allShoes() {

        ResponseClass response;

        try {

            List<Shoe> shoesList = shoeRepository.findAll();

            System.out.println("shoesList: " + shoesList);

            response = new ResponseClass("100", "Successful", shoesList);

            return response;

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Get shoes exception: " + ex.getMessage());

            response = new ResponseClass("101", "An error occurred");

            System.out.println("response: " + response.toString());

            return response;

        }



//        return new Response(UtilityManager.DEFAULT_SUCCESS_CODE, UtilityManager.DEFAULT_SUCCESS_MESSAGE, msisdn, productList);


    }

}
