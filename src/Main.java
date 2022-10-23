import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EletronicUrn urn = new EletronicUrn();

        Candidate lula = new Candidate("Lula", 13, "PT");
        Candidate bolsonaro = new Candidate("Bolsonaro", 22, "PL");

        urn.addCandidateList(lula);
        urn.addCandidateList(bolsonaro);

        String choice;
        String name;
        String affiliation;
        Scanner sc = new Scanner(System.in);
        String num;
        int code;
        while(true){

            System.out.println("\n\nEscolha uma opção: \n");
            System.out.println("[0] Sair");
            System.out.println("[1] Adicionar Candidato");
            System.out.println("[2] Listar Candidato");
            System.out.println("[3] Remover Candidato");
            System.out.println("[4] Votar");
            System.out.println("[5] Apuração dos votos\n");
            System.out.print("Escolha: ");

            choice = sc.nextLine();

            switch (choice){
                case "0":
                    System.exit(0);
                    break;

                case "1":
                    System.out.println("\nDigite o nome do candidato: ");
                    name = sc.nextLine();

                    System.out.println("\nDigite o número do partido do candidato: ");
                    num = sc.nextLine();
                    try{
                        code = Integer.parseInt(num);
                    }
                    catch(Exception e){
                        System.out.println("Digite um número válido para o partido");
                        break;
                    }

                    System.out.println("\nDigite o nome do partido do candidato: ");
                    affiliation = sc.nextLine();

                    Candidate newCandidate = new Candidate(name, code, affiliation);
                    if(urn.hasCandidate(newCandidate.getName(), -1)){
                        System.out.println("Candidato já existe");
                        break;
                    }

                    urn.addCandidateList(newCandidate);
                    break;

                case "2":
                    urn.listCandidates();
                    break;

                case "3":
                    System.out.println("Digite o nome do candidato que deseja remover");
                    name = sc.nextLine();

                    if(urn.hasCandidate(name, -1)){
                        Candidate c = urn.getCandidate(name);

                        if(c != null){
                            int votes = c.getVotes();

                            if(votes > 0){
                                urn.addNullVote(votes);
                            }
                        }
                        else{
                            System.out.println("Erro ao deletar o candidato");
                            break;
                        }

                        urn.removeCandidate(name);
                        break;
                    }

                    System.out.println("Candidato não existe");
                    break;

                case "4":
                    System.out.println("\nDigite o número do partido do candidato: ");
                    num = sc.nextLine();

                    try{
                        code = Integer.parseInt(num);
                    }
                    catch(Exception e){
                        System.out.println("Digite um número válido para o partido");
                        break;
                    }

                    if(urn.hasCandidate("", code)){
                        urn.addTotalVotes();
                        urn.addVoteToCandidate(code);
                        break;
                    }

                    System.out.println("Voto Nulo");
                    urn.addNullVote(-1);
                    urn.addTotalVotes();
                    break;

                case "5":
                    System.out.println("\n\nApuração da Urna");

                    System.out.println("Total de votos: " + urn.getTotalVotes());

                    for (Candidate c: urn.getCandidateList()) {
                        c.printCandidate();
                        if(c.getVotes() > 0) urn.printPercentageVote(c);
                        else System.out.println("Percentual dos votos: 0%");
                    }

                    System.out.println("\nNúmero de votos nulos: " + urn.getNullVotes());
                    if(urn.getNullVotes() > 0) urn.printNullVotes();
                    else System.out.println("Percentual dos votos nulos: 0%");

                    break;

                default:
                    System.out.println("\n");
                    break;

            }
        }
    }
}
