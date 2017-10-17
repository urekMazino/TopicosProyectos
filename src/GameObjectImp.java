import java.awt.Graphics;

public abstract class GameObjectImp implements GameObject{

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("draw!");
		
	}

}
