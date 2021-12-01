import java.util.ArrayList;
import java.util.List;

public class Weapon {

    Player player = new Player();

    private int hitPoints;
    private String weaponName;
    int weaponRank;
    List<Weapon> weapons = new ArrayList<>();
    List<Weapon> currentWeapon = new ArrayList<>();

    public Weapon(int hitPoints, String weaponName, int weaponRank) {
        this.hitPoints = hitPoints;
        this.weaponName = weaponName;
        this.weaponRank = weaponRank;
    }

    public Weapon(){}

    static Weapon instance = new Weapon();

    public static Weapon getInstance(){
        return instance;
    }


    public void weaponArray(){
        weapons.add(new Weapon((int) (player.getPlayerAttack()*1.5), "Dagger", 1));
        weapons.add(new Weapon (player.getPlayerAttack()*2, "Axe", 2));
        weapons.add(new Weapon ((int) (player.getPlayerAttack()*2.5), "Sword", 3));
        weapons.add(new Weapon (player.getPlayerAttack()*3, "Dane axe", 4));
    }


    public int getWeaponRank() {
        return weaponRank;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "player=" + player +
                ", hitPoints=" + hitPoints +
                ", weaponName='" + weaponName + '\'' +
                ", weapons=" + weapons +
                '}';
    }
}
