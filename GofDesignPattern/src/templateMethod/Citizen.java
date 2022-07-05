package templateMethod;

public class Citizen {
    private String id;
    private int age;
    private String name;
    private String position;
    private int strength;
    private int agility;
    private int intelligence;

    public Citizen() {}

    public Citizen(Citizen citizen) {
        this.id = citizen.getId();
        this.age = citizen.getAge();
        this.name = citizen.getName();
        this.position = citizen.getPosition();
        this.strength = citizen.getStrength();
        this.agility = citizen.getAgility();
        this.intelligence = citizen.getIntelligence();
    }
    public Citizen(String id, int age, String name, String position, int strength, int agility,
                   int intelligence) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.position = position;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void updateStrength(int stat) {
        strength += stat;
    }

    public void updateAgility(int stat) {
        agility += stat;
    }

    public void updateIntelligence(int stat) {
        intelligence += stat;
    }

    @Override
    public String toString() {
        return "Citizen{" +
            "id='" + id + '\'' +
            ", age=" + age +
            ", name='" + name + '\'' +
            ", position='" + position + '\'' +
            ", strength=" + strength +
            ", agility=" + agility +
            ", intelligence=" + intelligence +
            '}';
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
