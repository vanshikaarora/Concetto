package com.example.vanshika.concetto;

/**
 * Created by lenovo on 9/30/2018.
 */

public class registration_team {
    String teamname;
    String member1,member2,member3,member4;
    String teamleaderemailid;
    registration_team(){}
    registration_team(String Teamname,String Member1,String Member2,String Member3,String Member4,String Teamleaderemailidea ){
        this.member1 = Member1;
        this.member2 = Member2;
        this.member3 = Member3;
        this.member4 = Member4;
        this.teamname = Teamname;
        this.teamleaderemailid = Teamleaderemailidea;


    }

    public String getTeamname() {
        return teamname;
    }

    public String getMember1() {
        return member1;
    }

    public String getMember2() {
        return member2;
    }

    public String getMember3() {
        return member3;
    }

    public String getMember4() {
        return member4;
    }

    public String getTeamleaderemailid() {
        return teamleaderemailid;
    }
}
