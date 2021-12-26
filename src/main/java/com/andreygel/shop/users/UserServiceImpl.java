package com.andreygel.shop.users;

import com.andreygel.shop.exception.UserExistException;
import com.andreygel.shop.rest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) throws UserExistException {
        if(userRepository.existsByNumber(user.getNumber())) {
            throw new UserExistException("");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setNumber(user.getNumber());
        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public Long getUserId(String number) {
        return userRepository.findUserEntityByNumber(number).getId();
    }
}
