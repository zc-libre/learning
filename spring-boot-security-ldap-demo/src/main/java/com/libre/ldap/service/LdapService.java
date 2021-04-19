package com.libre.ldap.service;

import com.libre.ldap.domain.Person;

/**
 * @author zhao.cheng
 * @date 2021/4/16 16:28
 */
public interface LdapService {

    /**
     * 登录认证
     * @param username /
     * @param password /
     * @return /
     */
    boolean ldapAuth(String username, String password);

    /**
     * 通过用户名查找用户
     * @param username /
     * @return /
     */
    Person findByUsername(String username);
}
