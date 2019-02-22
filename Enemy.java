package com.company;
import java.util.*;
public class Enemy {
public static Random enemytype=new Random();
public static int badguy=enemytype.nextInt(3)+1;
public static Random chanceOfAttacking = new Random();
public static int probability=chanceOfAttacking.nextInt(3)+1;

}
