package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.soundsystem.CDPlayer;
import com.douzone.container.soundsystem.CompactDisc;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})  //resource가 아닌 java에 있다.
public class DVDPlayerJavaConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd;

	@Autowired
	private DVDPlayer dvdplayer;
	
	@Test
	public void testDVDNotNull() {
		
		assertNotNull(dvd);
	}
	
	@Test
	public void testDVDPlayerNotNull() {
		
		assertNotNull(dvdplayer);
	}
	

	
}
