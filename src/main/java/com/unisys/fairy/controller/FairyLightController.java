package com.unisys.fairy.controller;

import java.util.List;

import com.unisys.fairy.model.FairyLight;

public interface FairyLightController {
	
	public void play(List<FairyLight> lights) throws InterruptedException;

}
