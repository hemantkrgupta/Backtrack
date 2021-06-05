package com.backtrack;

import java.util.Scanner;

public class Sudoku {
	public static void main(String... args){
//		int[][] sudoku = readInput();
		int[][] sudoku = getSudoku();
		System.out.println("initial\n");
		printSudoku(sudoku);
		solveSudoku(sudoku);
		System.out.println("\nfinal\n");
		printSudoku(sudoku);
	}
	
	public static void printSudoku(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println("\n\n");
	}
	
	public static int[][] getSudoku(){		
		return new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
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

	public static boolean isValid(int[][] sudoku, int row, int col) {
		int num = sudoku[row][col];
//		Check row
		for(int i=0;i<9;i++) {
			if(row!=i && sudoku[i][col]==num) {
				sudoku[row][col]=0;
				return false;
			}
		}
//		Check column
		for(int i=0;i<9;i++) {
			if(col!=i && sudoku[row][i]==num) {
				sudoku[row][col]=0;
				return false;
			}
		}
//		Check 3*3 matrix
		for(int i=(row/3)*3;i<(row/3)*3+3;i++) {
			for(int j=(col/3)*3;j<(col/3)*3+3;j++) {
				if(i!=row && j!=col && sudoku[i][j]==num) {
					sudoku[row][col]=0;
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solveSudoku(int[][] sudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sudoku[i][j]==0) {
					for(int k=1;k<=9;k++) {
						sudoku[i][j]=k;
//						printSudoku(sudoku);
						if(isValid(sudoku, i, j) && solveSudoku(sudoku)) {							
							return true;
						}
					}
					sudoku[i][j]=0;
					return false;
				}
			}
		}
		return true;
	}
}
