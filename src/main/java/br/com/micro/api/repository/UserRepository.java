package br.com.micro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.micro.api.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
