package local.rogerdom.crud_req03.service;

import jakarta.validation.Valid;
import local.rogerdom.crud_req03.entity.MyEntity;
import local.rogerdom.crud_req03.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    public MyService() {
    }

    @Autowired
    private MyRepository myRepository;

    public List<MyEntity> findAllEntity(){
        return MyRepository.findAllMock();
    }

    public List<MyEntity> findAll(){
        return myRepository.findAll();
    }

    public ResponseEntity<MyEntity> findById(Long id){
        Optional<MyEntity> myEntityOptional = myRepository.findById(id);
        if (myEntityOptional.isPresent()){
            MyEntity myEntityResult = myEntityOptional.get();
            return ResponseEntity.ok().body(myEntityResult);
        } else{
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<?> create(@Valid @RequestBody MyEntity myEntity) {
            return ResponseEntity.created(null).body(myRepository.save(myEntity));
    }


    public ResponseEntity<?> createAll(@Valid @RequestBody List<MyEntity> myEntities) {
            return ResponseEntity.created(null).body(myRepository.saveAll(myEntities));
    }


    public ResponseEntity<?> update(Long id, MyEntity myEntity){
        Optional<MyEntity> myEntityOptional = myRepository.findById(id);
        if (myEntityOptional.isPresent()){
            MyEntity myEntityUpdate = myEntityOptional.get();
            myEntityUpdate.setName(myEntity.getName());
            myEntityUpdate.setVersion(myEntity.getVersion());
            return ResponseEntity.ok().body(myRepository.save(myEntityUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
