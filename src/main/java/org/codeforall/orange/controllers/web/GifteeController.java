package org.codeforall.orange.controllers.web;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.converters.GifteeToGifteeDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.services.GifteeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/giftee")
public class GifteeController {

    private GifteeService gifteeService;
    private GifteeToGifteeDto gifteeToGifteeDto;

    /**
     * Render a view with a list of Giftees :)
     * @return the view to render :P
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listGiftees() {
        //model.addAttribute("customers", customerToCustomerDto.convert(customerService.list()));
        return "index";
    }

    /**
     * Add a Giftee :) STILL WORKING ON IT
     * @return the view to render :P
     */
    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addGiftee(Model model) {

        return "add-update";
    }

    /**
     * Select a Giftee :) STILL WORKING ON IT
     * @return the view to render :P
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String selectGiftee(@PathVariable Integer id, Model model){
        Giftee giftee = gifteeService.get(id);
        GifteeDto gifteeDto = gifteeToGifteeDto.convert(giftee);
        return "profile";
    }
}
