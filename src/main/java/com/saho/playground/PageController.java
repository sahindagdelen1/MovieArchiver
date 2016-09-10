package com.saho.playground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sahin.dagdelen on 7/24/2016.
 */

@Controller
public class PageController {


    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }


    @RequestMapping(value = "/genre",method = RequestMethod.GET)
    public String genreEntry(){
        return "genre";
    }


    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String searchPage(){
        return "searchform";
    }


    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String errorPage(){
        return "error";
    }
}
