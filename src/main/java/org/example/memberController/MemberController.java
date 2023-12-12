package org.example.memberController;
import org.example.Global;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberController {
    List<Member> memberList = new ArrayList<>();
    int lastMemberId = 1;

    public MemberController() {
        Member member1 = new Member(1, "user1", "1234", LocalDate.now().toString());
        memberList.add(member1);
        Member member2 = new Member(2, "user2", "1234", LocalDate.now().toString());
        memberList.add(member2);
        Member member3 = new Member(3, "user3", "1234", LocalDate.now().toString());
        memberList.add(member3);
    }

    public void createAccount() {
        String userId;
        String password;
        String passwordConfirm;
        LocalDate now = LocalDate.now();

        while (true) {
            System.out.printf("아이디 : ");
            userId = Global.getScanner().nextLine().trim();
            boolean isDuplcated = false;

            for (Member member : memberList) {
                if (userId.equals(member.getUserId())) {
                    System.out.println("중복 아이디가 존재합니다.");
                    isDuplcated = true;
                }
            }

            // 중복 아이디가 없는 경우
            if (!isDuplcated) {
                break;
            }

        }


        while (true) {
            System.out.printf("비밀번호 : ");
            password = Global.getScanner().nextLine().trim();

            System.out.printf("비밀번호 확인 : ");
            passwordConfirm = Global.getScanner().nextLine().trim();

            if (password.equals(passwordConfirm)) {
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }


        Member member = new Member(lastMemberId, userId, password, now.toString());
        memberList.add(member);
        System.out.println(userId + "님 가입을 환영합니다.");
        lastMemberId++;
    }

    public void login() {
        if (Global.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태입니다.");
            return;
        }

        Member checkedMember = null;

        System.out.printf("아이디 : ");
        String userId = Global.getScanner().nextLine().trim();
        System.out.printf("비밀번호 : ");
        String password = Global.getScanner().nextLine().trim();

        for (Member member : memberList) {
            if (userId.equals(member.getUserId())) {
                checkedMember = member;
                break;
            }
        }

        if (checkedMember == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            return;
        } else if (checkedMember.getPassword().equals(password) == false) {
            System.out.println("비밀번호가 일치 하지 않습니다.");
            return;
        }

        Global.setLoginedMember(checkedMember);

        System.out.println(checkedMember.getUserId() + "님 환영합니다.");
    }

    public void logout() {
        if (Global.getLoginedMember() == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        Global.setLoginedMember(null);
        System.out.println("로그아웃 되었습니다.");
    }
}
