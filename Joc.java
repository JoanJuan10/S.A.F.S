import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Joc {
	BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
	
	public static void daño (int cantidadDaño, int mana, int jugadorAfectado) {

		if (jugadorAfectado == 1) {
			if (escudoJugador) {
				turnosEscudoJugador--;
				System.out.println("Has bloqueado el ataque enemigo!");
				if (turnosEscudoJugador == 0) {
					escudoJugador = false;
					System.out.println("El escudo enemigo se ha roto!");
				}
			}
			else {
				System.out.println("El enemigo ha perdido " + mana + " puntos de mana");
				mp2 -= mana;
				System.out.println("Has recibido " + cantidadDaño + " puntos de daño");
				hp1 -= cantidadDaño;
			}
		}
		else {
			if (escudoMaquina) {
				turnosEscudoMaquina--;
				System.out.println("El enemigo ha bloqueado tu ataque!");
				if (turnosEscudoMaquina == 0) {
					escudoMaquina = false;
					System.out.println("El escudo enemigo se ha roto!");
				}
			}
			else {
				System.out.println("Has perdido " + mana + " puntos de mana");
				mp1 -= mana;
				System.out.println("Has realizado " + cantidadDaño + " puntos de daño al enemigo");
				hp2 -= cantidadDaño;
			}
		}
	}
	public static void curacion (int cantidadCurado, int mana, int jugadorAfectado) {

		if (jugadorAfectado == 1) {
			System.out.println("Has perdido " + mana + " puntos de mana");
			mp1 -= mana;
			System.out.println("Te has curado " + cantidadCurado + " puntos de vida");
			hp1 += cantidadCurado;
		}
		else {
			System.out.println("El enemigo ha perdido " + mana + " puntos de mana");
			mp2 -= mana;
			System.out.println("El enemigo se ha recuperado " + cantidadCurado + " puntos de vida");
			hp2 += cantidadCurado;
		}
	}
	public static void escudo (int cantidadTurnos, int mana, int jugadorAfectado) {
		if (jugadorAfectado == 1) {
			System.out.println("Has perdido " + mana + " puntos de mana");
			mp1 -= mana;
			System.out.println("Has obtenido un escudo! (DURACION: " + cantidadTurnos + " TURNOS)");
			escudoJugador = true;
			turnosEscudoJugador = cantidadTurnos;
		}
		else {
			System.out.println("El enemigo ha perdido " + mana + " puntos de mana");
			mp2 -= mana;
			System.out.println("El enemigo obtiene un escudo! (DURACION: " + cantidadTurnos + " TURNOS)");
			escudoMaquina = true;
			turnosEscudoMaquina = cantidadTurnos;
		}
	}

	public static int hp1 = 0;
	public static int hp2 = 0;
	public static int mp1 = 0;
	public static int mp2 = 0;
	public static boolean escudoJugador = false;
	public static boolean escudoMaquina = false;
	public static int turnosEscudoJugador = 0;
	public static int turnosEscudoMaquina = 0;
	
	/*
	 * Para obtener un numero random:
	 * (int)(Math.random() * ((MAX - MIN) + 1)) + MIN
	 */
	public static void juego() throws IOException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		int mmenu;
		int mmenuesp;
		int mmenumagia;
		boolean noataque;
		boolean rendicion;
		int teclaespecialmenu;
		int teclamagiamenu;
		int tecla;
		int turno;
		System.out.println("Elige tu Modo de Juego:");
		System.out.println("");
		System.out.println("");
		System.out.println("1- Facil");
		System.out.println("2- Medio");
		System.out.println("3- Dificil");
		System.out.println("4- INSANE");
		boolean difElegida = false;
		int dificultad = teclado.nextInt();
		while (!difElegida) {
			if (dificultad==1) {
				hp1 = 4000;
				mp1 = 700;
				hp2 = 3000;
				mp2 = 600;
				difElegida = true;
			}
			else if (dificultad==2) {
				hp1 = 3000;
				mp1 = 600;
				hp2 = 3000;
				mp2 = 600;
				difElegida = true;
			}
			else if (dificultad==3) {
				hp1 = 3500;
				mp1 = 650;
				hp2 = 4000;
				mp2 = 700;
				difElegida = true;
			}
			else if (dificultad==4) {
				hp1 = 3000;
				mp1 = 600;
				hp2 = 5000;
				mp2 = 750;
				difElegida = true;
			}
			else {
				System.out.println("Dificultad no valida. Vuelva a elegir");
			}
		}
		turno = 0;
		escudoJugador = false;
		escudoMaquina = false;
		rendicion = false;
		while (hp2 > 0 && hp1 > 0 && rendicion == false) {
			turno = turno + 1;
			System.out.println("");
			System.out.println("Turno "+ turno);
			System.out.println("");
			System.out.println("");
			if (dificultad==1) {
				System.out.println("VIDA DE JUGADOR: "+ hp1 +"/4000");
				System.out.println("MAGIA DE JUGADOR: "+ mp1 +"/700");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+ hp2 +"/3000");
				System.out.println("MAGIA DE MAQUINA: "+ mp2 +"/600");
			}
			else if (dificultad==2) {
				System.out.println("VIDA DE JUGADOR: "+ hp1 +"/3000");
				System.out.println("MAGIA DE JUGADOR: "+ mp1 +"/600");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+ hp2 +"/3000");
				System.out.println("MAGIA DE MAQUINA: "+ mp2 +"/600");
			}
			else if (dificultad==3) {
				System.out.println("VIDA DE JUGADOR: "+ hp1 +"/3500");
				System.out.println("MAGIA DE JUGADOR: "+ mp1 +"/650");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+ hp2 +"/4000");
				System.out.println("MAGIA DE MAQUINA: "+ mp2 +"/700");
			}
			else if (dificultad==4) {
				System.out.println("VIDA DE JUGADOR: "+ hp1 +"/3000");
				System.out.println("MAGIA DE JUGADOR: "+ mp1 +"/700");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+ hp2 +"/5000");
				System.out.println("MAGIA DE MAQUINA: "+ mp2 +"/750");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Define con las teclas que ataque realizar:");
			System.out.println("Ataque -> 1");
			System.out.println("Magia -> 2");
			System.out.println("Especial -> 3");
			System.out.println("");
			System.out.println("");
			System.out.println("Rendirse -> 4");
			System.out.println("");
			// TURNO DE JUGADOR
			tecla = teclado.nextInt();
			// Ataque Normal
			if (tecla <= 4 && tecla >= 1) {
				if (tecla == 1) {
					daño((int)(Math.random() * ((150 - 100) + 1)) + 100, 0, 2);
					Thread.sleep(3*1000);
				}
				// Menu de Magia
				else if (tecla == 2) {
					System.out.println("Elige la Magia:");
					System.out.println("1- BioAttack: -50 MP");
					System.out.println("2- FireWave: -25 MP");
					teclamagiamenu = teclado.nextInt();
					// BioAttack
					if (teclamagiamenu == 1) {
						if (mp1 >= 50) {
							daño((int)(Math.random() * ((650 - 250) + 1)) + 250, 50, 2);
							Thread.sleep(3*1000);
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
					// FireWave
					else if (teclamagiamenu == 2) {
						if (mp1 >= 25) {
							daño((int)(Math.random() * ((450 - 150) + 1)) + 150, 0, 2);
							Thread.sleep(3*1000);
						} 
						else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
				}
				// Menu Especial
				else if (tecla == 3) {
					System.out.println("Elige tu Ataque Especial:");
					System.out.println("1- Heal: -75 MP (MAX 3000 HP)");
					System.out.println("2- E.Shield: -45 MP");
					System.out.println("3- Destruction: -150 MP");
					teclaespecialmenu = teclado.nextInt();
					// Heal
					if (teclaespecialmenu == 1) {
						if (mp1 >= 75 && hp1 < 3000) {
							curacion((int)(Math.random() * ((600 - 500) + 1)) + 500, 75, 1);
							Thread.sleep(3*1000);
							if (hp1 < 3000) {
								hp1 = 3000;
								System.out.println("No te puedes curar más de 3000 de vida.");
							}
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente o tu HP esta por encima de 3000");
							Thread.sleep(3*1000);
						}
					}
					// Escudo
					else if (teclaespecialmenu == 2) {
						if (mp1>=45) {
							escudo(2, 45, 1);
							Thread.sleep(3*1000);
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
					// Destruction
					else if (teclaespecialmenu == 3) {
						if (mp1>=150) {
							daño((int)(Math.random() * ((900 - 100) + 1)) + 100, 150, 2);
							Thread.sleep(2*1000);
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
				}
				else if (tecla == 4) {
					rendicion = true;
					System.out.println("TE HAS RENDIDO!!");
					Thread.sleep(3*1000);
				}
			}
			else {
				System.out.println("Error. Turno Saltado por elegir un ataque NO VALIDO");
				Thread.sleep(3*1000);
			}
			// TURNO DE LA MAQUINA
			System.out.println(""); // no hay forma directa de borrar la consola en Java
			if (!rendicion) {
				System.out.println("Turno del Enemigo");
				mmenu = 0;
				mmenumagia = 0;
				mmenuesp = 0;
			}
			noataque = true;
			while (noataque && rendicion == false && hp2 > 0) {
				mmenu = (int)(Math.random() * ((4 - 1) + 1)) + 1;//aleatorio(1,4);
				// Ataque Normal
				if (hp2 > 1500 && mp2 >= 75) {
					mmenu = 4;
				}
				if (mp2 < 25) {
					mmenu = 1;
				}
				if (mmenu==1) {
					daño((int)(Math.random() * ((200 - 150) + 1)) + 150, 0, 1);
					noataque = false;
					Thread.sleep(3*1000);
				}
				// Menu Magia
				if (mmenu==2 || mmenu==3) {
					mmenumagia = (int)(Math.random() * ((2 - 1) + 1)) + 1;//aleatorio(1,2);
					if (mmenumagia==1 && mp2>=25) {
						System.out.println("Enemigo uso: SDash!");
						daño((int)(Math.random() * ((500 - 250) + 1)) + 250, 25, 1);
						noataque = false;
						Thread.sleep(3*1000);
					}
					if (mmenumagia==2 && mp2>=80) {
						
						System.out.println("Enemigo uso: Shadow Orb!");
						daño((int)(Math.random() * ((400) + 1)) + 400, 80, 1);
						noataque = false;
						Thread.sleep(3*1000);
					}
				}
				// Menu ESP
				if (mmenu == 4) {
					mmenuesp = (int)(Math.random() * ((3 - 1) + 1)) + 1;//aleatorio(1,3);
					if (mmenuesp == 1 && mp2 >= 75 && hp2 > 2000) {
						
						System.out.println("Enemigo uso: HEAL!");
						curacion((int)(Math.random() * ((550) + 1)) + 550, 75, 2);
						if (hp2 > 3000) {
							hp2 = 3000;
						}
						noataque = false;
						Thread.sleep(3*1000);
					}
					if (mmenuesp==2 && mp2>=50) {
						System.out.println("Enemigo uso: Lluvia Acida!");
						daño((int)(Math.random() * ((750 - 150) + 1)) + 150, 80, 1);
						noataque = false;
						Thread.sleep(4*1000);
					}
					if (mmenuesp==3 && mp2>=120) {
						System.out.println("Enemigo uso: BLACK HOLE!");
						daño((int)(Math.random() * ((1400 - 500) + 1)) + 500, 140, 1);
						noataque = false;
						Thread.sleep(4*1000);
					}
				}
			}
		}
		System.out.println("");
		if (hp2<=0) {
			System.out.println("Has Ganado!!");
			System.out.println("");
			System.out.println("");
			Thread.sleep(2*1000);
		}
		if (hp1<=0 || rendicion==true) {
			System.out.println("Has Perdido!!");
			System.out.println("");
			System.out.println("");
			Thread.sleep(2*1000);
		}
		System.out.println("VIDA DE JUGADOR: "+ hp1);
		System.out.println("VIDA DE MAQUINA: "+ hp2);
		}

	public static void main(String args[]) throws IOException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		String menu;
		menu = "";
		System.out.println("Quieres Empezar a Jugar?");
		menu = teclado.next();
		if (menu.equalsIgnoreCase("si")) {
			juego();
		} else {
			Thread.sleep(3*1000);
			System.out.println("Y ahora?");
			menu = teclado.next();
			if (menu.equalsIgnoreCase("si")) {
				juego();
			} else {
				System.out.println("Pues nada tio, adios.");
			}
		}
	}


}
