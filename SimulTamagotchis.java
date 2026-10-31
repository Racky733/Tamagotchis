import java.util.Scanner;
import java.util.ArrayList;

public class SimulTamagotchis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrer le nombre de Tamagotchis :");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Tamagotchi> liste = new ArrayList<>();
        for(int i =0; i < n; i++){
            System.out.println("Entrer le nom pour le nouveau Tamagotchi :");
            String nom = sc.nextLine();
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
                System.out.println("GAGNE !!");
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
        System.out.print("Nourrir quel tamagotchi ? ");
        int choix = sc.nextInt();
        liste.get(choix).manger();
    }
        x++;
        }
        
       sc.close();
    }
}
