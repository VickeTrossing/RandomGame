import java.util.Random;

public class Loot {

    Random random = new Random();
    Weapon refWeapon = Weapon.getInstance();

    public String loot(Player player){
        int randomNumber = random.nextInt(10);
        refWeapon.weaponArray();

        if(randomNumber <= 6){

            int extraAttack = random.nextInt(19)+1;
            player.setPlayerAttack(player.getPlayerAttack()+extraAttack);
            return "You found loot! Your attack grows by: " + extraAttack + " points!";
            //System.out.println("You found loot! Your attack grows by: " + extraAttack + " points!");

        }else{
            if(refWeapon.currentWeapon.isEmpty()){

                player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());

                refWeapon.currentWeapon.add(refWeapon.weapons.get(0));

            }else{
                if(refWeapon.currentWeapon.isEmpty()){

                    player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                    player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());

                    refWeapon.currentWeapon.add(refWeapon.weapons.get(0));

                }else{
                    for(int i = 1; i < refWeapon.weapons.size(); i++){
                        if(refWeapon.currentWeapon.get(0).getWeaponRank() == i){

                            if(refWeapon.currentWeapon.get(0).getWeaponRank() == 4){
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
            //System.out.println("You found a weapon! You found: " + player.getWeaponName());
            return "You found a weapon! You found: " + player.getWeaponName();
             }
        }
    }