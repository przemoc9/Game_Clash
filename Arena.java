package com.company.paka7.ex4;

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


    public Arena(int myBudget, int opponentBudget) {
        this.myBudget = myBudget;
        this.opponentBudget = opponentBudget;
        this.myArmy = new ArrayList<Warrior>();
        this.opponentArmy = new ArrayList<Warrior>();


    }

    public ArrayList<Warrior> getMyArmy() {
        return myArmy;
    }

    public ArrayList<Warrior> getOpponentArmy() {
        return opponentArmy;
    }

    public void setMyArmy(ArrayList<Warrior> myArmy) {
        this.myArmy = myArmy;
    }

    public void setOpponentArmy(ArrayList<Warrior> opponentArmy) {
        this.opponentArmy = opponentArmy;
    }

    public void setPalladynek(Warrior palladynek) {
        this.palladynek = palladynek;
    }

    public void setPiechurek(Warrior piechurek) {
        this.piechurek = piechurek;
    }
    public void setRycerzyk(Warrior rycerzyk) {
        this.rycerzyk = rycerzyk;
    }

    Warrior palladynek = new Palladyn(200, 100, 60000, 0);
    Warrior piechurek = new Piechur(50, 30, 10000, 0);
    Warrior rycerzyk = new Rycerz(100, 50, 25000, 0);
