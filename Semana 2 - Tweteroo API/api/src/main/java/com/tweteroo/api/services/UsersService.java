package com.tweteroo.api.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UsersRepository;

@Service
public class UsersService {
    final UsersRepository usersRepository;
    UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Optional<UserModel> save(UserDTO dto){
        UserModel user = new UserModel(dto);
        if(usersRepository.existsByUsername(dto.getUsername())){
            return Optional.empty();
        }
        return Optional.of(usersRepository.save(user));
    }
}
