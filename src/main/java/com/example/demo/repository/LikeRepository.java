package com.example.demo.repository;

import com.example.demo.entity.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {
    @Query("SELECT EXISTS(SELECT m FROM Like m WHERE m.fromPet.id= :petToId AND m.toPet.id= :petFromId AND m.likeValue= true)")
    Boolean isMatch(Long petFromId, Long petToId);

}
