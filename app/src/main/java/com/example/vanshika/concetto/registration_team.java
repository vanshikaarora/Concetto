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

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public void setMember3(String member3) {
        this.member3 = member3;
    }

    public void setMember4(String member4) {
        this.member4 = member4;
    }

    public void setTeamleaderemailid(String teamleaderemailid) {
        this.teamleaderemailid = teamleaderemailid;
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
