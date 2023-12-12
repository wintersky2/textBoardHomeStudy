package org.example.memberController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Member {
    private int id;
    private String userId;
    private String password;
    private String regDate;
}