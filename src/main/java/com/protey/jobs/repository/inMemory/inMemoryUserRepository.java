package com.protey.jobs.repository.inMemory;

import com.protey.jobs.entity.Role;
import com.protey.jobs.entity.User;
import com.protey.jobs.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
class InMemoryUserRepository extends InMemoryBaseRepository<User> implements UserRepository {

    public void init() {
        map.clear();
        map.put(1, new User(1, "user", "mail", "password", Role.USER));
        map.put(1, new User(2, "user2", "mail2", "password", Role.USER));
    }

    public InMemoryUserRepository() {init();
    }

    @Override
    public List<User> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        return getCollection().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
}