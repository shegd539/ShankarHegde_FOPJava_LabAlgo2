/**
 * 
 */
package com.gl.paymoney.lab1.main;

import java.util.Scanner;

/**
 * 
 * 
 * 		Problem Statement-1
		PayMoney. processes thousands of transactions daily amounting to crores of Rupees. They
		also have a daily target that they must achieve. Given a list of transactions done by
		PayMoney and a daily target, your task is to determine at which transaction PayMoney
		achieves the same. If the target is not achievable, then display the target is not achieved.
 * 
 */

/**
 * @author shankar
 *
 */
public class PayMoneyTranscationLab1 {

	public static void main(String args[]) throws Exception {

		try (Scanner userInput = new Scanner(System.in);) {

			System.out.println("Please enter the size of transaction array");
			int size = userInput.nextInt();
			int arr[] = new int[size];
			System.out.println("Please enter the values of array");
			for (int i = 0; i < size; i++)
				arr[i] = userInput.nextInt();
			System.out.println("Please enter the total no of targets that needs to be achieved");
			int targetNo = userInput.nextInt();
			while (targetNo-- != 0) {
				int flag = 0;
				long target;
				System.out.println("Please enter the value of target");
				target = userInput.nextInt();
				long sum = 0;
				for (int i = 0; i < size; i++) {
					sum += arr[i];
					if (sum >= target) {
						System.out.println("Target achieved after " + (i + 1) + "	transactions ");
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					System.out.println(" Given target is not achieved ");
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception Caught while program execution " + ex.getMessage());
		}
	}

}
