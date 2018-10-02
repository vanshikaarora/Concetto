package com.example.vanshika.concetto.Models;

/**
 * Created by lenovo on 10/2/2018.
 */

public class registername {
    String teamname;
    String member1,member2,member3;
    String teamleaderemailid;
    String mobile;

    registername(){}
    registername(String Teamname,String Member1,String Member2,String Member3,String mobile,String Teamleaderemailidea ){
        this.member1 = Member1;
        this.member2 = Member2;
        this.member3 = Member3;
        this.mobile = mobile;
        this.teamname = Teamname;
        this.teamleaderemailid = Teamleaderemailidea;


    }




    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
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



    public String getTeamleaderemailid() {
        return teamleaderemailid;
    }
}
