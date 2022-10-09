/**
 * 
 */
package com.gl.notescounter.lab2.main;


import java.util.Scanner;
import com.gl.notescounter.lab2.utility.ArrayUtils;

/**
 * 			Problem Statement-2
 * 			you are a traveler and traveling to a country where the currency denominations are
			unknown and as you travel you get to know about the denomination in random order.
			You want to make a payment of amount x, in such a way that the higher denomination is
			used to make exact payment
 * 
 * @author shankar
 *
 */
public class NotesCounterDriver {
	
	
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the size of currency denominations:");
		int numberOfDenominations = s.nextInt();
		
		int [] arrDenominations = new int[numberOfDenominations];
		System.out.println("Enter enter the currency denominations value");
		for(int i = 0; i< numberOfDenominations; i++)
		{
			arrDenominations[i] = s.nextInt();
		}
		
		// sort the Denominations:
		ArrayUtils.mergeSort(arrDenominations);
		
		int [] counter = new int[numberOfDenominations];

		
		System.out.println("Please enter the amount you want to pay: ");
		int amountToPay = s.nextInt();
		
		int remainingAmount = countNotes(arrDenominations, counter, 0, numberOfDenominations - 1, amountToPay);
		
		if (remainingAmount > 0)
		{
			System.out.println("Amount cannot be paid in give denominations!");
		}
		else
		{
			for(int i = numberOfDenominations - 1; i>=0; i--)
			{
				if(counter[i] != 0)
				{
					System.out.println("Your payment approach in order to give min no of notes will be " + arrDenominations[i] + ":" + counter[i]);
				}
			}
		}
	}

public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay )
{
	/*
	 */
	if (amountToPay == 0)
	{
		return 0;
	}
	if (amountToPay < arrDenominations[0])
	{
		return amountToPay;
	}
	
	
	if(amountToPay >= arrDenominations[high])
	{
		counter[high] = amountToPay / arrDenominations[high];
		amountToPay %= arrDenominations[high];
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}
	int mid = (low+high)/2;
	if(amountToPay <= arrDenominations[mid])
	{
		return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
	}
	return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
}

	}
	


