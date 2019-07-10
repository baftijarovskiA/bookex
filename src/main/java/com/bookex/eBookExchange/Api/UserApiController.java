package com.bookex.eBookExchange.Api;

import com.bookex.eBookExchange.Model.Role;
import com.bookex.eBookExchange.Model.User;
import com.bookex.eBookExchange.Repository.JpaRepository.RoleJpaRepository;
import com.bookex.eBookExchange.Service.Impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private RoleJpaRepository roleJpaRepository;
    private UserServiceImpl userService;

    public UserApiController(UserServiceImpl userService, RoleJpaRepository roleJpaRepository) {
        this.userService = userService;
        this.roleJpaRepository = roleJpaRepository;
    }

    @PostConstruct
    public void CreateRolesAndAdministrator(){
        Role role = null;
        if(roleJpaRepository.count() != 0){
            role = new Role();
            role.setId(1L);
            role.setName("ADMIN");
            roleJpaRepository.save(role);
            role = new Role();
            role.setId(2L);
            role.setName("USER");
            roleJpaRepository.save(role);
        }

    }

    @GetMapping
    public List<User> getAllUsers(){ return userService.getAllUsers(); }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){ return userService.getUserById(id); }

    @RequestMapping("/username/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }

    @PostMapping
    public User addNewUser(@Valid @RequestBody User user){
        return userService.addNewUser(user);
    }
}
