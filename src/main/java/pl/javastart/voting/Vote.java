package pl.javastart.voting;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private String voter;
    private String vote; // true - ZA, false - PRZECIW, null - wstrzymanie się

    public Vote(String voter, String vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    public String getVote() {
        return vote;
    }
}
