package strategy;

public class GameCharacter {
    private Weapon weapon;
    // 교환 가능
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == null) {
            System.out.println("맨손 공격");
        } else {
            // 위임(delegate)
            weapon.attack();
        }
        // Weapon 은 attack 이라는 기능을 가지는 하나의 strategy 가 됨
        
    }
}
