package com.ohgiraffers.member.controller;

import com.ohgiraffers.member.model.vo.Member;

import java.util.ArrayList;

public class MemberRepository {
    private ArrayList<Member> memberList = new ArrayList<>();
    private static final int MAX_MEMBERS = 10;

    public void insertMember(Member m) {
        if (memberList.size() >= MAX_MEMBERS) {
            throw new OverMemberException("Member List is full");
        }
        memberList.add(m);
    }

    public void printData() {
        for (Member member : memberList) {
            System.out.printf("%s 등급 회원 %s의 포인트는 %d이고, 이자 포인트는 %.1f입니다.%n",
                    member.getGrade(), member.getName(), member.getPoint(), member.calculateInterest());
        }
    }

    public void printBuyInfo(int price) {
        for (Member member : memberList) {
            int discountedPrice = member.buy(price);
            System.out.printf("%s 등급 회원 %s는 %d원 상품을 %d원에 구매합니다.%n",
                    member.getGrade(), member.getName(), price, discountedPrice);
        }
    }
}

