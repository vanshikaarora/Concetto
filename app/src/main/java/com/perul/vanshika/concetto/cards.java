package com.perul.vanshika.concetto;

/**
 * Created by lenovo on 10/13/2018.
 */

public class cards {
    String card,cardtitle,carddate,cardtime,cardabout;
    cards(){}
    cards(String card, String cardtitle, String carddate, String cardtime, String cardabout){
        this.card = card;
        this.cardtitle = cardtitle;
        this.carddate = carddate;
        this.cardtime = cardtime;
        this.cardabout = cardabout;
    }

    public String getCard() {
        return card;
    }

    public String getCardabout() {
        return cardabout;
    }

    public void setCardabout(String cardabout) {
        this.cardabout = cardabout;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCardtitle() {
        return cardtitle;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }

    public String getCarddate() {
        return carddate;
    }

    public void setCarddate(String carddate) {
        this.carddate = carddate;
    }

    public String getCardtime() {
        return cardtime;
    }

    public void setCardtime(String cardtime) {
        this.cardtime = cardtime;
    }
}
