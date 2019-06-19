package com.unisys.fairy.controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import com.unisys.fairy.model.FairyLight;

public class GameController implements FairyLightController {

	private static final int interval =30;
	@Override
	public void play(List<FairyLight> lights) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<Integer> sequenceFuture = executor.submit(new ControllerTask(lights,new SequenceFairyLightController()));
		Future<Integer> colorFuture = executor.submit(new ControllerTask(lights,new ColorFairyLightController()));

		try{
			sequenceFuture.get(interval,TimeUnit.SECONDS);
		}catch(TimeoutException e){
			try {
				colorFuture.get(interval,TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
			} catch (ExecutionException e1) {
			} catch (TimeoutException e1) {
			}
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}

	}


	private class ControllerTask implements Callable<Integer> {
		private FairyLightController controller;
		private List<FairyLight> lights;

		public ControllerTask(List<FairyLight> lights, FairyLightController controller){
			this.lights = lights;
			this.controller = controller;
		}
		public Integer call() throws InterruptedException {
			while(true) {
				controller.play(lights);
			}
		}
	}
}