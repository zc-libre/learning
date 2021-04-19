package com.libre.ldap.service;

import com.libre.ldap.domain.Person;
import com.libre.ldap.repository.LdapPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

/**
 * @author zhao.cheng
 * @date 2021/4/16 16:21
 */
@Service
@RequiredArgsConstructor
public class LdapServiceImpl implements LdapService {

    private final LdapTemplate ldapTemplate;
    private final LdapPersonRepository ldapPersonRepository;


    @Override
    public boolean ldapAuth(String username, String passWord) {
        EqualsFilter filter = new EqualsFilter("sAMAccountName",username);
        return ldapTemplate.authenticate("",filter.toString(), passWord);
    }

    @Override
    public Person findByUsername(String username) {
        return ldapPersonRepository.findPersonByUsername(username);
    }
}
