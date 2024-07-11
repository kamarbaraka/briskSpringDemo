package com.kahindi.briskspringdemo.user_mngmt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService{

    private final UserEntityRepository repository;


    @Override
    public void createUser(UserDetails user) {

        UserEntity userEntity = UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        repository.save(userEntity);

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findById(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
    }
}
