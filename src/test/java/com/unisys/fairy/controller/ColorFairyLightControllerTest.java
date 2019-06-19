package com.unisys.fairy.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.unisys.fairy.model.Color;
import com.unisys.fairy.model.FairyLight;

public class ColorFairyLightControllerTest {
	
 @Test
  public void testFairyLight_turnOn() throws InterruptedException
  {	 
	 List<FairyLight> lights= new ArrayList<FairyLight>();
	 lights.add(new FairyLight(Color.red,false,1));
	 lights.add(new FairyLight(Color.green,false,2));
	 lights.add(new FairyLight(Color.white,false,3));
	 lights.add(new FairyLight(Color.red,false,4));
	 lights.add(new FairyLight(Color.green,false,5));
	 lights.add(new FairyLight(Color.white,false,6));
	 ColorFairyLightController controller = new ColorFairyLightController();
	 controller.play(lights);
	 assertFalse(lights.stream().filter(l->l.isOn()==true).findAny().isPresent());
  }

}
