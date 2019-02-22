/*
Quick Note Here:
Many of these additional classes aren't necessary, as I could have just defined the variables here, but past-me found
it much easier to create other classes solely for certain variables. Sorry, but oh well.

Anyways, here is the actual "start" to my game, which is a text/move-based Dark Souls III remake. This is also a project
for my java class that I'm currently in, meaning that this will most likely be rushed work, and I won't be able to
completely finish by the time this is due. However, I will continue to work on this when I have the chance and I'll
hopefully finish this at some point in time.

Project Overview:
As I previously mentioned in the paragraph above, this is a text-based rendering of the Dark Souls III game that has a
movement-based combat system. At the time of writing this, the "game" only contains the introduction, character selection,
a couple of choices and a randomized fight.
 */
package com.company;
import java.util.*;

import static com.company.ChosenClass.*;
import static com.company.Enemy.*;
import static com.company.SwordsmanSkeleton.skdamage;
import static com.company.SwordsmanSkeleton.skhealth;
import static com.company.moves.moveamount;

public class MaybeGame {
    public static Scanner MoveInput=new Scanner(System.in);
    public static int EnemyHealth=0;
    public static int PlayerDMG=0;
    public static int EnemyHealthLeft=EnemyHealth;
    public static String MoveChoice;
    public static int PlayerHealth=550;
    public static int PlayerBlockedHealthLeft=PlayerHealth;
    public static int movesleft=0;
public static void main(String [] args) {
    SomethingNew.huh(new String[1]);
    chanceOfAttacking = new Random();
    ItemInventory.Items[0] = ItemInventory.Estus_Flask;
    probability = chanceOfAttacking.nextInt(2) + 1;
    System.out.println("You have risen from your tomb as a(n) " + sclass + ".");
    System.out.println("You see a fork in the path ahead, an enemy stands watch." +
            " there is a path leading to the left, and another to the right.");

    String fork = scan.next().toLowerCase();
    if (fork.equals("left")) { //These are just randomized enemies with randomized health and damage values
        System.out.println("The enemy sees you and prepares to attack!");
        if (badguy == 1) {
            System.out.println("An Undead Swordsman has appeared with " + skhealth + " health, and " + skdamage + " damage!");
        }
        if (badguy == 2) {
            System.out.println("An Undead Archer has appeared with " + skhealth + " health, and " + skdamage + " damage!");
        }
        if (badguy == 3) {
            System.out.println("An Undead Shield Warrior has appeared with " + skhealth + " health, and " + skdamage + " damage!");
        }
    } else if (fork.equals("right")) {
        System.out.println("The enemy sees you and prepares to attack!");
        if (badguy == 1) {
            System.out.println("An Undead Swordsman has appeared with " + skhealth + " health, and " + skdamage + " damage!");
            EnemyHealth = EnemyHealth + skhealth;
        }
        if (badguy == 2) {
            System.out.println("An Undead Archer has appeared with " + skhealth + " health, and " + skdamage + " damage!");
            EnemyHealth = EnemyHealth + skhealth;
        }
        if (badguy == 3) {
            System.out.println("An Undead Shield Warrior has appeared with " + skhealth + " health, and " + skdamage + " damage!");
            EnemyHealth = EnemyHealth + skhealth;
        }
    }
    if (SomethingNew.Start_Array[3] <= 4) {
        moveamount++;
        System.out.println("You have " + moveamount + " move(s)!");
    } else if (SomethingNew.Start_Array[3] >= 8 && SomethingNew.Start_Array[3] < 12) {
        moveamount++;
        moveamount++;
        System.out.println("You have " + moveamount + " move(s)!");
    } else if (SomethingNew.Start_Array[3] == 12 || SomethingNew.Start_Array[3] > 12) {
        moveamount++;
        moveamount++;
        moveamount++;
        System.out.println("You have " + moveamount + " move(s)!"); //This dictates how many moves you have based on your END stat.
    }
    movesleft = movesleft + moveamount;

    EnemyHealthLeft = skhealth;
    for (int i = 0; i < movesleft; i++) {
        System.out.println("What would you like to do?");
        System.out.println("Attack\n" + "Block\n" + "Dodge\n");
        MoveChoice = MoveInput.next().toLowerCase();
        switch (MoveChoice) {
            case "attack": //Standard attacking
                System.out.println("You attacked the enemy for " + PlayerDamage.DamageDealt + " damage!");
                PlayerDMG = PlayerDMG + PlayerDamage.DamageDealt;
                EnemyHealthLeft = EnemyHealthLeft + EnemyHealth - PlayerDMG;
                System.out.println("The enemy has "+EnemyHealthLeft+" health remaining!");
                break;
            case "block": //A dice is rolled that tells you whether you take any damage when blocking.
                if (probability == 1) {
                    System.out.println("The enemy attacks! You blocked the attack and took " + skdamage / 2 + " damage!");
                    PlayerBlockedHealthLeft = PlayerHealth - skdamage / 2;
                    System.out.println(PlayerBlockedHealthLeft);
                    break;
                }
                if (probability == 2) {
                    System.out.println("You blocked, but the enemy didn't attack.");
                    break;
                }
            case "dodge":
                    System.out.println("You avoided the enemy's attack!");
                    break;
            case "sss": //Another easter egg that instantly kills the enemy.
                System.out.println("You used the almighty power of the sun and jolly cooperation!\n"+"You completely annihilated the enemy!");
                EnemyHealthLeft=0;
                movesleft=0;
                break;
            case "Not Working????": //This is just here because whatever seems to go in this case breaks the game so it's not used.
                    System.out.println("What.");
                    EnemyHealthLeft=0;
                    movesleft=0;
        }

    }
    movesleft = 0;
    if (EnemyHealthLeft==0){
        System.out.println("Congratulations upon beating the Mega Awesome Really Intense Amazing\n"
        +"Super Unbelievable Absolutely Righteous Early Zeta!");
    }


}
}
