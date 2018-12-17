/* Este codigo ha sido generado por el modulo psexport 20180125-w32 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo deberï¿½a llamarse "JOC1.java."

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Hay dos errores que se pueden generar al exportar un algoritmo con subprocesos desde PSeint a Java:
// 1) En java no se puede elegir entre pasaje por copia o por referencia. Tï¿½cnicamente solo existe el
// pasaje por copia, pero los identificadores de objetos representan en realidad referencias a los
// objetos. Entonces, el pasaje para tipos nativos actï¿½a como si fuera por copia, mientras que el
// pasaje para objetos (como por ejemplo String) actï¿½a como si fuera por referencia. Esto puede llevar
// a que el algoritmo exportado no se comporte de la misma forma que el algoritmo original, en cuyo
// caso deberï¿½n modificarse algunos mï¿½todos (subprocesos exportados) para corregir el problema.
// 2) Las funciones que hacen lectura por teclado deben lazar una excepciï¿½n. Si una funciï¿½n A es
// invocada por otra B, B tambiï¿½n debe manejar (lanzar en este caso) las execpciones que lance A.
// Esto no se cumple en el cï¿½digo generado automï¿½ticamante: las funciones que realizan lecturas
// directamente incluyen el cï¿½digo que indica que pueden generar dicha excepciï¿½n, pero las que
// lo hacen indirectamente (invocando a otras que sï¿½ lo hacen), puede que no, y deberï¿½n ser
// corregidas manualmente.
import java.util.Scanner;

public class Joc {
	BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));

	public static int firewave(double mp1) {
		int damage;
		// Ataque de Jugador
		mp1 = mp1-25;
		damage = (int)(Math.random() * ((450 - 150) + 1)) + 150;
		return damage;
	}

	public static int bioattack(double mp1) {
		int damage;
		// Ataque de Jugador
		mp1 = mp1-50;
		damage = (int)(Math.random() * ((650 - 250) + 1)) + 250; //aleatorio(250,650);
		return damage;
	}

	public static int heal(double mp1) {
		int curar;
		// Ataque de Jugador
		mp1 = mp1-75;
		curar = (int)(Math.random() * ((600 - 500) + 1)) + 500;//aleatorio(500,600);
		return curar;
	}

	public static int ataque() {
		int damage;
		// Ataque de Jugador
		damage = (int)(Math.random() * ((150 - 100) + 1)) + 100;//aleatorio(100,150);
		return damage;
	}

	public static int destruction(double mp1) {
		int damage;
		// Ataque de Jugador ESPECIAL
		mp1 = mp1-150;
		damage = (int)(Math.random() * ((900 - 100) + 1)) + 100;//aleatorio(100,900);
		return damage;
	}

	// ATAQUES DE MAQUINA
	public static int ataque2() {
		int damage;
		// Ataque de Maquina
		damage = (int)(Math.random() * ((200 - 150) + 1)) + 150;//aleatorio(150,200);
		return damage;
	}

	public static int heal2(double mp2) {
		int curar;
		// Ataque de Maquina
		mp2 = mp2-75;
		curar = (int)(Math.random() * ((550) + 1)) + 550;//aleatorio(550,650);
		return curar;
	}

	public static int sdash(double mp2) {
		int damage;
		// Ataque de Maquina
		mp2 = mp2-25;
		damage = (int)(Math.random() * ((500 - 250) + 1)) + 250;//aleatorio(250,500);
		return damage;
	}

	public static int shadoworb(double mp2) {
		int damage;
		// Ataque de Maquina
		mp2 = mp2-80;
		damage = (int)(Math.random() * ((400) + 1)) + 400;//aleatorio(400,700);
		return damage;
	}

	public static int blackhole(double mp2) {
		int damage;
		// Ataque de Maquina
		mp2 = mp2-140;
		damage = (int)(Math.random() * ((1400 - 500) + 1)) + 500;//aleatorio(500,1400);
		return damage;
	}

	public static int arain(double mp2) {
		int damage;
		// Ataque de Maquina
		mp2 = mp2-50;
		damage = (int)(Math.random() * ((400 - 100) + 1)) + 100;//aleatorio(100,400);
		damage += (int)(Math.random() * ((100 - 50) + 1)) + 50;//damage+aleatorio(50,100);
		damage += (int)(Math.random() * ((80 - 40) + 1)) + 40;//damage+aleatorio(40,80);
		damage += (int)(Math.random() * ((80 - 30) + 1)) + 30;//damage+aleatorio(30,80);
		damage += (int)(Math.random() * ((70 - 15) + 1)) + 15;//damage+aleatorio(15,70);
		return damage;
	}

	public static void juego() throws IOException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		double cura;
		double dmg;
		boolean escudo;
		double hp1 = 0;
		double hp2 = 0;
		int mmenu;
		int mmenuesp;
		int mmenumagia;
		double mp1 = 0;
		double mp2 = 0;
		boolean noataque;
		boolean rendicion;
		char teclamenu;
		char teclaespecialmenu;
		char teclamagiamenu;
		char teclaelegirmagia1 = '1';
		char teclaelegirmagia2 = '2';
		char teclaelegirespecial1 = '1';
		char teclaelegirespecial2 = '2';
		char teclaelegirespecial3 = '3';
		char tecla;
		double turno;
		double vidae = 0;
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
		escudo = false;
		rendicion = false;
		while (hp2>0 && hp1>0 && rendicion==false) {
			turno = turno+1;
			System.out.println(""); // no hay forma directa de borrar la consola en Java
			System.out.println("Turno "+(int)turno);
			System.out.println("");
			System.out.println("");
			if (dificultad==1) {
				System.out.println("VIDA DE JUGADOR: "+ (int)hp1 +"/4000");
				System.out.println("MAGIA DE JUGADOR: "+(int)mp1+"/700");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+(int)hp2+"/3000");
				System.out.println("MAGIA DE MAQUINA: "+(int)mp2+"/600");
			}
			else if (dificultad==2) {
				System.out.println("VIDA DE JUGADOR: "+(int)hp1+"/3000");
				System.out.println("MAGIA DE JUGADOR: "+(int)mp1+"/600");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+(int)hp2+"/3000");
				System.out.println("MAGIA DE MAQUINA: "+(int)mp2+"/600");
			}
			else if (dificultad==3) {
				System.out.println("VIDA DE JUGADOR: "+(int)hp1+"/3500");
				System.out.println("MAGIA DE JUGADOR: "+(int)mp1+"/650");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+(int)hp2+"/4000");
				System.out.println("MAGIA DE MAQUINA: "+(int)mp2+"/700");
			}
			else if (dificultad==4) {
				System.out.println("VIDA DE JUGADOR: "+(int)hp1+"/3000");
				System.out.println("MAGIA DE JUGADOR: "+(int)mp1+"/700");
				System.out.println("");
				System.out.println("VIDA DE MAQUINA: "+(int)hp2+"/5000");
				System.out.println("MAGIA DE MAQUINA: "+(int)mp2+"/750");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Defineix amb les tecles quin atac vols fer:");
			System.out.println("Ataque -> 1");
			System.out.println("Magia -> 2");
			System.out.println("Especial -> 3");
			System.out.println("");
			System.out.println("");
			System.out.println("Rendirse -> 4");
			System.out.println("");
			teclamenu = '1';
			teclamagiamenu = '2';
			teclaespecialmenu = '3';
			char teclarendicion = '4';
			// TURNO DE JUGADOR
			tecla = teclado.next().charAt(0);
			// Ataque Normal
			if (tecla <= '4' && tecla >= '1') {
				if (teclamenu == tecla) {
					dmg = ataque();
					hp2 = hp2-dmg;
					System.out.println("Has realizado "+(int)dmg+" puntos de daÃ±o a la vida del enemigo");
					Thread.sleep(3*1000);
				}
				// Menu de Magia
				else if (teclamagiamenu == tecla) {
					System.out.println("Elige la Magia:");
					System.out.println("1- BioAttack: -50 MP");
					System.out.println("2- FireWave: -25 MP");
					teclamagiamenu = teclado.next().charAt(0);
					// BioAttack
					if (teclamagiamenu == teclaelegirmagia1) {
						if (mp1>=50) {
							dmg = bioattack(mp1);
							hp2 = hp2-dmg;
							System.out.println("Has realizado "+(int)dmg+" puntos de daÃ±o a la vida del enemigo");
							Thread.sleep(3*1000);
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
					// FireWave
					else if (teclamagiamenu == teclaelegirmagia2) {
						if (mp1>=25) {
							dmg = firewave(mp1);
							hp2 = hp2-dmg;
							System.out.println("Has realizado "+(int)dmg+" puntos de daÃ±o a la vida del enemigo");
							Thread.sleep(3*1000);
						} 
						else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
				}
				// Menu Especial
				else if (tecla == teclaespecialmenu) {
					System.out.println("Elige tu Ataque Especial:");
					System.out.println("1- Heal: -75 MP");
					System.out.println("2- E.Shield: -45 MP");
					System.out.println("3- Destruction: -150 MP");
					teclaespecialmenu = teclado.next().charAt(0);
					// Heal
					if (teclaelegirespecial1 == teclaespecialmenu) {
						if (mp1>=75 && hp1<3000) {
							cura = heal(hp1);
							hp1 = hp1+cura;
							System.out.println("Te has recuperado "+(int)cura+" puntos de vida");
							Thread.sleep(3*1000);
							if (hp1<3000) {
								hp1 = 3000;
							}
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente o tu HP estÃ¡ al mÃ¡ximo");
							Thread.sleep(3*1000);
						}
					}
					// Escudo
					else if (teclaelegirespecial2 == teclaespecialmenu) {
						if (mp1>=45) {
							mp1 = mp1-45;
							escudo = true;
							vidae = 2;
							System.out.println("Has usado un escudo que durarÃ¡ 2 ataques enemigos!");
							Thread.sleep(3*1000);
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
					// Destruction
					else if (teclaelegirespecial3 == teclaespecialmenu) {
						if (mp1>=150) {
							mp1 = mp1-150;
							dmg = destruction(mp1);
							hp2 = hp2-dmg;
							System.out.println("Has realizado "+(int)dmg+" puntos de daÃ±o a la vida del enemigo");
							Thread.sleep(2*1000);
							if (dmg>450) {
								System.out.println("Â¡El ataque fue efectivo!");
								Thread.sleep(3*1000);
							} else {
								System.out.println("Â¡El ataque no le hizo ni cosquillas!");
								Thread.sleep(3*1000);
							}
						} else {
							System.out.println("Turno Saltado. No tienes MP suficiente");
							Thread.sleep(3*1000);
						}
					}
				}
				else if (tecla == teclarendicion) {
					rendicion = true;
					System.out.println("Â¡Â¡TE HAS RENDIDO!!");
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
			while (noataque && escudo==false && rendicion==false && hp2>0) {
				mmenu = (int)(Math.random() * ((4 - 1) + 1)) + 1;//aleatorio(1,4);
				// Ataque Normal
				if (hp2>1500 && mp2>=75) {
					mmenu = 4;
				}
				if (mp2<25) {
					mmenu = 1;
				}
				if (mmenu==1) {
					dmg = ataque2();
					hp1 = hp1-dmg;
					System.out.println("Enemigo atacÃ³!");
					System.out.println("Has recibido "+(int)dmg+" puntos de daÃ±o a tu vida");
					noataque = false;
					Thread.sleep(3*1000);
				}
				// Menu Magia
				if (mmenu==2 || mmenu==3) {
					mmenumagia = (int)(Math.random() * ((2 - 1) + 1)) + 1;//aleatorio(1,2);
					if (mmenumagia==1 && mp2>=25) {
						dmg = sdash(mp2);
						hp1 = hp1-dmg;
						System.out.println("Enemigo usÃ³: SDash!");
						System.out.println("Has recibido "+(int)dmg+" puntos de daÃ±o a tu vida");
						noataque = false;
						Thread.sleep(3*1000);
					}
					if (mmenumagia==2 && mp2>=80) {
						dmg = shadoworb(mp2);
						hp1 = hp1-dmg;
						System.out.println("Enemigo usÃ³: Shadow Orb!");
						System.out.println("Has recibido "+(int)dmg+" puntos de daÃ±o a tu vida");
						noataque = false;
						Thread.sleep(3*1000);
					}
				}
				// Menu ESP
				if (mmenu==4) {
					mmenuesp = (int)(Math.random() * ((3 - 1) + 1)) + 1;//aleatorio(1,3);
					if (mmenuesp==1 && mp2>=75 && hp2>2000) {
						cura = heal2(mp2);
						hp2 = hp2+cura;
						if (hp2>3000) {
							hp2 = 3000;
						}
						System.out.println("Enemigo usÃ³: HEAL!");
						System.out.println("");
						System.out.println("El enemigo se ha recuperado "+(int)cura+" puntos de vida");
						noataque = false;
						Thread.sleep(3*1000);
					}
					if (mmenuesp==2 && mp2>=50) {
						dmg = arain(mp2);
						hp1 = hp2-dmg;
						System.out.println("Enemigo usÃ³: Lluvia Acida!");
						System.out.println("Has recibido DaÃ±o Continuado.");
						System.out.println("Has recibido un total de "+(int)dmg+" puntos de daÃ±o a tu vida");
						noataque = false;
						Thread.sleep(4*1000);
					}
					if (mmenuesp==3 && mp2>=120) {
						dmg = blackhole(mp2);
						hp1 = hp1-dmg;
						System.out.println("Enemigo usÃ³: BLACK HOLE!");
						System.out.println("Es muy efectivo contra tÃ­!");
						System.out.println("Has recibido un total de "+(int)dmg+" puntos de daÃ±o a tu vida");
						noataque = false;
						Thread.sleep(4*1000);
					}
				}
			}
			if (escudo==true) {
				System.out.println("Â¡Has bloqueado el ataque enemigo!");
				Thread.sleep(3*1000);
				vidae = vidae-1;
				if (vidae==0) {
					escudo = false;
					System.out.println("Â¡El ESCUDO se ha roto!");
					Thread.sleep(3*1000);
				}
			}
		}
		System.out.println(""); // no hay forma directa de borrar la consola en Java
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
		System.out.println("VIDA DE JUGADOR: "+(int)hp1);
		System.out.println("VIDA DE MAQUINA: "+(int)hp2);
		}

	public static void main(String args[]) throws IOException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		String menu;
		menu = "";
		System.out.println("Quieres Empezar a Jugar?");
		menu = teclado.next();
		if (menu.equals("Si") || menu.equals("si") || menu.equals("SI")) {
			juego();
		} else {
			Thread.sleep(3*1000);
			System.out.println("Y ahora?");
			menu = teclado.next();
			if (menu.equals("Si") || menu.equals("si") || menu.equals("SI")) {
				juego();
			} else {
				System.out.println("Pues nada tio, adios.");
			}
		}
	}


}
