package com.training.platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import java.util.List;

import com.training.platform.entities.User;

import java.util.Optional;

import java.util.*;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private UserService userService;
    @GetMapping(value = "")
    public List<User> index() {
// Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }
   /*@GetMapping(value = "")
    public String index() {
        List<User> users = userRepository.findAll();
        System.out.println("############### Find All User (In Console) ###############");
        System.out.println(users);
        return "Method GET, Function : index => SHOW data list on page";
    }*/
    //@GetMapping(value = "")
    //public List<User> index() {
       // List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
       // return users;
    //}
   //@GetMapping(value = "")
   //public List<User> index() {
      // List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 22) );
       //List<User> users = userRepository.findByAgeIn(ages);
      // return users;
   //}

    /*@GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console) ###############");
        System.out.println(user);

        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }*/
    // Example for findAllByQuery
    /*@GetMapping(value = "/Query")
    public List<User> test1() {
        return userRepository.findAllByQuery();
    //}
    // Example for findAllByParamsQuery
    /*@GetMapping(value = "/ParamsQuery")
    //public List<User> test2() {
        return userRepository.findAllByParamsQuery(0, "nakornpathom");
    }

    // Example for findAllByJpqlQuery
    @GetMapping(value = "/JpqlQuery")
    public List<User> test3() {
        return userRepository.findAllByJpqlQuery();
    }

    // Example for findAllByJpqlParamsQuery
    @GetMapping(value = "/JpqlParamsQuery")
    public List<User> test4() {
        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
    }*/
    //get city
    @GetMapping(value = "/{city}")
    public List<User> getCity(@PathVariable String city) {
        return userService.findAllByParamsQuery(0, city);
    }
    //find active=1&city=bangkok
    @GetMapping(value = "/findAllByParamsQuery") // findAllByParamsQuery?active=1&city=bangkok
    public List<User> findAllByParamsQuery(@RequestParam int active, @RequestParam String city) {
        return userService.findAllByParamsQuery(active, city);
    }

    //find age
    @GetMapping(value = "/findByAgeIn") // findByAgeIn?age=11,18,20
    public List<User>  findByAgeIn(@RequestParam(name = "age")List<Integer> listAge) {
        return userService.findByAgeIn(listAge);
    }
    //update
    @GetMapping(value = "/updateHomeByAge") // updateHomeByAge?age=11
    public List<User>  updateHomeByAge(@RequestParam(name = "age")List<Integer> listAge) {
        return userService.updateHomeByAge(listAge);
    }
    //find id
    @GetMapping(value = "/findById") // findById?id=1
    public List<User>  findIdByJpqlParamsQuery(@RequestParam(name = "id")Integer ids) {
        return userService.findIdByJpqlParamsQuery(ids);
    }
    //find name
    @GetMapping(value = "/findByName") // findByName?name=user9
    public List<User>  findNameInUser(@RequestParam(name = "name")String names) {
        return userService.findNameInUser(names);
    }

    /*

CONTINUE 100
SWITCHING_PROTOCOLS 101
PROCESSING 102
CHECKPOINT 103
OK 200
CREATED 201
ACCEPTED 202
NON_AUTHORITATIVE_INFORMATION 203
NO_CONTENT 204
RESET_CONTENT 205
PARTIAL_CONTENT 206
MULTI_STATUS 207
ALREADY_REPORTED 208
IM_USED 226
MULTIPLE_CHOICES 300
MOVED_PERMANENTLY 301
FOUND 302
MOVED_TEMPORARILY 302
SEE_OTHER 303
NOT_MODIFIED 304
USE_PROXY 305
TEMPORARY_REDIRECT 307
PERMANENT_REDIRECT 308
BAD_REQUEST 400
UNAUTHORIZED 401
PAYMENT_REQUIRED 402
FORBIDDEN 403
NOT_FOUND 404
METHOD_NOT_ALLOWED 405
NOT_ACCEPTABLE 406
PROXY_AUTHENTICATION_REQUIRED 407
REQUEST_TIMEOUT 408
CONFLICT 409
GONE 410
LENGTH_REQUIRED 411
PRECONDITION_FAILED 412
PAYLOAD_TOO_LARGE 413
REQUEST_ENTITY_TOO_LARGE 413
URI_TOO_LONG 414
REQUEST_URI_TOO_LONG 414
UNSUPPORTED_MEDIA_TYPE 415
REQUESTED_RANGE_NOT_SATISFIABLE 416
EXPECTATION_FAILED 417
I_AM_A_TEAPOT 418
INSUFFICIENT_SPACE_ON_RESOURCE 419
METHOD_FAILURE 420
DESTINATION_LOCKED 421
UNPROCESSABLE_ENTITY 422
LOCKED 423
FAILED_DEPENDENCY 424
TOO_EARLY 425
UPGRADE_REQUIRED 426
PRECONDITION_REQUIRED 428
TOO_MANY_REQUESTS 429
REQUEST_HEADER_FIELDS_TOO_LARGE 431
UNAVAILABLE_FOR_LEGAL_REASONS 451
INTERNAL_SERVER_ERROR 500
NOT_IMPLEMENTED 501
BAD_GATEWAY 502
SERVICE_UNAVAILABLE 503
GATEWAY_TIMEOUT 504
HTTP_VERSION_NOT_SUPPORTED 505
VARIANT_ALSO_NEGOTIATES 506
INSUFFICIENT_STORAGE 507
LOOP_DETECTED 508
BANDWIDTH_LIMIT_EXCEEDED 509
NOT_EXTENDED 510
NETWORK_AUTHENTICATION_REQUIRED 511
*/

    /*@PostMapping(value = "")
    public String create(@RequestBody Map<String,Object> inputs) {
        System.out.println("########### POST Param ###########");
        System.out.println(inputs);

        return "Method POST, Function : create => INSERT data to DB";
    }

    @PatchMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String,String> inputs) {
        System.out.println("########### PATCH Param ###########");
        System.out.println(inputs);

        return "Method PATCH, Function : update => ID : " + id + " UPDATE data to DB";
    }

    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id)  {
        return "Method DELETE, Function : delete, ID : " + id + " => DELETE data to DB";
    }

    @RequestMapping(value = "/healthcheck")
    public String healthCheck() {
        return "Hello World!";
    }*/

}


