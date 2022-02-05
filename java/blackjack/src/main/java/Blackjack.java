import java.util.HashMap;
import java.util.Map;

public class Blackjack {
    private static String STAND = "S";
    private static String HIT = "H";
    private static String SPLIT = "P";
    private static String WIN = "W";

    private Map<String, Integer> cards = new HashMap<>();

    {
        cards.put("two", 2);
        cards.put("three", 3);
        cards.put("four", 4);
        cards.put("five", 5);
        cards.put("six", 6);
        cards.put("seven", 7);
        cards.put("eight", 8);
        cards.put("nine", 9);
        cards.put("ten", 10);
        cards.put("jack", 10);
        cards.put("queen", 10);
        cards.put("king", 10);
        cards.put("ace", 11);
    }

    public int parseCard(String card) {
        return cards.getOrDefault(card, 0);
    }

    public boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) {
            return SPLIT;
        }
        if (dealerScore < 10) {
            return WIN;
        }
        return STAND;


    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore <= 11 || (dealerScore >= 7 && handScore < 17)) {
            return HIT;
        }
        return STAND;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
