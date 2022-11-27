package com.group_22235.services_management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// Tests the generic JPA methods used across all classes. 
// More specific methods will be tested in the service class tests.

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JPAUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TrainRepository repository;

    @Test
    void should_store_a_train() {
        Train train = repository.save(new Train());

        assertThat(train).hasFieldOrPropertyWithValue("numCarriages", 8);
    }

    @Test
    void should_find_all_trains(){
        Train train = new Train();
        entityManager.persist(train);

        Train train2 = new Train();
        entityManager.persist(train2);

        assertThat(repository.findAll()).contains(train, train2);
    }

    @Test
    void should_find_train_by_id(){
        Train train = new Train();
        entityManager.persist(train);

        Train train2 = new Train();
        entityManager.persist(train2);

        Optional<Train> actual_train = repository.findById(train2.getId());
        assertThat(actual_train).contains(train2);
    }

    @Test
    void should_return_null_for_search_by_id_empty_entity(){
        Train train = new Train();
        assertTrue(repository.findById(train.getId()).isEmpty());
    }

    @Test
    void should_update_train(){
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        Train train = new Train();
        entityManager.persist(train);

        Train original_train = repository.findById(train.getId()).get();
        original_train.assignCar(cFactoryService.createCarriage("STORAGE"));

        repository.save(original_train);
        
        Train testTrain = repository.findById(train.getId()).get();
        assertTrue(testTrain.hasStorageCar());
    }

    @Test
    void should_delete_train(){
        Train train = new Train();
        entityManager.persist(train);

        repository.delete(train);
        
        assertTrue(repository.findById(train.getId()).isEmpty());
    }

    @Test
    void should_delete_train_by_id(){
        Train train = new Train();
        entityManager.persist(train);

        repository.deleteById(train.getId());
        
        assertTrue(repository.findById(train.getId()).isEmpty());
    }


}