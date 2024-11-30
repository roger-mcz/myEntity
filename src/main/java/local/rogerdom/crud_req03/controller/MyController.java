package local.rogerdom.crud_req03.controller;

import jakarta.validation.Valid;
import local.rogerdom.crud_req03.entity.MyEntity;
import local.rogerdom.crud_req03.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mycontroller")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/test")
    public String getTest() {
        return "Teste ok!";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String msg = "Bem vindo!";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "app de ger. de serviços");
        return new ResponseEntity<String>(msg, header, HttpStatus.OK);
    }

    /*
    @GetMapping(value = "/findAll")
    public List<MyEntity> findAllEntity(){
        return myService.findAllEntity();
    }
    */

    @GetMapping("/findAll")
    public List<MyEntity> findAll(){
        return myService.findAll();
    }

    @GetMapping("/findById/{id}")
    public MyEntity findById(@PathVariable Long id){
        return myService.findById(id).getBody();
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody MyEntity myEntity) {
        return myService.create(myEntity);
    }

    @PostMapping("/postAll")
    public ResponseEntity<?> createAll(@Valid @RequestBody List<MyEntity> myEntities) {
        return myService.createAll(myEntities);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody MyEntity myEntity) {
        return myService.update(id, myEntity);
    }

}
