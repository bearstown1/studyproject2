package com.studyproject.service.impl;

import com.studyproject.dto.UserDTO;
import com.studyproject.jpa.entity.LoginEntity;
import com.studyproject.jpa.repository.LoginRepository;
import com.studyproject.service.LoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("defaultLoginService")
public class DefaultLoginService implements LoginService {
    @Autowired
    public LoginRepository loginRepository;

    @Override
    public String login(UserDTO user) {
        Optional<LoginEntity> Entity = loginRepository.findById(user.getId());
        LoginEntity loginEntity = Entity.get();

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(loginEntity, UserDTO.class);

        if (user.getId().equals(userDTO.getId()) && user.getPassword().equals(userDTO.getPassword())) {
            return userDTO.getId();
        }
        return "false";
    }
}
