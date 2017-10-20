import java.util.concurrent.ThreadLocalRandom;

public class GeneradorCarros extends GameObjectImp{
	
		private double probabilidad = .40,probabilidadReverse = .25;
		private boolean[] lanes = new boolean[4];
		private PlayerCar  carro;
		public int waveFrames = 40;
		public int frameCounter = 0;
		public boolean iniciado=false;
		
		
		public GeneradorCarros (PlayerCar carro){
			this.carro = carro;
		}
		
		public void update(){
				if (carro.isDead() ){
					return;
				}
				if (iniciado==false){
					if (carro.getSpeed()==200){
						iniciado = true;
					} else {
						return;
					}
				}
				frameCounter++;
				if (carro.getDistancia()/220000>1){
					generateGasoline();
					carro.setDistancia(0);
					System.out.println("GASOLINA PAPS");
				}
				if (frameCounter >= waveFrames){
					frameCounter=0;
					generateWave();
				}
		}
		private void generateGasoline(){
			Gasolina gas = new Gasolina(carro);
			int lane = ThreadLocalRandom.current().nextInt(0, 4);
			gas.position.setLocation(180+68*lane,-120);
			instantiate(gas);
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
						EnemyCar enemigo = new EnemyCarNormal(carro);
						enemigo.position.setLocation(180+68*i,-40);
						instantiate(enemigo);
						counter++;
					}
				}
			}
			
		}
		

}
