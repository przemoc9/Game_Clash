package com.company.paka7.ex4;

import java.util.Random;

public class Rycerz extends Osoba implements Warrior{
    private int life;
    private int attack;
    private int cost;
    private int minAttack;

    @Override
    public int attack() {
        Random random=new Random();

        return random.nextInt(attack-10)+10;
    }
    public int healthValue() {

        return life;
    }

    @Override
    public void sethealthValue(int life) {
        this.life=life;
    }

    @Override
    public void setattackValue(int attack) {
        this.attack=attack;
    }

    @Override
    public int attpoint() {
        return this.attack;
    }

    @Override
    public int pancerz() {
        return this.life+50;
    }

    @Override
    public int miecz() {
        return attack+75;
    }

    @Override
    public int mikstura() {
        return this.life+20;
    }

    @Override
    public int bomba() {
        return this.life-25;
    }

    public Rycerz(int life, int attack, int cost, int minAttack) {
        super("Rycerz");
        this.life = life;
        this.attack = attack;
        this.cost = cost;
        this.minAttack = minAttack;
    }
//    public static Rycerz createFighter() {
//        return new Rycerz(100,50,25000,0);
//    }

    public int getLife() {
        return this.life;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getCost() {
        return cost;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    @Override
    public String toString() {
        return "Rycerz";
    }


}
