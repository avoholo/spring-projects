package com.avokey.orm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avokey.orm.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
