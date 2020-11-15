package com.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TextToSpeech tts=new TextToSpeech();
		Scanner sc=new Scanner(System.in);
		String str=new String();
		while ( !str.contains("bye")){
			System.out.println("Nhap: ");
			str=sc.nextLine();
			if(str.length()>0){
				tts.setVoice("cmu-rms-hsmm");
				tts.speak(str,1.5f,true,true);
			}
		}
	}
	
}
