package com.unisys.fairy.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.unisys.fairy.model.Color;
import com.unisys.fairy.model.FairyLight;

public class SequenceFairyLightControllerTest {
	
 @Test
  public void testFairyLight_turnOn() throws InterruptedException
  {	 
	 List<FairyLight> lights= new ArrayList<FairyLight>();
	 lights.add(new FairyLight(Color.red,false,1));
	 lights.add(new FairyLight(Color.green,false,2));
	 lights.add(new FairyLight(Color.white,false,3));
	 SequenceFairyLightController controller = new SequenceFairyLightController();
	 controller.play(lights);
	 assertTrue(!lights.get(0).isOn());
	 assertTrue(!lights.get(1).isOn());
	 assertTrue(!lights.get(2).isOn());
  }

}
