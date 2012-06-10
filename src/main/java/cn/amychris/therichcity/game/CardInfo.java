package cn.amychris.therichcity.game;

import java.awt.Color;
import java.net.URL;

public interface CardInfo {

	String getCardName();
	
	String getCardDescription();
	
	URL getCardImageURL();
	
	Color getColor();
}
