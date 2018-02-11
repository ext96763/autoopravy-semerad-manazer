package com.autoopravy.semerad.manazer.InternalManager.controller;

import com.autoopravy.semerad.manazer.InternalManager.mapper.ManagerRepository;
import com.autoopravy.semerad.manazer.InternalManager.model.Car;
import com.autoopravy.semerad.manazer.InternalManager.model.Customer;
import com.autoopravy.semerad.manazer.InternalManager.model.Repair;
import com.autoopravy.semerad.manazer.InternalManager.model.SparePart;
import com.wordnik.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

    Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    private ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @ApiOperation(value = "Find all users", notes = "find all users", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Customer> getAllUsers() {
        return managerRepository.getAllCustomers();
    }

    @ApiOperation(value = "Find all cars", notes = "find all cars", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Car> getAllCars() {
        return managerRepository.getAllCars();
    }

    @ApiOperation(value = "Find all repairs", notes = "find all repairs", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/repairs", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Repair> getAllRepairs() {
        return managerRepository.getAllRepairs();
    }

    @ApiOperation(value = "Find all parts", notes = "find all parts", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/parts", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SparePart> getAllParts() {
        return managerRepository.getAllParts();
    }
    //------------------------------------------------------------------------------------------------------------------

    /**
     * User By ID [GET]
     *
     * @return Particular user in JSON
     */
    @ApiOperation(value = "Search user by ID", notes = "Look for user by ID", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User unique ID", value = "userId", required = true, dataType = "int", paramType = "query")

    })
    @CrossOrigin()
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Customer> getUserById(@RequestParam(value = "id", required = true) Integer id) {
        Customer customer = new Customer();
        try {
            customer = managerRepository.getUserById(id);
        } catch (Exception e) {
            logger.error("Cannot find in DB user with ID: " + id);
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("UserFound", "true");
        logger.info("User found ID: " + customer.getUserId());
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @ApiOperation(value = "find user detail by ID", notes = "find user detail by ID", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User unique ID", value = "userId", required = true, dataType = "int", paramType = "query")

    })
    @CrossOrigin()
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Customer> getUserDetailById(@RequestParam(value = "id", required = true) Integer id) {
//        List<Customer> customerDetail = new ArrayList<>();
//        try {
//            customerDetail = managerRepository.getUserDetailById(id);
//        } catch (Exception e) {
//            logger.error("Cannot find in DB user with ID: " + id);
//            return new ResponseEntity<>(customerDetail, HttpStatus.NOT_FOUND);
//        }
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("UserFound", "true");
//        logger.info("User detail found ID: " + id);
//        return new ResponseEntity<Customer>(customerDetail, HttpStatus.FOUND);
        return managerRepository.getUserDetailById(id);
        //TODO rewrite
    }


    /**
     * Inserts new User into DB [POST]
     *
     * @param customer new object
     * @return if success same body
     */
    @SuppressWarnings("Duplicates")
    @ApiOperation(value = "Post new User", notes = "Post new User", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Customer> insertNewUser(@RequestBody Customer customer) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            managerRepository.insertUser(customer);
        } catch (Exception e) {
            logger.error(e);
            if (e instanceof org.springframework.dao.DuplicateKeyException) {
                responseHeaders.set("DuplicatedUser", "true");
            }
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        responseHeaders.set("UserSaved", "true");
        logger.info("New user is saved. User ID: " + customer.getUserId());
        return new ResponseEntity<>(customer, responseHeaders, HttpStatus.CREATED);
    }


    /**
     * Update user information in DB [PUT]
     *
     * @param customer updated Object of user
     * @return if success returns updated body of user
     */
    @ApiOperation(value = "Update User", notes = "Update User", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Customer> updateUser(@RequestBody Customer customer) {
        try {
            managerRepository.updateUser(customer);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("UserUpdated", "true");
        logger.info("User updated. User ID: " + customer.getUserId());
        return new ResponseEntity<>(customer, responseHeaders, HttpStatus.CREATED);
    }


    /**
     * Delete user by ID
     *
     * @param id is obtained from FE
     * @return null
     */
    @ApiOperation(value = "Delete User", notes = "Delete User", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Customer> deleteUser(@RequestParam(value = "id", required = true) Integer id) {
        try {
            managerRepository.deleteUser(id);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("UserDeleted", "true");
        logger.info("User Deleted. User ID: " + id);
        return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
    }


    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    @ApiResponse(code = 1, message = "get particular car", response = Customer.class)
    public List<Car> getCar() {
        return managerRepository.getCar();
    }

    @RequestMapping(value = "/repair", method = RequestMethod.GET)
    @ApiResponse(code = 1, message = "get particular repair", response = Customer.class)
    public List<Repair> getRepair() {
        return managerRepository.getRepair();
    }

    @RequestMapping(value = "/part", method = RequestMethod.GET)
    @ApiResponse(code = 1, message = "get particular part", response = SparePart.class)
    public List<SparePart> getPart() {
        return managerRepository.getPart();
    }
}