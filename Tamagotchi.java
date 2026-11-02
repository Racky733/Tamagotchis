import java.util.Random;


public class Tamagotchi {

    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    Random rand = new Random();

    public Tamagotchi(String nom){
        this.age = 0;
        this.dureeDeVie = rand.nextInt(9,15);
        this.maxEnergie = rand.nextInt(5,10);
        this.energie = rand.nextInt(3,maxEnergie+1);
        this.nom = nom;
    }

    public void parler(){
        String status;
        if (energie > 5){
            status = "tout va bien !";
        }else{
            status = "je suis affamé !";
        }
        System.out.println(nom+" : "+status);
    }

     public void manger(){
        if(energie >= maxEnergie){
            System.out.println(nom+": je n'ai pas faim !!");
        }
        else{
            energie += rand.nextInt(1,4);
            System.out.println(nom+" : Merci !");
                if(energie > maxEnergie)
                    energie = maxEnergie;
        }
     }

     public boolean ageLimite(){
        if(age >= dureeDeVie){
            return true;
        }else{
            return false;
        }
    }

    public boolean vivre(){
        if(age == dureeDeVie){
            return true;
        }
        if(energie <= 0){
            System.out.println(nom+" : je meurs... Arrrggh !");
            return false;
        }
        age++;
        energie--;
        if(ageLimite()){
            System.out.println(nom+" : c'est gagné pour moi!");
        }    
        else{
            parler();
        }
        return true;
    }
    public String getNom(){
    return nom;
    }
}


