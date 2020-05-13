package com.netcracker.fapi.mapper;

import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.entity.UserViewModel;

public class UserMapper {

    public UserViewModel map(User user){
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setName(user.getName());
        userViewModel.setEmail(user.getEmail());
        userViewModel.setId(user.getId());
        userViewModel.setRole(user.getRole());
        return userViewModel;
    }
}
