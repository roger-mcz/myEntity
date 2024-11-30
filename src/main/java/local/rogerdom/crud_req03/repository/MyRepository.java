package local.rogerdom.crud_req03.repository;

import local.rogerdom.crud_req03.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
    public static List<MyEntity> findAllEpicoMock() {
        return null;
    }

    public static List<MyEntity> findAllMock() {
        MyEntity entity1 = new MyEntity(1L, "Nome 01","1.0");
        MyEntity entity2 = new MyEntity(2L, "Nome 02","1.1");
        List<MyEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        return entities;
    }

    /*
    public static MyEntity create(MyEntity myEntity) {
        System.out.println(myEntity);
        return myEntity;
    }
     */


}
