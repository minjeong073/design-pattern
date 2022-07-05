package templateMethod;

public abstract class AbstSoldierConscriptionHelper {
    // 시민들 중 마린이 될 수 있는 조건의 시민 징집하기
    protected abstract Citizen conscriptionCitizen();

    // 징집된 군인들을 훈련하기
    protected abstract void training(Citizen citizen);

    // 장비를 보급하기
    protected abstract void supplyEquipment(Soldier soldier);

    // 보직을 시민에서 병사로 변경하기
    protected abstract Soldier changeOfPosition(Citizen citizen);

    public Soldier conscription() {
        Citizen citizen = conscriptionCitizen();
        training(citizen);
        Soldier soldier = changeOfPosition(citizen);
        supplyEquipment(soldier);
        return soldier;
    }
}
