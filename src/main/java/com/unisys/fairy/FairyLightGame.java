package com.unisys.fairy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.unisys.fairy.controller.GameController;
import com.unisys.fairy.model.Color;
import com.unisys.fairy.model.FairyLight;

public class FairyLightGame{

	public static void main(String[] args) throws InterruptedException
	{

		List<FairyLight> lights = new ArrayList<FairyLight>();

		for (int i = 0; i < 20; i++) {
			Random rnd = new Random();
			Color c = Color.values()[rnd.nextInt(Color.values().length)];
			lights.add(new FairyLight(c, false, i));
		}

		new GameController().play(lights);

	}

}
