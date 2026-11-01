import java.util.Scanner;
import java.util.ArrayList;
public class SimulTamagotchis {

    public static int lireEntier(Scanner sc) {
    while (!sc.hasNextInt()) {
        System.out.println("Ce n'est pas un nombre, réessaie !");
        sc.next();
    }
    return sc.nextInt();
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.print("Entrer le nombre de Tamagotchis :");
            n = lireEntier(sc);
            sc.nextLine();
            if(n <= 0)
                System.out.println("Entrez un nombre superieur a 0 !");

        }while(n <= 0);

        ArrayList<Tamagotchi> liste = new ArrayList<>();
        for(int i =0; i < n; i++){
            String nom;
            boolean nomValide;
            do{
                nomValide = true;

                System.out.print("Quel nom pour le nouveau tamagotchi :");
                
                nom = sc.nextLine();
                
                if (nom.trim().isEmpty()) {
                    nomValide = false;
                }
                if (!nom.isEmpty()) {
                    if (Character.isDigit(nom.charAt(0))) {
                        nomValide = false;
                    }
                }
                if (!nomValide){
                    System.out.println("Entrer une chaine de caractere !");
                }
            }while(!nomValide);
            Tamagotchi T1 = new Tamagotchi(nom);
            liste.add(T1);
        }

        int x = 1;
        boolean fini = false;

        while(!fini){
            System.out.printf("------- Cycle no %d -------%n",x);

            for (Tamagotchi t : liste){
                if(!t.vivre()){
                    fini = true;
                    System.out.println("PERDU!!");
                    break;
                }
           }

        if(!fini){
            boolean tousGagnes = true;
            for(Tamagotchi t : liste){
                if(!t.ageLimite()){
                    tousGagnes = false;
                }
            }
            if(tousGagnes){
                System.out.println("GAGNÉ !!");
                fini = true;
            }
        }
           
        if(!fini){
            for(int i = 0; i < liste.size(); i++){
                if(!liste.get(i).ageLimite()){
                    System.out.print("(" + i + ") " + liste.get(i).getNom() + " ");
                }
            }
        System.out.println();
        int choix;
        do{
            System.out.print("Nourrir quel tamagotchi ? ");
            choix = lireEntier(sc);
            if(choix < 0 || choix >= liste.size() || liste.get(choix).ageLimite()){
                System.out.println("Numero de Tamgotchi invalide !");
            }else if (liste.get(choix).ageLimite()) {
                System.out.println(liste.get(choix).getNom() + " a déjà gagné !");
            }

        }while(choix < 0 || choix >= liste.size() || liste.get(choix).ageLimite());
        liste.get(choix).manger();
    }
        x++;
        }
        
       sc.close();
    }
}

