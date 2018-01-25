package Juego;

public class Gasolina extends EnemyCar{

	public Gasolina(PlayerCar playerCar) {
		super(playerCar);
		currentAnim = new Animation("res/gasolina1.png","res/gasolina2.png");
		spriteManager.changeSprite(currentAnim);
	}

	@Override
	public void collision(GameObject other){
		if (other instanceof PlayerCar){
			this.destroy();
		}
	}
	
}
