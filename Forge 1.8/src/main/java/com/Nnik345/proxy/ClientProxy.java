package com.Nnik345.proxy;

import com.Nnik345.init.TutorialBlocks;
import com.Nnik345.init.TutorialItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		TutorialItems.registerRenders();
		TutorialBlocks.registerRenders();
	}
	
}
