package org.codeforall.orange.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/giftee")
public class GifteeController {

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listGiftees() {
        //model.addAttribute("customers", customerToCustomerDto.convert(customerService.list()));
        return "index";
    }

    // addGiftee
    // selectGiftee
    //
}
