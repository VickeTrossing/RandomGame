import java.util.Random;

public class Loot {

    Random random = new Random();
    Weapon refWeapon = Weapon.getInstance();

    public void loot(Player player){
        int randomNumber = random.nextInt(10);
        refWeapon.weaponArray();


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
        System.out.println("You found a weapon! You found: " + player.getWeaponName());

        /*if(randomNumber <= 6){

            int extraAttack = random.nextInt(19)+1;
            player.setPlayerAttack(player.getPlayerAttack()+extraAttack);
            System.out.println("You found loot! Your attack grows by: " + extraAttack + " points!");

        }else if(randomNumber > 6){
            if(refWeapon.currentWeapon.isEmpty()){

                player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());

                refWeapon.currentWeapon.add(refWeapon.weapons.get(0));
                System.out.println("You found a weapon! You found: " + player.getWeaponName());

            }else{
                for(int i = 0; i < refWeapon.weapons.size(); i++){
                    if(refWeapon.currentWeapon.get(0).getWeaponRank() == i){

                        refWeapon.currentWeapon.remove(0);
                        refWeapon.currentWeapon.add(refWeapon.weapons.get(i+1));

                        player.setWeaponName(refWeapon.currentWeapon.get(0).getWeaponName());
                        player.setPlayerAttack(refWeapon.currentWeapon.get(0).getHitPoints());

                        System.out.println("You found a weapon! You found: " + player.getWeaponName());

                        break;
                    }
                }
            }
        }*/
    }
}
