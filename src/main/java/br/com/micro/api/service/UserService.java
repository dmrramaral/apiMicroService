package br.com.micro.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.micro.api.dto.UserDTO;
import br.com.micro.api.model.UserModel;
import br.com.micro.api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        log.error("findAll");
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        log.info("findById: {}", id);
        log.error("User not found with id: {}", id);

        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    }

    public UserModel save(UserDTO userDTO) {
        log.info("save: {}", userDTO);
        UserModel userModel = UserModel.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build();

        return userRepository.save(userModel);
    }

    public UserModel update(Long id, UserDTO userDTO) {
        log.info("update: {}", userDTO);
        UserModel userModel = findById(id);
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());

        return userRepository.save(userModel);
    }

    public UserModel delete(Long id) {
        log.info("delete: {}", id);
        log.error("User not found with id: {}", id);
        UserModel userModel = findById(id);
        userRepository.delete(userModel);
        return userModel;
    }

}
