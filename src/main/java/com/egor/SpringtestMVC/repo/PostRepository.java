package com.egor.SpringtestMVC.repo;

import com.egor.SpringtestMVC.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface PostRepository extends CrudRepository<Post, Long> {

}
