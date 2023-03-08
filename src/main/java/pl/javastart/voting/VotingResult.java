package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {

    private static final double MAX_PERCENTAGE = 100;
    private double forVoteCounter;
    private double holdVoteCounter;
    private double againstVoteCounter;
    private List<Vote> voteList = new ArrayList<>();

    public VotingResult(double forVoteCounter, double holdVoteCounter, double againstVoteCounter, List<Vote> voteList) {
        this.forVoteCounter = forVoteCounter;
        this.holdVoteCounter = holdVoteCounter;
        this.againstVoteCounter = againstVoteCounter;
        this.voteList = voteList;
    }

    private double calculatePercentage(double number, double totalVotes) {
        return (number / totalVotes) * MAX_PERCENTAGE;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        double totalVotes = forVoteCounter + againstVoteCounter + holdVoteCounter;
        double forVotePercentage = calculatePercentage(forVoteCounter, totalVotes);
        double againstVotePercentage = calculatePercentage(againstVoteCounter, totalVotes);
        double holdVotePercentage = calculatePercentage(holdVoteCounter, totalVotes);
        System.out.printf("Głosów za: %.2f%%\n", forVotePercentage);
        System.out.printf("Głosów przeciw: %.2f%%\n", againstVotePercentage);
        System.out.printf("Wstrzymało się: %.2f%%\n", holdVotePercentage);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : voteList) {
            if (voterName.equals(vote.getVoter())) {
                System.out.println(vote.getVoter() + ": " + printVote(vote.getVote()));
            }
        }
    }

    private String printVote(String vote) {
        return switch (vote) {
            case Voting.FOR -> "ZA";
            case Voting.AGAINST -> "PRZECIW";
            case Voting.HOLD -> "WSTRZYMAŁ SIĘ";
            default -> "Nieprawidłowy glos";
        };
    }
}
