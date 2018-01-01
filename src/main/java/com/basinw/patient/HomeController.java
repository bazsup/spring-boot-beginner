package com.basinw.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * @Controller annotation used for tell Spring framework use this class for handle HTTP request, response
 *
 * @EnableAutoConfiguration for enabled configuration that Spring-boot provide
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HomeController {

  /*
   * @RequestMapping used for assigned URL pattern
   */
  @RequestMapping("/greeting")
  @ResponseBody
  public String hello() {
    return "{Hello: spring-boot api}";
  }

  @RequestMapping("/")
  String home() {
    // return resource/templates/index.html
    return "index";
  }

  public static void main(String[] args) throws Exception{
    SpringApplication.run(HomeController.class, args);
  }

}
