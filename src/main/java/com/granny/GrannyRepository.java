package com.granny;

import org.springframework.data.repository.CrudRepository;

import com.granny.Granny;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GrannyRepository extends CrudRepository<Granny, Long> {

}
