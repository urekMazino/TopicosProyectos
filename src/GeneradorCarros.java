
public class GeneradorCarros extends GameObjectImp{
	
		private double probabilidad = .40,probabilidadReverse = .25;
		private boolean[] lanes = new boolean[4];
		private PlayerCar  carro;
		public int waveFrames = 40;
		public int frameCounter = 0;
		
		public GeneradorCarros (PlayerCar carro){
			this.carro = carro;
		}
		
		public void update(){
				frameCounter++;
				if (frameCounter >= waveFrames){
					frameCounter=0;
					generateWave();
				}
		}
		
		public void generateWave(){
			int counter=1;
			for (int i=0;i<2;i++){
				if (counter<4){
					if (Math.random()<probabilidadReverse){
						EnemyCarReverse enemigo = new EnemyCarReverse(carro);
						enemigo.position.setLocation(180+68*i,-40);
						instantiate(enemigo);
						counter++;
					}
				}
			}
			for (int i=2;i<4;i++){
				if (counter<4){
					if (Math.random()<probabilidad){
						EnemyCar enemigo = new EnemyCar(carro);
						enemigo.position.setLocation(180+68*i,-40);
						instantiate(enemigo);
						counter++;
					}
				}
			}
			
		}
		

}
