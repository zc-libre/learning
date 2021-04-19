package com.libre.ldap.repository;

import com.libre.ldap.domain.Person;
import org.springframework.data.ldap.repository.LdapRepository;

/**
 * @author zhao.cheng
 * @date 2021/4/16 15:08
 */
public interface LdapPersonRepository extends LdapRepository<Person> {

    /**
     * 通过用户名查询
     * @param username  /
     * @return /
     */
    Person findPersonByUsername(String username);


    /**
     *通过电话号码查询
     * @param number /
     * @return /
     */
    Person findPersonByTelephoneNumber(String number);
}
