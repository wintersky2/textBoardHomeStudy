package org.example;

import org.example.articleController.ArticleController;
import org.example.memberController.MemberController;

public class App {
    ArticleController articleController;
    MemberController memberController;
    public App() {
        articleController = new ArticleController();
        memberController = new MemberController();
    }

    void run() {
        System.out.println("== 시스템 시작 ==");
        // loginedMember;
        while (true) {
            System.out.printf("명령) ");
            String command = Global.getScanner().nextLine().trim();

            switch (command) {
                case "종료":
                    return;
                case "등록":
                    articleController.resister();
                    break;
                case "목록":
                    articleController.list();
                    break;
                case "삭제":
                    articleController.delete();
                    break;
                case "수정":
                    articleController.modify();
                    break;
                case "회원가입":
                    memberController.createAccount();
                    break;
                case "로그인":
                    memberController.login();
                    break;
                case "로그아웃":
                    memberController.logout();
                    break;
            }
        }
    }
}