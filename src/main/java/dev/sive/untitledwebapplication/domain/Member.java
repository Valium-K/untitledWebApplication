package dev.sive.untitledwebapplication.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    public static Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member();

        member.setName(name);
        member.setCity(city);
        member.setStreet(street);
        member.setZipcode(zipcode);

        return member;
    }
}
