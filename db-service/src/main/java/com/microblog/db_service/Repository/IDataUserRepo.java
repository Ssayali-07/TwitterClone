package com.microblog.db_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microblog.db_service.DataModel.DataUser;

@Repository
public interface IDataUserRepo extends JpaRepository<DataUser, Long>{

	DataUser findByEmail(String email);

	DataUser findByUsername(String username);

	Optional<DataUser> findById(Long userId);

	

}
