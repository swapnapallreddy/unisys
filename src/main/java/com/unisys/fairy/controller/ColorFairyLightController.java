package com.unisys.fairy.controller;

import java.util.List;

import com.unisys.fairy.model.Color;
import com.unisys.fairy.model.FairyLight;

public class ColorFairyLightController implements FairyLightController{

	@Override
	public void play(List<FairyLight> lights) throws InterruptedException {
		
       on(Color.red,lights);
       off(Color.red,lights);
       on(Color.green,lights);
       off(Color.green,lights);
	   on(Color.white,lights);
       off(Color.white,lights);
	}
	
	private void on(Color c, List<FairyLight> lights) throws InterruptedException
	{
		lights.stream().filter(l->l.getColor().equals(c)).forEach(l->l.setOn(true));
		try
		{
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			throw new InterruptedException(c.name()+" lights failed");
		}
		
	}
	
	private void off(Color c, List<FairyLight> lights)
	{
		lights.stream().filter(l->l.getColor().equals(c)).forEach(l->l.setOn(false));
	}

}
