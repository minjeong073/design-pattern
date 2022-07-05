package templateMethod;

public class Soldier extends Citizen {
    private Weapon weapon;
    private Armor armor;
    
    public void attack() {
        if (weapon == null) {
            System.out.println("맨손 공격");
        }
        weapon.attack();
    }

    public void defense() {
        if (armor == null) {
            System.out.println("맨몸으로 방어!");
        }
        armor.defense();
    }

    public Soldier() {
        super();
    }

    public Soldier(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    public Soldier(Citizen citizen) {
        super(citizen);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Soldier{" +
            "weapon=" + weapon +
            ", armor=" + armor +
            '}';
    }
}