//    public static Warrior createContact(int life,int attack,int cost,int minAttack)
//    {
//        return new Warrior(life,attack,cost,minAttack) {
//            @Override
//            public int attack() {
//                return 0;
//            }
//
//            @Override
//            public int healthValue() {
//                return 0;
//            }
//
//            @Override
//            public void sethealthValue(int life) {
//
//            }
//        };
//    }

    public void addWarriorFirst() {
        int choice;
        if (this.myBudget >= 10000) {
            System.out.println(" ");
            System.out.println("Red tem have  " + this.myBudget+" coins");
            System.out.println("~~Team RED~~");
            System.out.println("Choose warrior to your team!");
            System.out.println("[1]- Palladyn HP:200  ATT:100   COST 60k");
            System.out.println("[2]- Piechur HP:50  ATT:30   COST 10k");
            System.out.println("[3]- Rycerz HP:100  ATT:50   COST 25k");
            System.out.println("[4]- Pancerz -> Dodaje 50 do obrony na dana jednostke   COST 10k");
            System.out.println("[5]- Miecz -> Dodaje 75 do ataku wybranej jednostce     COST 15k ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (this.myBudget >= 60000) {
                        myArmy.add(new Palladyn(200, 100, 60000, 0));
                        this.myBudget -= 60000;
                        System.out.println("You choose " + palladynek.getClass().getSimpleName() + "\n" + "Your budget now is " + this.myBudget);

                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 2:
                    if (this.myBudget >= 10000) {
                        myArmy.add(new Piechur(50, 30, 10000, 0));
                        this.myBudget -= 10000;
                        System.out.println("You choose " + piechurek.getClass().getSimpleName() + "\n" + "Your budget now is " + this.myBudget);
                        System.out.println("Yo");
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }

                    break;
                case 3:
                    if (this.myBudget >= 25000) {
                        myArmy.add(new Rycerz(100, 50, 25000, 0));
                        this.myBudget -= 25000;
                        System.out.println("You choose " + rycerzyk.getClass().getSimpleName() + "\n" + "Your budget now is " + this.myBudget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 4:
                    if (this.myBudget >= 10000) {
                        if(myArmy.size()>0) {
                            int position;
//                        int atakujacy = this.opponentArmy.get(choice).attack();
//
//                        int atakowana = this.myArmy.get(secondchoice).healthValue();
//                        myArmy.get(secondchoice).sethealthValue(atakowana - atakujacy);
                            System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                            position = scanner.nextInt();
                            if (position >= this.myArmy.size() - 1) {
                                while ((position > this.myArmy.size() - 1)) {
                                    System.out.println("Enter true value!!!");
                                    position = scanner.nextInt();
                                }
                            }
                            myArmy.get(position).pancerz();
                            this.myBudget -= 10000;

                            int HPaktualne = this.myArmy.get(position).healthValue();
                            myArmy.get(position).sethealthValue(HPaktualne + 50);
                            System.out.println("Your " + myArmy.get(position).getClass().getSimpleName() + " has " + myArmy.get(position).healthValue() + " HP");
                        }} else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 5:
                    if (this.myBudget >= 15000) {
                        if(myArmy.size()>0) {
                            int position;
//                        int atakujacy = this.opponentArmy.get(choice).attack();
//
//                        int atakowana = this.myArmy.get(secondchoice).healthValue();
//                        myArmy.get(secondchoice).sethealthValue(atakowana - atakujacy);
                            System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                            position = scanner.nextInt();
                            if (position >= this.myArmy.size() - 1) {
                                while ((position > this.myArmy.size() - 1)) {
                                    System.out.println("Enter true value!!!");
                                    position = scanner.nextInt();
                                }
                            }
                            myArmy.get(position).pancerz();
                            this.myBudget -= 15000;

                            int Attaktualny = this.myArmy.get(position).attpoint();
                            myArmy.get(position).setattackValue(Attaktualny + 75);
                            System.out.println("Your " + myArmy.get(position).getClass().getSimpleName() + " has " + myArmy.get(position).attpoint() + " ATAKU");
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
            System.out.println("You have "+myArmy.size()+" elements.");
            printArmyRed();
        }

    }

    public void addWarriorSecond() {
        if (this.opponentBudget >= 10000) {
            int choice;
            System.out.println(" ");
            System.out.println("Blue tem have  " + this.opponentBudget+" coins");
            System.out.println("~~TEAM BLUE~~");
            System.out.println("Choose warrior to your team!");
            System.out.println("[1]- Palladyn HP:200  ATT:100   COST 60k");
            System.out.println("[2]- Piechur HP:50  ATT:30   COST 10k");
            System.out.println("[3]- Rycerz HP:100  ATT:50   COST 25k");
            System.out.println("[4]- Pancerz -> Dodaje 50 do obrony na dana jednostke   COST 10k");
            System.out.println("[5]- Miecz -> Dodaje 75 do ataku wybranej jednostce     COST 15k ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (this.opponentBudget >= 60000) {
                        opponentArmy.add(new Palladyn(200, 100, 60000, 0));
                        this.opponentBudget -= 60000;
                        System.out.println("You choose " + palladynek.getClass().getSimpleName() + "\n" + "Your budget now is " + this.opponentBudget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 2:
                    if (this.opponentBudget >= 10000) {
                        opponentArmy.add(new Piechur(50, 30, 10000, 0));
                        this.opponentBudget -= 10000;
                        System.out.println("You choose " + piechurek.getClass().getSimpleName() + "\n" + "Your budget now is " + this.opponentBudget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }

                    break;
                case 3:
                    if (this.opponentBudget >= 25000) {
                        opponentArmy.add(new Rycerz(100, 50, 25000, 0));
                        this.opponentBudget -= 25000;
                        System.out.println("You choose " + rycerzyk.getClass().getSimpleName() + "\n" + "Your budget now is " + this.opponentBudget);
                    } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 4:
                    if (this.opponentBudget >= 10000) {
                       if(opponentArmy.size()>0) {
                           int position;
                           System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                           position = scanner.nextInt();
                           if (position >= this.opponentArmy.size() - 1) {
                               while ((position > this.opponentArmy.size() - 1)) {
                                   System.out.println("Enter true value!!!");
                                   position = scanner.nextInt();
                               }
                           }
                           myArmy.get(position).pancerz();
                           this.opponentBudget -= 10000;

                           int HPaktualne = this.opponentArmy.get(position).healthValue();
                           opponentArmy.get(position).sethealthValue(HPaktualne + 50);
                           System.out.println("Your " + opponentArmy.get(position).getClass().getSimpleName() + " has " + opponentArmy.get(position).healthValue() + " HP");
                       }  } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                case 5:
                    if (this.opponentBudget >= 15000) {
                        if(opponentArmy.size()>0) {
                            int position;
//                        int atakujacy = this.opponentArmy.get(choice).attack();
//
//                        int atakowana = this.myArmy.get(secondchoice).healthValue();
//                        myArmy.get(secondchoice).sethealthValue(atakowana - atakujacy);
                            System.out.println(" Wybiez jednostke na jaka ma dzialac podany potion");
                            position = scanner.nextInt();
                            if (position >= this.opponentArmy.size() - 1) {
                                while ((position > this.opponentArmy.size() - 1)) {
                                    System.out.println("Enter true value!!!");
                                    position = scanner.nextInt();
                                }
                            }
                            opponentArmy.get(position).pancerz();
                            this.opponentBudget -= 15000;

                            int Attaktualny = this.opponentArmy.get(position).attpoint();
                            opponentArmy.get(position).setattackValue(Attaktualny + 75);
                            System.out.println("Your " + opponentArmy.get(position).getClass().getSimpleName() + " has " + opponentArmy.get(position).attpoint() + " ATAKU");
                        }  } else {
                        System.out.println("You dont have money, choose another individual");
                    }
                    break;
                default:
                    System.out.println("You dont chose any warrior :/");
                    break;

            }
            System.out.println("You have "+opponentArmy.size()+" elements.");
            printArmyBlue();
        }

    }

    public void ChooseArmy() {
        for (int i = 0; i < 100; i++) {
            addWarriorSecond();
            addWarriorFirst();
        }
    }

    public void printArmyRed() {
        System.out.println("Red ARMY: ");
        for (int i = 0; i < this.myArmy.size(); i++) {

            System.out.println(i + ". " + this.myArmy.get(i) + " HP:" + this.myArmy.get(i).healthValue()+" "+this.myArmy.get(i).attpoint()+" ATT");
        }
        System.out.println(" ");
    }

    public void printArmyBlue() {
        System.out.println("BLUE ARMY:");
        for (int i = 0; i < this.opponentArmy.size(); i++) {

            System.out.println(i + ". " + this.opponentArmy.get(i) + " HP:" + this.opponentArmy.get(i).healthValue()+ " "+this.opponentArmy.get(i).attpoint()+" ATT");
        }
        System.out.println(" ");
    }

    public void printArmy() {
        printArmyRed();
        printArmyBlue();

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
//        if (myArmy.get(secondchoice) == piechurek) {
//            myArmy.set(secondchoice,piechurek).sethealthValue(atakowana - atakujacy);
//            System.out.println(myArmy.get(secondchoice) + " have HP:" + myArmy.get(secondchoice).healthValue());
//            if (myArmy.set(secondchoice,piechurek).healthValue() < 0) {
//                System.out.println(myArmy.get(secondchoice) + " is dead!");
//               this.myArmy.remove(secondchoice);
//            }
//        } else if (myArmy.get(secondchoice) == palladynek) {
//            myArmy.set(secondchoice,palladynek).sethealthValue(atakowana - atakujacy);
//            System.out.println(myArmy.get(secondchoice) + " have HP:" + myArmy.get(secondchoice).healthValue());
//            if (myArmy.set(secondchoice,palladynek).healthValue() < 0) {
//                System.out.println(myArmy.get(secondchoice) + " is dead!");
//                this.myArmy.remove(secondchoice);
//            } else if (myArmy.get(secondchoice) == rycerzyk) {
//                myArmy.set(secondchoice,rycerzyk).sethealthValue(atakowana - atakujacy);
//                System.out.println(myArmy.get(secondchoice) + " have HP:" + myArmy.get(secondchoice).healthValue());
//                if (myArmy.set(secondchoice,rycerzyk).healthValue() < 0) {
//                    System.out.println(myArmy.get(secondchoice) + " is dead!");
//                    this.myArmy.remove(secondchoice);
//                }
//            }
//        }
//        if(myArmy.size()==0){
//            System.out.println("BLUE TEAM WIN!");
//            return;
//        }else if(opponentArmy.size()==0){
//            System.out.println("RED TEAM WIN!");
//            return;
//        }
    }
public void Sklep(){
    System.out.println("~~Witamy w sklepie~~"+"\n"+"Mozesz tu kupic rzeczy, ktore ulepsza Twoja armie !!");


}

    public void ExistGame() {
        System.out.println("START GAME!");
        ChooseArmy();
        printArmy();


        while(this.myArmy.size()>0 || this.opponentArmy.size()>0) {
            BlueTeamAttack();
                printArmy();
                if (this.myArmy.size() == 0) {
                    System.out.println("BLUE TEAM WIN!");
                    return;
                } else if (this.opponentArmy.size() == 0) {
                    System.out.println("RED TEAM WIN!");
                    return;
                }
            RedTeamAttack();
                printArmy();


        }
        if(this.myArmy.size()==0){
            System.out.println("BLUE TEAM WIN!");
        }else if(this.opponentArmy.size()==0){
            System.out.println("RED TEAM WIN!");
        }
    }
}