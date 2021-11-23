import java.util.Random;

public class Loot {

    Random random = new Random();
    //Player player = new Player();
   Weapon weapon = new Weapon();
    Weapon refWeapon = Weapon.getInstance();

    public void loot(Player player){
        int randomNumber = random.nextInt(100);
        refWeapon.weaponArray();

        if(randomNumber <= 50){
            int extraAttack = random.nextInt(19)+1;
            player.setPlayerAttack(player.getPlayerAttack()+extraAttack);
            System.out.println("You found loot! You're attack grows by: " + extraAttack + " points!");
        }else if(randomNumber >= 50 && randomNumber <= 75){


            for (int i = 0; i < refWeapon.weapons.size(); i++){

                player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());

                if(player.getWeaponName().length() < 0){
                    
                }
            }

                player.setWeaponName(refWeapon.weapons.get(0).getWeaponName());
                player.setPlayerAttack(refWeapon.weapons.get(0).getHitPoints());
        }
    }
}
