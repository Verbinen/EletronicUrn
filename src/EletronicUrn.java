import java.util.ArrayList;

public class EletronicUrn {
    private int totalVotes;
    private int nullVotes;
    private ArrayList<Candidate> candidateList;

    public EletronicUrn() {
        this.totalVotes = 0;
        this.nullVotes = 0;
        this.candidateList = new ArrayList<>();
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void addTotalVotes() {
        this.totalVotes++;
    }

    public ArrayList<Candidate> getCandidateList() {
        return candidateList;
    }

    public void addCandidateList(Candidate candidate) {
        this.candidateList.add(candidate);
    }

    public void addNullVote(int n){
        if(n != -1)
            this.nullVotes += n;
        else
            this.nullVotes++;
    }

    public int getNullVotes() {
        return nullVotes;
    }

    public float getPercentageVotes(Candidate candidate){
        return ((float)candidate.getVotes() / totalVotes) * 100;
    }

    public void printPercentageVote(Candidate candidate){
        System.out.println("Percentual dos votos: " + (int)getPercentageVotes(candidate) + "%");
    }

    public boolean hasCandidate(String name, int code){
        if(code == -1){
            for (Candidate c: this.candidateList) {
                if(c.getName().equals(name))
                    return true;
            }
            return false;
        }
        for (Candidate c: this.candidateList) {
            if(c.getCode() == code)
                return true;
        }
        return false;
    }

    public void removeCandidate(String name){
        for (Candidate c: this.candidateList) {
            if(c.getName().equals(name)){
                this.candidateList.remove(c);
                return;
            }
        }
    }

    public void addVoteToCandidate(int code){
        for (Candidate c: this.candidateList) {
            if(c.getCode() == code){
                c.addVotes();
                return;
            }
        }
    }

    public float getPercentageNullVotes(){
        return ((float)this.nullVotes / this.totalVotes) * 100;
    }


    public void printNullVotes(){
        System.out.println("Votos nulos: " + (int)getPercentageNullVotes() + "%");
    }

    public void listCandidates(){
        this.candidateList.forEach(c -> c.printCandidate());
    }

    public Candidate getCandidate(String name){
        for (Candidate c: this.candidateList) {
            if(c.getName().equals(name))
                return c;

        }
        return null;
    }


}
