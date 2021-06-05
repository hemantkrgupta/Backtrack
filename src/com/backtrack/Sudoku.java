package com.backtrack;

import java.util.Scanner;

public class Sudoku {
	public static void main(String... args){
		int[][] sudoku = readInput();
	}
	
	public static int[][] readInput(){
		Scanner sc = new Scanner(System.in);
		int[][] sudoku = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return sudoku;
	}
}
