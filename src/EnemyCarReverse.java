
public class EnemyCarReverse extends EnemyCar{

	int speed = 200;
	
	public EnemyCarReverse(PlayerCar playerCar) {
		super(playerCar);
		currentAnim = new Animation("res/carro-enemigo-amarillo-reverso.png");
		spriteManager.changeSprite(currentAnim);
	}

	@Override
	public void goDown(){
		position.setLocation(position.getX(),position.getY()+(speed)/10);

	}
	@Override
	public void crash(GameObject other){
		super.crash(other);
		speed=0;
	}
	
	@Override
	public void collision(GameObject other){
		if (other instanceof PlayerCar || other instanceof EnemyCarNormal){
			crash(other);
		} 
	}
	@Override
	protected void stabilize(){
		super.stabilize();
		speed =200;
	}
	
	
	
}
