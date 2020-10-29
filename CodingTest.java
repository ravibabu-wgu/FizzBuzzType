import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This program implements 10 different asks. A menu is given to user to chose
 * on the function to execute. In some of the options, User will be giving the
 * input. For few, I took constant inputs which if needed can also be recoded
 * easily to be taken from User.
 *
 * @author RaviBabu Vutla
 * @version 1.0
 * @since 2020-10-27
 */

public class CodingTest {

	private static final List<Integer> SAMPLE_LIST = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99);
	private static final List<String> SAMPLE_LIST_STR = List.of("aa", "bb", "cc", "dd");
	private static final String SAMPLE_STRING = "example";
	private static final String SAMPLE_SENTENCE = "sample sentence";
	private static final int SERIES_LIMIT = 100;
	private static final List<Integer> RANDOM_LIST = List.of(1, 12, 6, 44, 15, 6, 77, 28, 9);

	private static void printOptions() {

		System.out.println("----------------------------------");
		System.out.println("--- Menu - Few Simple Programs ---");

		// 1. SUM a List of Numbers in three ways
		// Write three functions that compute the sum of the numbers in a given list
		// using a for-loop, a while-loop, and recursion.
		System.out.println(" 1. SUM a List of Numbers in three ways");

		// 2. Combine Members of Two Lists Alternatively
		// Write a function that combines two lists by alternating taking elements. For
		// example: given the two lists [a, b, c] and [1, 2, 3], the function should
		// return [a, 1, b, 2, c, 3].
		System.out.println(" 2. Combine Two Lists");

		// 3. Print Numbers with Fizz/Buzz/FizzBuzz for multiples of 3/5/both
		// Write a program that prints the numbers from 1 to 100. But for multiples of
		// three print “Fizz” instead of the number and for the multiples of five print
		// “Buzz”. For numbers which are multiples of both three and five print
		// “FizzBuzz”.
		System.out.println(" 3. Print Numbers with Fizz/Buzz/FizzBuzz");

		// 4. Fibonacci Series
		// Write a function that computes the list of the first 100 Fibonacci numbers.
		// By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
		// and each subsequent number is the sum of the previous two. As an example,
		// here are the first 10 Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.
		System.out.println(" 4. Fibonacci Series");

		// 5. Reverse a string
		// Write a function that will reverse a string.
		System.out.println(" 5. Reverse a string");

		// 6. Reverse a sentence
		// Write a function that will reverse a sentence (ex: “quick brown fox” -> “fox
		// brown quick”)
		System.out.println(" 6. Reverse a sentence");

		// 7. Return Max of a List
		// Write a function that will return the maximum value in a list.
		System.out.println(" 7. Return Max of a List");

		// 8. Return Unique List
		// Write a function that will return a list of distinct values (i.e. "1 3 5 3 7
		// 3 1 1 5" -> "1 3 5 7")
		System.out.println(" 8. Return Unique List");

		// 9. User driven computation
		// Write a function that takes a string of expressions (les, +, and
		// -) and a set of variable/value pairs (i.e. a=1, b=7, c=3, d=14) and returns
		// the result of the expression ("a + b + c - d" would be -3).
		System.out.println(" 9. User driven computation");

		// 10. Check Palindrome
		// Write a function that checks if a string is a palindrome.
		System.out.println("10. Check Palindrome");

		// 0. Exit
		System.out.println(" 0. Exit");

		System.out.print("Enter Your choice of program: ");
	}

	private int recursiveSum(List<Integer> lst) {
		if (lst.size() == 0)
			return 0;
		else if (lst.size() == 1)
			return lst.get(0);
		return recursiveSum(lst.subList(0, lst.size() - 1)) + lst.get(lst.size() - 1);
	}

	// 1. SUM a List of Numbers in three ways
	// Write three functions that compute the sum of the numbers in a given list
	// using a for-loop, a while-loop, and recursion.
	private void threeSumFunc() {
		System.out.println("Sample List: " + SAMPLE_LIST);
		int sum = 0;
		for (Integer a : SAMPLE_LIST) {
			sum = sum + a;
		}
		System.out.println("SUM with for-Loop: " + sum);

		sum = 0;
		int i = 0;
		while (i < SAMPLE_LIST.size()) {
			sum = sum + SAMPLE_LIST.get(i);
			i++;
		}
		System.out.println("SUM with while-Loop: " + sum);

		System.out.println("SUM with for recursion: " + recursiveSum(SAMPLE_LIST));
	}

	// 2. Combine Members of Two Lists Alternatively
	// Write a function that combines two lists by alternating taking elements. For
	// example: given the two lists [a, b, c] and [1, 2, 3], the function should
	// return [a, 1, b, 2, c, 3].
	private void combineLists() {

		System.out.println("1st List: " + SAMPLE_LIST);
		System.out.println("2nd List: " + SAMPLE_LIST_STR);

		int lenA = SAMPLE_LIST.size();
		int lenB = SAMPLE_LIST_STR.size();
		int itr = lenA <= lenB ? lenA : lenB;
		List<String> combinedList = new ArrayList<String>();
		for (int i = 0; i < itr; i++) {
			combinedList.add("" + SAMPLE_LIST.get(i));
			combinedList.add(SAMPLE_LIST_STR.get(i));
		}

		if (lenA > lenB)
			for (int i = itr; i < lenA; i++)
				combinedList.add("" + SAMPLE_LIST.get(i));
		else if (lenA < lenB)
			combinedList.addAll(SAMPLE_LIST_STR.subList(itr, lenB - 1));

		System.out.println("Combined List: " + combinedList);
		// Can return the combinedList here. In this program structure not returning
		// anything.
	}

	// 3. Print Numbers with Fizz/Buzz/FizzBuzz for multiples of 3/5/both
	// Write a program that prints the numbers from 1 to 100. But for multiples of
	// three print “Fizz” instead of the number and for the multiples of five print
	// “Buzz”. For numbers which are multiples of both three and five print
	// “FizzBuzz”.
	private void printFizz() {
		System.out.print("Printing Buzzyy to " + SERIES_LIMIT + ": ");
		for (int i = 0; i <= SERIES_LIMIT; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				System.out.print("FizzBuzz ");
			else if (i % 3 == 0)
				System.out.print("Fizz ");
			else if (i % 5 == 0)
				System.out.print("Buzz ");
			else
				System.out.print(i + " ");
		}
		System.out.println();
	}

	// 4. Fibonacci Series
	// Write a function that computes the list of the first 100 Fibonacci numbers.
	// By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
	// and each subsequent number is the sum of the previous two. As an example,
	// here are the first 10 Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.
	private void printFibonacci(Scanner in) {
		System.out.print("Enter Upper limit to Fibonacci series: ");
		int limit = Integer.parseInt(in.nextLine()); // Override with SERIES_LIMIT if needed
		System.out.print("Fibonacci Series upto " + limit + ": ");
		int a = 0, b = 1, c;
		while (a <= limit) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;
		}
		System.out.println();
	}

	String getReverseStr(String str) {
		if (str.isEmpty())
			return str;
		return getReverseStr(str.substring(1)) + str.charAt(0);

	}

	// 5. Reverse a string
	// Write a function that will reverse a string.
	private void reverseString(Scanner in) {
		System.out.println("Enter a string to reverse: ");
		String inputStr = in.nextLine();
		if (inputStr.isEmpty())
			inputStr = SAMPLE_STRING;
		System.out.println("Input String: <" + inputStr + ">	Reversed String: <" + getReverseStr(inputStr) + ">");
	}

	private String getRevSentence(String str) {
		String[] arrOfStr = str.split(" ");
		String revSentence = "";
		for (int i = arrOfStr.length; i-- > 0;)
			revSentence += arrOfStr[i] + " ";
		return revSentence.strip();
	}

	// 6. Reverse a sentence
	// Write a function that will reverse a sentence (ex: “quick brown fox” -> “fox
	// brown quick”)
	private void reverseSentence(Scanner in) {
		System.out.println("Enter a sentence to reverse: ");
		String inputStr = in.nextLine();
		if (inputStr.isEmpty())
			inputStr = SAMPLE_SENTENCE;
		System.out.println(
				"Input Sentence: <" + inputStr + ">		Reversed Sentence: <" + getRevSentence(inputStr) + ">");
	}

	// 7. Return Max of a List
	// Write a function that will return the maximum value in a list.
	private void maxOfList() {

		// Can return here if the list is of Zero Size
		System.out.println("RANDOM_LIST: " + RANDOM_LIST);
		int max = RANDOM_LIST.get(0);
		for (int a : RANDOM_LIST) {
			if (max < a)
				max = a;
		}
		System.out.println("Maximum Value in List: " + max);
	}

	// 8. Return Unique List
	// Write a function that will return a list of distinct values (i.e. "1 3 5 3 7
	// 3 1 1 5" -> "1 3 5 7")
	private void uniqueList() {
		System.out.println("RANDOM_LIST: " + RANDOM_LIST);
		// with Java10, the easiest way is using LinkedHashSet to preserve the order
		LinkedHashSet<Integer> randomSet = new LinkedHashSet<Integer>();
		randomSet.addAll(RANDOM_LIST);
		System.out.println("UNIQUE LIST: " + randomSet);
	}

	// 9. User driven computation
	// Write a function that takes a string of expressions (only variables, +, and
	// -) and a set of variable/value pairs (i.e. a=1, b=7, c=3, d=14) and returns
	// the result of the expression ("a + b + c - d" would be -3).
	private void userCompute(Scanner in) {
		System.out.println("Enter the string of expression: ");
		while (!in.hasNext("[[A-Za-z]-+]+")) {
			System.out.println("Only Variables,+,- are allowed in the expression! Ex:a + b + c - d");
			in.next();
		}
		String exprStr = in.nextLine();
		System.out.println("Enter the Variable Values: ");
		// Now lets take the values and keep in a map
		while (!in.hasNext("[A-Za-z=[0-9], ]+")) {
			System.out.println("Only variable/value pairs seperated by comma are allowed! Ex:a=1, b=7, c=3, d=14");
			in.next();
		}
		String varValues = in.nextLine();
		String[] varValuePairs = varValues.split(",");
		Map<String, Integer> varValMap = new HashMap<String, Integer>();
		String eachVar[];
		System.out.println("Expression: " + exprStr);
		for (int i = 0; i < varValuePairs.length; i++) {
			System.out.println("Variables and Values: " + varValuePairs[i].strip());
			eachVar = varValuePairs[i].strip().split("=");
			try {
				varValMap.put(eachVar[0].strip(), Integer.parseInt(eachVar[1].strip()));
			} catch (Exception e) {
				System.out.println("Exception in parsing input Variable Data!" + e.getMessage());
			}
		}
		System.out.println("MAP with Variables and Values: " + varValMap);

		// Now replace the values in the expression for the result
		String computeString = "";
		int value;
		for (int i = 0; i < exprStr.length(); i++) {
			if (!(exprStr.charAt(i) == ' ' || exprStr.charAt(i) == '+' || exprStr.charAt(i) == '-')) {
				value = varValMap.get("" + exprStr.charAt(i));
				computeString = computeString + value;
			} else
				computeString = computeString + exprStr.charAt(i);
		}
		System.out.println("To Compute: <" + computeString + ">");
		System.out.println("Result: <" + myEval(computeString) + ">");

		// Javascript option didnt work
		// System.setProperty("polyglot.js.nashorn-compat", "true");
		// ScriptEngineManager seMng = new ScriptEngineManager();
		// ScriptEngine sE = seMng.getEngineByName("graal.js");
		// Object result;
		// try {
		// result = sE.eval(computeString);
		// System.out.println(result);
		// } catch (Exception e) {
		// System.out.println("Exception in evaluating Expression - "+e.getMessage());
		// }
	}

	private int myEval(String str) {
		// Assumption is that String has only numbers and +/-
		String finalStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-')
				finalStr += "+-";
			else if (str.charAt(i) != ' ')
				finalStr += str.charAt(i);
		}
		System.out.println("Final Expression: <" + finalStr + ">");
		String addNum[] = finalStr.split("\\+");
		int sum = 0;
		for (String a : addNum) {
			sum = sum + Integer.parseInt(a.strip());
		}
		return sum;
	}

	// 10. Check Palindrome
	// Write a function that checks if a string is a palindrome.
	private void checkPalindrome(Scanner in) {
		System.out.println("Enter the string to check for Palindrome: ");
		String inputStr = in.nextLine();
		if (inputStr.isEmpty())
			inputStr = SAMPLE_STRING;
		String revStr = getReverseStr(inputStr);
		System.out.println("Input String: <" + inputStr + ">	Reversed String: <" + revStr + ">");
		if (inputStr.equalsIgnoreCase(revStr))
			System.out.println("It's a Palindrome! :)");
		else
			System.out.println("It's not a Palindrome :(");
	}

	public static void main(String args[]) {

		CodingTest codingTest = new CodingTest();
		Scanner input = new Scanner(System.in);
		printOptions();
		int choice = Integer.parseInt(input.nextLine());

		while (choice != 0) {
			switch (choice) {
			case 1:
				codingTest.threeSumFunc();
				break;
			case 2:
				codingTest.combineLists();
				break;
			case 3:
				codingTest.printFizz();
				break;
			case 4:
				codingTest.printFibonacci(input);
				break;
			case 5:
				codingTest.reverseString(input);
				break;
			case 6:
				codingTest.reverseSentence(input);
				break;
			case 7:
				codingTest.maxOfList();
				break;
			case 8:
				codingTest.uniqueList();
				break;
			case 9:
				codingTest.userCompute(input);
				break;
			case 10:
				codingTest.checkPalindrome(input);
				break;
			default:
				System.out.println("Not valid option");
			}
			printOptions();
			while (input.hasNext()) {
				choice = Integer.parseInt(input.nextLine());
				break;
			}

		}
		System.out.println("Exiting System!");
		input.close();
	}

}
