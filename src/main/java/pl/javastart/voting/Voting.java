package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static final String HOLD = "w";
    public static final String FOR = "z";
    public static final String AGAINST = "p";

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> voteList = new ArrayList<>();
        int counter = 0;
        double forVoteCounter = 0;
        double holdVoteCounter = 0;
        double againstVoteCounter = 0;
        if (voters.size() == 0) {
            System.out.println(" Nikt nie głosował");
        } else {
            do {
                System.out.println("Jak głosuje " + voters.get(counter));
                String vote = scanner.nextLine();
                switch (vote) {
                    case HOLD -> {
                        voteList.add(new Vote(voters.get(counter), vote));
                        holdVoteCounter++;
                        counter++;
                    }
                    case FOR -> {
                        voteList.add(new Vote(voters.get(counter), vote));
                        forVoteCounter++;
                        counter++;
                    }
                    case AGAINST -> {
                        voteList.add(new Vote(voters.get(counter), vote));
                        againstVoteCounter++;
                        counter++;
                    }
                    default -> System.out.println("Nieprawidłowe oddanie głosu");
                }
            } while (counter < voters.size());
        }
        return new VotingResult(forVoteCounter, holdVoteCounter, againstVoteCounter, voteList);
    }
}



