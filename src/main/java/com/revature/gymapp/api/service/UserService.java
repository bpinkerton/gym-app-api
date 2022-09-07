package com.revature.gymapp.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gymapp.api.dto.UserDto;
import com.revature.gymapp.api.model.User;
import com.revature.gymapp.api.repository.UserRepository;
import com.revature.gymapp.api.dto.security.AuthenticationRequest;
import com.revature.gymapp.api.dto.security.RegistrationRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserService(UserRepository userRepository, ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    public UserDto registerUser(RegistrationRequest registrationRequest){
        User user = userRepository.save(objectMapper.convertValue(registrationRequest, User.class));
        return objectMapper.convertValue(user, UserDto.class);
    }

    public UserDto findUserById(Long id){
        return objectMapper.convertValue(userRepository.findById(id).orElseThrow(RuntimeException::new), UserDto.class);
    }

    public List<UserDto> findAllUsers(){
        return objectMapper.convertValue(userRepository.findAll(), new TypeReference<List<UserDto>>(){});
    }

    public UserDto createUser(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        return objectMapper.convertValue(userRepository.save(user), UserDto.class);
    }

    public UserDto replaceUserById(UserDto userDto, Long id){
        User dbUser = objectMapper.convertValue(userDto, User.class);
        dbUser.setId(id);
        return objectMapper.convertValue(userRepository.save(dbUser), UserDto.class);
    }

    public UserDto updateUserById(UserDto userDto, Long id){
        User dbUser = userRepository.findById(id).orElseThrow(RuntimeException::new);

        if(userDto.getUsername() != null) dbUser.setUsername(userDto.getUsername());
        if(userDto.getFirstName() != null) dbUser.setFirstName(userDto.getFirstName());
        if(userDto.getLastName() != null) dbUser.setLastName(userDto.getLastName());
        if(userDto.getHeight() != null) dbUser.setHeight(userDto.getHeight());
        if(userDto.getWeight() != null) dbUser.setWeight(userDto.getWeight());
        if(userDto.getAge() != null) dbUser.setAge(userDto.getAge());
        if(userDto.getGender() != null) dbUser.setGender(userDto.getGender());
        if(userDto.getBio() != null) dbUser.setBio(userDto.getBio());

        return objectMapper.convertValue(userRepository.save(dbUser), UserDto.class);
    }

    public UserDto login(AuthenticationRequest authenticationRequest) {
        User dbUser = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(RuntimeException::new);
        if(!dbUser.getPassword().equals(authenticationRequest.getPassword())) throw new RuntimeException();

        return objectMapper.convertValue(dbUser, UserDto.class);
    }
}
