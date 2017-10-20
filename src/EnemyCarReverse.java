
public class EnemyCarReverse extends EnemyCar{

	int speed = 200;
	
	public EnemyCarReverse(PlayerCar playerCar) {
		super(playerCar);
	}

	@Override
	public void goDown(){
		position.setLocation(position.getX(),position.getY()+(speed)/10);

	}
	@Override
	public void crash(){
		super.crash();
		speed=0;
	}
	@Override
	protected void stabilize(){
		super.stabilize();
		speed =200;
	}
	
}
