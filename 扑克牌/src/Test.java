import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card{
    public String rank;
    public String suit;

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}


public class Test {

    public static List<Card> buyCard(){
        String[] SUIT ={"♥","♠","♦","♣"};
        List<Card> map = new ArrayList<>();
        for(int i=0;i<4;i++){
            for(int j=2;j<=10;j++){
                Card card = new Card();
                card.rank =j+"";
                card.suit = SUIT[i];
                map.add(card);
            }
        }
        for(int k=0;k<4;k++){
            Card card = new Card();
            card.suit=SUIT[k];
            card.rank="J";
            map.add(card);
        }
        for(int k=0;k<4;k++){
            Card card = new Card();
            card.suit=SUIT[k];
            card.rank="Q";
            map.add(card);
        }
        for(int k=0;k<4;k++){
            Card card = new Card();
            card.suit=SUIT[k];
            card.rank="K";
            map.add(card);
        }
        for(int k=0;k<4;k++){
            Card card = new Card();
            card.suit=SUIT[k];
            card.rank="A";
            map.add(card);
        }
        return map;

    }

    public static void main(String[] args) {
        List<Card> list = new ArrayList<>();
        list = buyCard();
        List<List<Card>> people = new ArrayList<>();
        people.add(new ArrayList<>());
        people.add(new ArrayList<>());
        people.add(new ArrayList<>());
        Collections.shuffle(list);
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                people.get(i).add(list.remove(0));
            }
            System.out.println(people.get(i));
        }

    }
}
