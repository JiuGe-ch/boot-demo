package cn.jiuyoung.bootdemo;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.jiuyoung.bootdemo.Entity.User;
import cn.jiuyoung.bootdemo.Service.UserRepository;

/**
 * UserRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));
        userRepository.save(new User("fff", 60));
        userRepository.save(new User("ggg", 70));
        userRepository.save(new User("hhh", 80));
        userRepository.save(new User("iii", 90));
        userRepository.save(new User("jjj", 100));

        
        assertEquals(10, userRepository.findAll().size());
        assertEquals(60, userRepository.findByName("fff").getAge().longValue());
        assertEquals(60, userRepository.findUser("fff").getAge().longValue());
        assertEquals("fff", userRepository.findByNameAndAge("fff", 60).getName());
        userRepository.delete(userRepository.findByName("aaa"));
        assertEquals(9, userRepository.findAll().size());
    }
}