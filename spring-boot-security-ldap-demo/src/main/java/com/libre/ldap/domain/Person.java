package com.libre.ldap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;


/**
 * @author zhao.cheng
 */
@Data
@Entry(objectClasses = {"top","person","organizationalPerson","user"})
public class Person {

    @Id
    @JsonIgnore
    private Name dn;

    @Attribute(name="sAMAccountName")
    private String username;

    @Attribute(name = "displayName")
    private String name;

    private String department;

    private String mail;

    private String telephoneNumber;

    @Attribute(name = "userCertificate")
    private String password;

}
