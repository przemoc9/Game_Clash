package com.company.paka7.ex4;

import com.company.paka7.ex5.SecondInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arena {
    Scanner scanner = new Scanner(System.in);
    private int myBudget = 100000;
    private int opponentBudget = 100000;
    private ArrayList<Warrior> myArmy;
    private ArrayList<Warrior> opponentArmy;

    String FirstNameTeam;
    String SecondNameTeam;

    public Arena() {
        this.myArmy = new ArrayList<Warrior>();
        this.opponentArmy = new ArrayList<Warrior>();
    }

    public ArrayList<Warrior> getMyArmy() {
        return myArmy;
    }

    public ArrayList<Warrior> getOpponentArmy() {
        return opponentArmy;
    }



    Warrior palladynek = new Palladyn(200, 100, 60000, 0);
    Warrior piechurek = new Piechur(50, 30, 10000, 0);
    Warrior rycerzyk = new Rycerz(100, 50, 25000, 0);
public void ChooseNameTeam(){
    System.out.println("Podaj nazwe pierwszego zespolu");
    FirstNameTeam=scanner.nextLine();
    System.out.println("Podaj nazwe drugiego zespolu");
    SecondNameTeam=scanner.nextLine();

}

    public void addWarrior(int budget,List<Warrior>warriors,String Team) {
        int choice;

        while(budget >= 10000) {
            System.out.println(" ");
            System.out.println(Team+" team have  " + budget+" coins");
            System.out.println("~~Team "+Team+"~~");
            System.out.println("Choose warrior to your team!");
            System.out.println("[1]- Palladyn HP:200  ATT:100   COST 60k");
            System.out.println("[2]- Piechur HP:50  ATT:30   COST 10k");
            System.out.println("[3]- Rycerz HP:100  ATT:50   COST 25k");
            System.out.println("[4]- Pancerz -> Dodaje 50 do obrony na dana jednostke   COST 10k");
            System.out.println("[5]- Miecz -> Dodaje 75 do ataku wybranej jednostce     COST 15k ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (budget >= 60000) {
                        warriors.add(new Palladyn(200, 100, 60000, 0));
                        budget -= 60000;
                        System.out.println("You choose " + palladynek.getClass().getSimpleName() + "\n" + "Your budget now is " + budget);

                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 2:
                    if (budget >= 10000) {
                        warriors.add(new Piechur(50, 30, 10000, 0));
                        budget -= 10000;
                        System.out.println("You choose " + piechurek.getClass().getSimpleName() + "\n" + "Your budget now is " + budget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }

                    break;
                case 3:
                    if (budget >= 25000) {
                        warriors.add(new Rycerz(100, 50, 25000, 0));
                        budget -= 25000;
                        System.out.println("You choose " + rycerzyk.getClass().getSimpleName() + "\n" + "Your budget now is " + budget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 4:
                    if (budget >= 10000) {
                        if(warriors.size()>0) {
                            int position;

                            System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                            position = scanner.nextInt();
                            if (position >=warriors.size() - 1) {
                                while ((position > warriors.size() - 1)) {
                                    System.out.println("Enter true value!!!");
                                    position = scanner.nextInt();
                                }
                            }
                            warriors.get(position).pancerz();
                            budget -= 10000;

                            int HPaktualne = warriors.get(position).healthValue();
                            warriors.get(position).sethealthValue(HPaktualne + 50);
                            System.out.println("Your " + warriors.get(position).getClass().getSimpleName() + " has " + warriors.get(position).healthValue() + " HP");
                        }} else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 5:
                    if (budget >= 15000) {
                        if(warriors.size()>0) {
                            int position;

                            System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                            position = scanner.nextInt();
                            if (position >= warriors.size() - 1) {
                                while ((position > warriors.size() - 1)) {
                                    System.out.println("Enter true value!!!");
                                    position = scanner.nextInt();
                                }
                            }
                            warriors.get(position).pancerz();
                            budget -= 15000;

                            int Attaktualny = warriors.get(position).attpoint();
                            warriors.get(position).setattackValue(Attaktualny + 75);
                            System.out.println("Your " + warriors.get(position).getClass().getSimpleName() + " has " + warriors.get(position).attpoint() + " ATAKU");
                        }  } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You dont chose any warrior :/");
                    break;
            }
            System.out.println("You have "+warriors.size()+" elements.");

        }

    }




    public void ChooseArmy() {
         {
            addWarrior(myBudget, myArmy, FirstNameTeam);
            printArmy(FirstNameTeam, myArmy);
            addWarrior(opponentBudget,opponentArmy,SecondNameTeam);
            printArmy(SecondNameTeam,opponentArmy);
        }
    }

    public void printArmy(String Team,List<Warrior>warriors) {
        System.out.println(Team+" ARMY: ");
        for (int i = 0; i < warriors.size(); i++) {

            System.out.println(i + ". " + warriors.get(i) + " HP:" + warriors.get(i).healthValue()+" "+warriors.get(i).attpoint()+" ATT");
        }
        System.out.println(" ");
    }



    public void RedTeamAttack() {
        if(this.opponentArmy.size()==0 || this.myArmy.size()==0){
            return;
        }
        int choice;
        System.out.println("~~RED TEAM ATTACK~~");
        System.out.println("Choose warrior which is the best to attack... Let's go!");
        choice = scanner.nextInt();

        if (choice > this.myArmy.size() - 1) {
            while((choice > this.myArmy.size() - 1)){
            System.out.println("Enter true value!!!");
            choice = scanner.nextInt();
        }}


        int secondchoice;
        System.out.println("Choose Enemy Unit which you want Attack ");
        secondchoice = scanner.nextInt();

        if((secondchoice > opponentArmy.size() - 1)){
        while (secondchoice < 0 || secondchoice > opponentArmy.size() - 1) {
            System.out.println("Enter true value!!!");
            secondchoice = scanner.nextInt();
        }}
        int atakujacy = this.myArmy.get(choice).attack();
        int atakowana = opponentArmy.get(secondchoice).healthValue();

        System.out.println("The Red Team ATTACK!" + "\n" + myArmy.get(choice) + " hits " + opponentArmy.get(secondchoice) + " with power " + atakujacy);
        opponentArmy.get(secondchoice).sethealthValue(atakowana - atakujacy);
        System.out.println(opponentArmy.get(secondchoice) + " have HP:" + opponentArmy.get(secondchoice).healthValue());
        if (opponentArmy.get(secondchoice).healthValue() < 0) {
            System.out.println(opponentArmy.get(secondchoice) + " is dead!");
            opponentArmy.remove(secondchoice);
        }

    }

    public void BlueTeamAttack() {
        if(this.opponentArmy.size()==0 || this.myArmy.size()==0){
            return;
        }
        int choice;
        System.out.println("~~BLUE TEAM ATTACK~~");
        System.out.println("Choose warrior which is the best to attack... Let's go!");
        choice = scanner.nextInt();

        if (choice >= this.opponentArmy.size() - 1) {
          while(choice > this.opponentArmy.size() - 1){
            System.out.println("Enter true value!!!");
            choice = scanner.nextInt();
        }}

        int secondchoice;
        System.out.println("Choose Enemy Unit which you want Attack ");
        secondchoice = scanner.nextInt();

        if((secondchoice > this.myArmy.size() - 1)){
        while (secondchoice > this.myArmy.size() - 1) {
            System.out.println("Enter true value!!!");
            secondchoice = scanner.nextInt();
        }}
        int atakujacy = this.opponentArmy.get(choice).attack();

        int atakowana = this.myArmy.get(secondchoice).healthValue();

        System.out.println("The Blue Team ATTACK!" + "\n" + opponentArmy.get(choice) + " hits " + myArmy.get(secondchoice) + " with power " + atakujacy);
        myArmy.get(secondchoice).sethealthValue(atakowana - atakujacy);
        System.out.println(myArmy.get(secondchoice) + " have HP:" + myArmy.get(secondchoice).healthValue());
        if (myArmy.get(secondchoice).healthValue() < 0) {
            System.out.println(myArmy.get(secondchoice) + " is dead!");
            myArmy.remove(secondchoice);
        }
    }
public void Sklep(){
    System.out.println("~~Witamy w sklepie~~"+"\n"+"Mozesz tu kupic rzeczy, ktore ulepsza Twoja armie !!");


}

    public void ExistGame() {
        System.out.println("START GAME!");
        ChooseNameTeam();
        ChooseArmy();
        printArmy(FirstNameTeam,myArmy);
        printArmy(SecondNameTeam,opponentArmy);


        while(this.myArmy.size()>0 || this.opponentArmy.size()>0) {
            BlueTeamAttack();
            printArmy(FirstNameTeam,myArmy);
            printArmy(SecondNameTeam,opponentArmy);
                if (this.myArmy.isEmpty()) {
                    System.out.println(SecondNameTeam+" TEAM WIN!");
                    return;
                } else if (this.opponentArmy.isEmpty()) {
                    System.out.println(FirstNameTeam+" TEAM WIN!");
                    return;
                }
            RedTeamAttack();
            printArmy(FirstNameTeam,myArmy);
            printArmy(SecondNameTeam,opponentArmy);


        }
        if(this.myArmy.isEmpty()){
            System.out.println(SecondNameTeam+" TEAM WIN!");
        }else if(this.opponentArmy.isEmpty()){
            System.out.println(FirstNameTeam+" TEAM WIN!");
        }
    }
}