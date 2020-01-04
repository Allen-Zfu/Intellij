package OOD.Game;
import java.util.*;

/* 定义花色  */
public enum Suit {
    club,
    Diamond,
    Heart,
    Spade
}

///* 定义face value   */
//public enum FaceValue {
//    //ACE, TWO, THREE
//
//}

/*  定义卡牌   */
public class Card {
    private final int faceValue; // 1 for A, 11 for J, 12 for Q, 13 for K. Or we can use enum here. // private
    //final FaceValue v;
    private final Suit suit;
    public Card(int facevalue, Suit suit) {
        this.faceValue = facevalue;
        this.suit = suit;
    }

    public int value() {
        return faceValue;
    }

    public Suit suit() {
        return suit;
    }
}

/* 定义荷官 */
public class Deck {
    private static final Random random = new Random();
    private final List<Card> cards = new ArrayList<>();
    private int dealtIndex = 0;  //开始发牌的牌号


    public Deck() {  //添加新牌
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    private int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public Card dealCard() {
        return remainingCards() == 0 ? null : cards.get(dealtIndex++);
    }

    public Card[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        Card[] cards = new Card[number];
        for (int i = 0; i < number; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }
}

/*
面试时候要提到：abstrct 和 extends能提到就尽量提到
但是具体是简化版本实现还是复杂版本的和面试官讨论
 */

 */
*/
 */
/*  定义玩家手牌  */
public class Hand {
    protected final List<Card> cards = new ArrayList<>();

    //核心method，其他都是helper
    public int score() {
        int score = 0;
        for (Card card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }

    public int size() {
        return cards.size();
    }
}

/* backjack玩家手牌 */
public class BlackJackHand extends Hand {
    @Override
    public int score() {    //核心method，面试时候首先写这个，中间用到的其它功能都是helper function
        List<Integer> scores = possibleScores();
        int maxunder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? MINover : maxUnder;
    }

    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card card : cards) {
            updateScores(card, scores);
        }
        return scores;
    }

    private void updateScores(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card);
        if (scores.isEmpty()) {
            for (int score : toAdd) {
                scores.add(score);
            }
        } else {
            final int length = scores.size();
            for (int i = 0; i < length; i++) {
                int oldScore = scores.get(i);
                scores.set(i, oldScore + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
            }
        }
    }

    private int[] getScores(Card card) {
        if (card.value() > 1) {
            return new int[]{Math.min(card.value(), 10)};
        } else {
            return new int[]{1, 11};
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card first = cards.get(0);
        Card second = cards.get(1);
        return (isAce(first) && isFaceCard(second) || (isAce(second) && isFaceCard(first)));
    }

    private static boolean isAce(Card c) {
        return c.value() == 1;
    }

    private static boolean isFaceCard(Card c) {
        return c.value() >= 11 && c.value() <= 13;
    }
}


/* 模拟游戏流程的class，开启游戏的入口
* 先initilize这个class，初始化所有要使用的field，通过核心对外method'simulate'开启整个游戏，其它所有这个class的method
* 都作为simulate的helper function*/
public class BlackJackSimplify {
    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;

    public BlackJackGameSimplify(int numPlayers) {
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    void initializeDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            Card[] cards = deck.dealHand(2);
            if (cards == null) {
                return false;
            }
            hand.addCards(cards);
        }
        return true;
    }

    List<Integer> getBlackJacks() {
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if(hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    boolean playHand(BlacJackHand hand) {
        while (hand.score() < HIT_UNTIL) {
            Card card = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCards(new Card[] { card });
        }
        return true;
    }

    boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> getWinners() {
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand" + i + "(" + hands[i).score() + "):");
            hands[i].print();
            System.out.println();
        }
    }


    //核心method！！！！！
    public void simulate() {
        initializeDeck();

        boolean success = dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("--Initial--");
            printHandsAndScore();
            List<Integer> blackjacks = getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.print("Blackjack at");
                for (int i : blackjacks) {
                    System.out.print(i + " ");
                }
                System.out.println("done")
                ;            } else {
                success = playAllHands();
                if (!success) {
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n -- Completed Game --");
                    printHandsAndScore();
                    List<Integer> winners = getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners:");
                        for (int i : winners) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Draw, All player have busted.");
                    }
                }
            }
        }
    }
}


