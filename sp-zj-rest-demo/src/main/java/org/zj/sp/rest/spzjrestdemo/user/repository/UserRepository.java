package org.zj.sp.rest.spzjrestdemo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zj.sp.rest.spzjrestdemo.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {

	
	
}
