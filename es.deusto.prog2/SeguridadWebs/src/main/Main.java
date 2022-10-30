package main;

import java.util.ArrayList;
import java.util.Map;

import internet.*;
import java.util.Random;

public class Main {
	

	public static void main(String[] args) {
		Random rand = new Random();
		int limite = 25;
		int limite1 = 1000;
		int numeroAleatorio = rand.nextInt(limite);
		int numeroAleatorio1 = rand.nextInt(limite1);
		
		
		Web w1 = new Web("askartza","eus",20190714,TipoWebs.texto);
		Web w2 = new Web("askartza","eus",20190714,TipoWebs.texto);
		Web w3 = new Web("askartza","eus",20120714,TipoWebs.texto);
		Web w4 = new Web("askartza","eus",20190714,TipoWebs.texto);
		Web w5 = new Web("askartza","es",20190714,TipoWebs.texto);
		Web w6 = new Web("askartza","es",20190714,TipoWebs.texto);
		Web w7 = new Web("askartza","es",20190714,TipoWebs.texto);
		Web w8 = new Web("askartza","es",20190714,TipoWebs.texto);
		Web w9 = new Web("askartza","cat",20190714,TipoWebs.texto);
		Web w10 = new Web("askartza","cat",20190714,TipoWebs.texto);
		Web w11 = new Web("askartza","cat",20190714,TipoWebs.video);
		Web w12 = new Web("askartza","cat",20190714,TipoWebs.video);
		Web w13 = new Web("askartza","cat",20190714,TipoWebs.video);
		Web w14 = new Web("askartza","eng",20190714,TipoWebs.video);
		Web w15 = new Web("askartza","eng",20190714,TipoWebs.video);
		Web w16 = new Web("askartza","eng",20190714,TipoWebs.video);
		Web w17 = new Web("askartza","cat",20150714,TipoWebs.video);
		Web w18 = new Web("askartza","eng",20200714,TipoWebs.video);
		Web w19 = new Web("askartza","eng",20150714,TipoWebs.video);
		Web w20 = new Web("askartza","eng",20170714,TipoWebs.video);
		
		ArrayList<Web> aw1 = new ArrayList<Web>();
		aw1.add(w1);
		aw1.add(w2);
		aw1.add(w3);
		aw1.add(w4);
		aw1.add(w5);
		aw1.add(w6);
		aw1.add(w7);
		aw1.add(w8);
		aw1.add(w9);
		aw1.add(w10);
		
		ArrayList<Web> aw2 = new ArrayList<Web>();
		aw2.add(w1);
		aw2.add(w2);
		aw2.add(w3);
		aw2.add(w4);
		aw2.add(w5);
		aw2.add(w6);
		aw2.add(w7);
		aw2.add(w8);
		aw2.add(w9);
		aw2.add(w10);
		
		ArrayList<Web> aw3 = new ArrayList<Web>();
		aw3.add(w11);
		aw3.add(w12);
		aw3.add(w13);
		aw3.add(w14);
		aw3.add(w15);
		aw3.add(w16);
		aw3.add(w17);
		aw3.add(w18);
		aw3.add(w19);
		aw3.add(w20);
		
		
		TrackerTexto tt1 = new TrackerTexto("Librerias",aw1,numeroAleatorio,numeroAleatorio1);
		TrackerTexto tt2 = new TrackerTexto("Enciclopedias",aw1,numeroAleatorio,numeroAleatorio1);
		TrackerTexto tt3 = new TrackerTexto("Resorts",aw2,numeroAleatorio,numeroAleatorio1);
		TrackerVideo tt4 = new TrackerVideo("VideoPlataformas",aw3,numeroAleatorio1,numeroAleatorio1, numeroAleatorio1);
		TrackerVideo tt5 = new TrackerVideo("RedesSociales",aw3,numeroAleatorio1,numeroAleatorio1, numeroAleatorio1);
		TrackerVideo tt6 = new TrackerVideo("Otros",aw3,numeroAleatorio1,numeroAleatorio1, numeroAleatorio1);
		
		ArrayList<Tracker> tl1 = new ArrayList<Tracker>();
		tl1.add(tt1);
		tl1.add(tt6);
		tl1.add(tt3);
		
		ArrayList<Tracker> tl2 = new ArrayList<Tracker>();
		tl2.add(tt4);
		tl2.add(tt2);
		tl2.add(tt1);
		
		ArrayList<Tracker> tl3 = new ArrayList<Tracker>();
		tl3.add(tt3);
		tl3.add(tt5);
		tl3.add(tt1);
		
		Sesion s1 = new Sesion(20220323,20220330,1300,1823,"DeustoExamen",tl1);
		Sesion s2 = new Sesion(20220323,20220330,1300,1823,"FBI",tl2);
		Sesion s3 = new Sesion(20220323,20220330,1300,1823,"CNI",tl3);
		
		System.out.println(s1);
		System.out.println(s3);
		System.out.println(s2);
		
		//Map<w1.get,> mapa = new Map<>();
	}

}
