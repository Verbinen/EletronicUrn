public class Candidate {
    private int votes;
    private String affiliation;
    private String name;
    private int code;

    public Candidate(String name, int code, String affiliation) {
        this.votes = 0;
        this.affiliation = affiliation;
        this.name = name;
        this.code = code;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public int addVotes() {
        return votes++;
    }

    public int getCode() {
        return code;
    }

    public void printCandidate(){
        System.out.println("\nNome do candidato: " + getName());
        System.out.println("Número do candidato: " + getCode());
        System.out.println("Partido do candidato: " + getAffiliation());
        System.out.println("Votos: " + getVotes());
    }
}
