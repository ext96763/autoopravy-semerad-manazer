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
    public @ResponseBody
    List<Customer> getAllUsers() {
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
    public @ResponseBody
    List<Car> getAllCars() {
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
    public @ResponseBody
    List<Repair> getAllRepairs() {
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
    public @ResponseBody
    List<SparePart> getAllParts() {
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
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            customer = managerRepository.getUserById(id);
        } catch (Exception e) {
            logger.error("Cannot find in DB user with ID: " + id);
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }
        if (customer == null) {
            logger.error("No matches in DB for userId: " + id + " wasn't found");
            responseHeaders.set("UserFound", "false");
            return new ResponseEntity<>(customer, responseHeaders, HttpStatus.NOT_FOUND);
        } else {
            responseHeaders.set("UserFound", "true");
            logger.info("User found ID: " + id);
        }
        return new ResponseEntity<>(customer, responseHeaders, HttpStatus.FOUND);
    }

    /**
     * User DETAIL By ID [GET]
     *
     * @param id unique user ID
     * @return Particular user in JSON
     */
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
    ResponseEntity<List<Customer>> getUserDetailById(@RequestParam(value = "id", required = true) Integer id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        List<Customer> customerDetail = new ArrayList<>();
        try {
            customerDetail = managerRepository.getUserDetailById(id);
        } catch (Exception e) {
            logger.error("Cannot find in DB user with ID: " + id);
            responseHeaders.set("UserFound", "false");
            return new ResponseEntity<>(customerDetail, responseHeaders, HttpStatus.NOT_FOUND);
        }
        if (customerDetail == null || customerDetail.size() <= 0) {
            logger.error("No matches in DB for userId: " + id + " wasn't found");
            responseHeaders.set("UserDetailFound", "false");
            return new ResponseEntity<>(customerDetail, responseHeaders, HttpStatus.NOT_FOUND);
        } else {
            responseHeaders.set("UserDetailFound", "true");
            logger.info("UserDetail found ID: " + id);
        }
        return new ResponseEntity<>(customerDetail, responseHeaders, HttpStatus.FOUND);
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


    //----------------------------------------CAR endpoints-------------------------------------------------------------

    /**
     * Car By ID [GET]
     *
     * @return Particular car in JSON
     */
    @ApiOperation(value = "Search car by ID", notes = "Look for car by ID", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Car unique ID", value = "userId", required = true, dataType = "int", paramType = "query")

    })
    @CrossOrigin()
    @RequestMapping(value = "/car", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Car> getCarById(@RequestParam(value = "id", required = true) Integer id) {
        Car car = new Car();
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            car = managerRepository.getCarById(id);
        } catch (Exception e) {
            logger.error("Cannot find in DB car with ID: " + id);
            return new ResponseEntity<>(car, HttpStatus.NOT_FOUND);
        }
        if (car == null) {
            logger.error("No matches in DB for carId " + id + " wasn't found");
            responseHeaders.set("CarFound", "false");
            return new ResponseEntity<>(car, responseHeaders, HttpStatus.NOT_FOUND);
        } else {
            responseHeaders.set("CarFound", "true");
            logger.info("Car found ID: " + id);
        }
        return new ResponseEntity<>(car, responseHeaders, HttpStatus.FOUND);
    }

    /**
     * Car DETAIL By ID [GET]
     *
     * @param id unique car ID
     * @return Particular car in JSON
     */
    @ApiOperation(value = "find car detail by ID", notes = "find car detail by ID", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Car unique ID", value = "carId", required = true, dataType = "int", paramType = "query")

    })
    @CrossOrigin()
    @RequestMapping(value = "/car/detail", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<Car>> getCarDetailById(@RequestParam(value = "id", required = true) Integer id) {
        List<Car> carDetail = new ArrayList<>();
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            carDetail = managerRepository.getCarDetailById(id);
        } catch (Exception e) {
            logger.error("Cannot find in DB car with ID: " + id);
            responseHeaders.set("CarDetailFound", "false");
            return new ResponseEntity<>(carDetail, responseHeaders, HttpStatus.NOT_FOUND);
        }
        if (carDetail == null || carDetail.size() <= 0) {
            logger.error("No matches in DB for carId: " + id + " wasn't found");
            responseHeaders.set("CarDetailFound", "false");
            return new ResponseEntity<>(carDetail, responseHeaders, HttpStatus.NOT_FOUND);
        } else {
            responseHeaders.set("CarDetailFound", "true");
            logger.info("CarDetail found ID: " + id);
        }
        return new ResponseEntity<>(carDetail, responseHeaders, HttpStatus.FOUND);
    }

    /**
     * Inserts new Car into DB [POST]
     *
     * @param car new object
     * @return if success same body
     */
    @SuppressWarnings("Duplicates")
    @ApiOperation(value = "Post new Car", notes = "Post new Car", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/car", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Car> insertNewCar(@RequestBody Car car) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            managerRepository.insertCar(car);
        } catch (Exception e) {
            logger.error(e);
            if (e instanceof org.springframework.dao.DuplicateKeyException) {
                responseHeaders.set("CarSaved", "false");
                responseHeaders.set("DuplicatedCar", "true");
            }
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        responseHeaders.set("CarSaved", "true");
        logger.info("New car is saved. Car ID: " + car.getCarId());
        return new ResponseEntity<>(car, responseHeaders, HttpStatus.CREATED);
    }

    /**
     * Update car information in DB [PUT]
     *
     * @param car updated Object of car
     * @return if success returns updated body of car
     */
    @ApiOperation(value = "Update Car", notes = "Update Car", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/car", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Car> updateCar(@RequestBody Car car) {
        try {
            managerRepository.updateCar(car);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("CarUpdated", "true");
        logger.info("Car updated. Car ID: " + car.getCarId());
        return new ResponseEntity<>(car, responseHeaders, HttpStatus.CREATED);
    }

    /**
     * Delete car by ID
     *
     * @param id is obtained from FE
     * @return null
     */
    @ApiOperation(value = "Delete Car", notes = "Delete Car", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ManagerController.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @CrossOrigin()
    @RequestMapping(value = "/car", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Car> deleteCar(@RequestParam(value = "id", required = true) Integer id) {
        try {
            managerRepository.deleteCar(id);
        } catch (Exception e) {
            logger.error(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("CarDeleted", "true");
        logger.info("Car Deleted. Car ID: " + id);
        return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
    }

    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/repair", method = RequestMethod.GET)
    @ApiResponse(code = 1, message = "get particular repair", response = Customer.class)
    public List<Repair> getRepair() {
        return null;
    }

    @RequestMapping(value = "/part", method = RequestMethod.GET)
    @ApiResponse(code = 1, message = "get particular part", response = SparePart.class)
    public List<SparePart> getPart() {
        return null;
    }
}