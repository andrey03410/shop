package com.andreygel.shop.users;

import com.andreygel.shop.exception.UserExistException;
import com.andreygel.shop.rest.dto.User;

public interface UserService {
   void addUser(User user) throws UserExistException;
   Long getUserId(String number);
}
