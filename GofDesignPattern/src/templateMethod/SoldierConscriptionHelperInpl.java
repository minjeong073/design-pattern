package templateMethod;

public class SoldierConscriptionHelperInpl extends AbstSoldierConscriptionHelper {

    // 시민들 중 마린이 될 수 있는 조건의 시민 징집하기
    @Override
    protected Citizen conscriptionCitizen() {
        System.out.println("징집!");
        return new Citizen();
    }

    // 징집된 군인들을 훈련하기
    @Override
    protected void training(Citizen citizen) {
        citizen.updateStrength(5);
        citizen.updateAgility(4);
        citizen.updateIntelligence(-3);
        System.out.println("병사 훈련!");
    }

    // 장비를 보급하기
    @Override
    protected void supplyEquipment(Soldier soldier) {
        soldier.setWeapon(new Gun());
        soldier.setArmor(new SteelArmor());
        System.out.println("장비 보급!");
    }

    // 보직을 시민에서 병사로 변경하기
    @Override
    protected Soldier changeOfPosition(Citizen citizen) {
        System.out.println("시민 -> 병사 변경!");
        return new Soldier(citizen);
    }
}
