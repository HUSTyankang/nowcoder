package learn.test;

/*
  *  制作一副扑克，分给三位玩家，剩余三张底牌，可以洗牌
 */

import java.util.*;
//import java.util.Scanner;
//import java.util.Collections;

public class Poker {

	public static void main(String[] args) {
		
		String[] players = new String[] {"player1", "player2","playre3"};//将三位玩家的名字保存在players数组中
	
		
		String[] col = new String[] {"♠","♥","♣","♦"};//扑克的花色
		String[] num = new String[] {"2","A","K","Q","J","10",
									 "9","8","7","6","5","4","3"};//扑克的数字，除了大、小王
		
		List<Integer> poker  = new ArrayList<>();//保存整副扑克的索引
		
		List<Integer> index1 = new ArrayList<>();//保存玩家1 牌的索引
		List<Integer> index2 = new ArrayList<>();//保存玩家2牌的索引
		List<Integer> index3 = new ArrayList<>();//保存玩家3牌的索引
		List<Integer> dipai0 = new ArrayList<>();//保存底牌的索引
		
		List<String> player1 = new ArrayList<>();//保存玩家1 的牌
		List<String> player2 = new ArrayList<>();//保存玩家2的牌
		List<String> player3 = new ArrayList<>();//保存玩家3的牌
		List<String> dipai   = new ArrayList<>();//保存底牌
		
		Map<Integer,String> map = new HashMap<>();//将索引与对应的牌进行映射
		
		map.put(0,"大王");
		map.put(1,"小王");
		int k = 2;
		for (String i : num) {//对数字进行遍历
			for (String j : col) {//对花色进行遍历
				String item = j + i;//将花色与数字进行组合
				map.put(k++,item);//将索引与对应的牌进行皮胚
			}
		}
		
		for (int i = 0; i < 54; i++) {
				poker.add(i);//保存到poker中
		}
		
		Collections.shuffle(poker);//洗牌,Collections类的静态方法shuffle
		
		for (int i = 0; i < poker.size(); i++) {//发牌
			int item = poker.get(i);
			if(i < 51) {//前51张牌发给三位玩家
				if (i % 3 == 0) {
					index1.add(item);
				}else if(i % 3 == 1) {
					index2.add(item);
				}else if(i % 3 == 2) {
					index3.add(item);
				}
			}else {dipai0.add(item);}
		}
		
		Collections.sort(index1);//排序,对牌进行整理
		Collections.sort(index2);
		Collections.sort(index3);
		Collections.sort(dipai0);
		
		for (Integer i : index1) {
			player1.add(map.get(i));//通过索引获得对应的牌
		}
		
		for (Integer i : index2) {
			player2.add(map.get(i));
		}
		
		for (Integer i : index3) {
			player3.add(map.get(i));
		}
		
		for (Integer i : dipai0) {
			dipai.add(map.get(i));
		}
		
		System.out.println(players[0] + ":" + player1);
		System.out.println(players[1] + ":" + player2);
		System.out.println(players[2] + ":" + player3);
		System.out.println("底牌：" + dipai);
	}

}
