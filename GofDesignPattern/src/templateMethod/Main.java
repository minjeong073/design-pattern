package templateMethod;

public class Main {
    public static void main(String[] args) {
        Citizen h1 = new Citizen();
        AbstSoldierConscriptionHelper helper
            = new SoldierConscriptionHelperInpl();
        Soldier soldier = helper.conscription();

        soldier.attack();
        soldier.defense();
    }
}
/*
결과

징집!
병사 훈련!
시민 -> 병사 변경!
장비 보급!
빵야빵야
갑옷방어!
 */