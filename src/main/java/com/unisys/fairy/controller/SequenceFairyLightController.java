package com.unisys.fairy.controller;

import java.util.List;

import com.unisys.fairy.model.FairyLight;

public class SequenceFairyLightController implements FairyLightController {

	public void play(List<FairyLight> lights) throws InterruptedException
	{
		for(FairyLight light: lights)
		{
			light.setOn(true);
			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e)
			{
				throw new InterruptedException("Light: "+light.getNumber()+" failed");
			}
			light.setOn(false);
		}
	}
}