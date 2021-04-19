package com.libre.ldap;

import cn.hutool.crypto.SecureUtil;
import com.libre.ldap.domain.Person;
import com.libre.ldap.repository.LdapPersonRepository;

import com.libre.ldap.service.LdapServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author zhao.cheng
 * @date 2021/4/16 15:10
 */
@SpringBootTest
public class LdapTests {

    @Autowired
    LdapPersonRepository ldapPersonRepository;

    @Autowired
    LdapServiceImpl ldapService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void auth() {
        boolean res = ldapService.ldapAuth("zhao.cheng", "894659968zc..");
        Assertions.assertTrue(res);
    }

    @Test
    void find() {
        Iterable<Person> personList = ldapPersonRepository.findAll();
         int num = 0;
        for (Person person : personList) {
            num += 1;
            System.out.println(person);
        }
        System.out.println(num);
        Assertions.assertNotNull(personList);
    }

    @Test
    void findOne() {
        Person person = ldapPersonRepository.findPersonByTelephoneNumber("8272");
        System.out.println(person);
        Assertions.assertNotNull(person);
    }

    @Test
    void findByName() {
        Person person = ldapPersonRepository.findPersonByUsername("zhao.cheng");
        System.out.println(person);
        boolean matches = passwordEncoder.matches(person.getPassword(), "894659968zc..");
        System.out.println(matches);

        Assertions.assertNotNull(person);
    }
}
