package com.init.products.rest;

import java.util.List;
import java.util.Optional;
import com.init.products.dao.RolesDAO;
import com.init.products.entitys.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class RolesREST {

    @Autowired
    private RolesDAO rolesDAO;

    @GetMapping
    public ResponseEntity<List<Roles>> getRoles(){
        List<Roles> roles = rolesDAO.findAll();
        return ResponseEntity.ok(roles);
    }

    @RequestMapping(value="{rolesId}")// /roles/{rolesId} -> /roles/1
    public ResponseEntity<Roles> getRolesById(@PathVariable("rolesId") Long rolesId){
        Optional<Roles> optionalRoles= rolesDAO.findById(rolesId);
        if(optionalRoles.isPresent()){
            return ResponseEntity.ok(optionalRoles.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //Insertar a la base de datos
    @PostMapping // /roles (POST)
    public ResponseEntity<Roles> createRoles(@RequestBody Roles roles){
        Roles newRoles = rolesDAO.save(roles);
        return ResponseEntity.ok(newRoles);
    }

    @DeleteMapping(value="{rolesId}") // /members(DELETE)
    public ResponseEntity<Void> deleteRoles(@PathVariable("rolesId") Long rolesId){
        rolesDAO.deleteById(rolesId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Roles> updateRoles(@RequestBody Roles roles){
        Optional<Roles> optionalRoles= rolesDAO.findById(roles.getId());
        if(optionalRoles.isPresent()) {
            Roles updateRoles = optionalRoles.get();
            updateRoles.setName(roles.getName());
            rolesDAO.save(updateRoles);
            return ResponseEntity.ok(updateRoles);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}