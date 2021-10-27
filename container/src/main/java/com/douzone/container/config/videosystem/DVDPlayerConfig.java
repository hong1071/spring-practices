package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	@Bean	// 꼭 붙어있어야함
	public DigitalVideoDisc avengers() {
		
		return new Avengers();
	}
	
	// 주입(injection)하기 (1)
	// Bean 생성 메소드를 직접 호출하는 방법
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdPlayer01() {
		
		return new DVDPlayer(avengers());		//avengers 호출
	}
	
	// 주입하기 (2)
	// 파라미터로 빈 전달하기
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		
		return new DVDPlayer(dvd);			
	}
	
	// 주입하기 (3)
	// 파라미터로 빈 전달하기
	// setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
	
	// 같은 타입의 빈을 생성할 경우
	// 주입하기 (4)
	// 파라미터로 빈 전달하기
	// setter 주입
	@Bean(name="dvdPlayer04")
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
	
}
