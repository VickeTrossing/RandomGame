import java.util.Random;

public class Loot {
    Random random = new Random();
    Weapon refWeapon = Weapon.getInstance();

    public String loot(Player player) {
        int randomNumber = random.nextInt(15);
        refWeapon.weaponArray();

        if (randomNumber <= 6) {
            int extraAttack = random.nextInt(19) + 1;
            player.setPlayerAttack(player.getPlayerAttack() + extraAttack);
            return "You found loot! Your attack grows by: " + extraAttack + " points!";

        } else if (randomNumber > 6 && randomNumber <= 10) {
            if (refWeapon.currentWeapon.isEmpty()) {

                player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());

                refWeapon.currentWeapon.add(refWeapon.weapons.get(0));

            } else {
                if (refWeapon.currentWeapon.isEmpty()) {
                    player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                    player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());
                    refWeapon.currentWeapon.add(refWeapon.weapons.get(0));

                } else {
                    for (int i = 1; i < refWeapon.weapons.size(); i++) {
                        if (refWeapon.currentWeapon.get(0).getWeaponRank() == i) {
                            if (refWeapon.currentWeapon.get(0).getWeaponRank() == 4) {
                                break;
                            }
                            refWeapon.currentWeapon.remove(0);
                            refWeapon.currentWeapon.add(refWeapon.weapons.get(i));
                            break;
                        }
                    }
                    player.setWeaponName(refWeapon.currentWeapon.get(0).getWeaponName());
                    player.setPlayerAttack(refWeapon.currentWeapon.get(0).getHitPoints());

                }
            }
            return "You found a weapon! You found: " + player.getWeaponName();

        } else if (randomNumber > 10) {
            if(player.getPlayerHealth() < 100){
                int increaseHealth = 0;

                if(player.getPlayerHealth() < 100 && player.getPlayerHealth() >= 75){
                    increaseHealth = 5;
                }else if(player.getPlayerHealth() <= 74 && player.getPlayerHealth() >= 50){
                    increaseHealth = 10;
                }else if(player.getPlayerHealth() <= 49 && player.getPlayerHealth() >= 20){
                    increaseHealth = 20;
                }else if(player.getPlayerHealth() <= 19 && player.getPlayerHealth() >= 1){
                    increaseHealth = 50;
                }

                player.setPlayerHealth(player.getPlayerHealth() + increaseHealth);
                return "You found health! Your health increases with: " + increaseHealth;
            }else{
                int extraAttack = random.nextInt(19) + 1;
                player.setPlayerAttack(player.getPlayerAttack() + extraAttack);
                return "You found loot! Your attack grows by: " + extraAttack + " points!";
            }

        }
        return "0";
    }


    public String healLoot(Player player){

        int healPoints = 0;
        int playerHealth = player.getPlayerHealth();

        if(playerHealth >= 75){
            healPoints = 25;
        }else if(playerHealth >= 50){
            healPoints = 50;
        }else if(playerHealth >= 25){
            healPoints = 75;
        }else{
            healPoints = 100;
        }

        int heal = random.nextInt(healPoints);

        player.setPlayerHealth(playerHealth + heal);

        return "You found health! You health grows by: " + heal + " points!";
    }
}