package appTransport;

import java.util.Random;
import java.util.Scanner;

public class UnderOverSeven {
	public static void main (String[] args)
	{
		Random r = new Random();
		int x ,y ;
		x = r.nextInt(7); // x reçoit un nombre aléatoire entre 1 et 100
		y = r.nextInt(7);

		System.out.println("Bienvenue au jeu Under Or Over 7");
		System.out.println("Les Principes du jeu");
		System.out.println("On va tourner deux Dados");
		System.out.println("Leurs somme sera ? ");
		System.out.println("	Over 	7	Choice 1		WIN == * 2.4 ");
		System.out.println("	Equal	7	Choice 2		WIN == * 5.1 ");
		System.out.println("	Under1	7	Choice 3		WIN == * 2.4 ");
		int p;
		do 
		{
			System.out.println("Taper :	");
			Scanner sc = new Scanner(System.in);
			p = sc.nextInt();
		}while(p!=1 && p!=2 && p!=3);
		int w;
		w = x + y;
		System.out.println("ohhhhhhhhhhhh !!!!!!!");
		System.out.println("Dados 1 : "+x);
		System.out.println("Dados 2 : "+y);
		System.out.println("Dados 1 + Dados 2 = "+w);

				if(p == 1 && w > 7)
				{
					System.out.println("***		Over	::	Mebruk rbe7ty n3awdo nle3bo ?		***");
				}
				else if(p == 2 && w == 7)
				{
					System.out.println("***		Equal	::	Mebruk rbe7ty n3awdo nle3bo ?		***");
				}
				else if(p == 3 && w < 7)
				{
					System.out.println("***		Under	::	Mebruk rbe7ty n3awdo nle3bo ?		***");
				}
				else
				{
					System.out.println("" + "" + "Khserty HHHHHHH hanya mera jaya ?");
				}
		}
	}
