package com.gamemaker.team6.behaviour;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.model.Component;

import junit.framework.Assert;

class StayReactionTest {

	private Component primary;
	private Component secondary;
	private Component tertiary;
	private List<Component> components = new ArrayList<Component>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		primary = Mockito.mock(Component.class);
		when(primary.getPosX()).thenReturn(50);
		when(primary.getPosY()).thenReturn(50);
		when(primary.getHeight()).thenReturn(100);
		when(primary.getWidth()).thenReturn(10);

		
		//primary.getPosX()
		
	    secondary = Mockito.mock(Component.class);
		when(secondary.getPosX()).thenReturn(40);
		when(secondary.getPosY()).thenReturn(60);
		when(secondary.getHeight()).thenReturn(30);
		when(secondary.getWidth()).thenReturn(30);
		
		
		
		tertiary = Mockito.mock(Component.class);
		
		when(tertiary.getPosX()).thenReturn(300);
		when(tertiary.getPosY()).thenReturn(300);
		when(tertiary.getHeight()).thenReturn(30);
		when(tertiary.getWidth()).thenReturn(30);
		
		
		components.add(secondary);
		components.add(tertiary);
		components.add(primary);
		
	}
	@Test
	void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		StayReaction stayReaction = new StayReaction();
		assertEquals(true, stayReaction.react(primary, components));
		
	}
	@Test
	void testDoesReact() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction bounceBack = new BounceBack();
		bounceBack.react(primary, components);
		assertEquals(true, bounceBack.react(primary, components));
		assertEquals(true, bounceBack.react(secondary, components));
		assertEquals(false, bounceBack.react(tertiary, components));
	}

}
