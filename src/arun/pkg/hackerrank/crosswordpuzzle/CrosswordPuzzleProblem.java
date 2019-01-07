package arun.pkg.crosswordpuzzle;

import java.io.IOException;
import java.util.ArrayList;

public class CrosswordPuzzleProblem {
	// Complete the crosswordPuzzle function below.
	static String[] crosswordPuzzle(String[] crossword, String words) {

		ArrayList<ArrayList<Data>> dataArr = new ArrayList<>();
		for (int i = 0; i < crossword.length; i++) {
			ArrayList<Data> datas = new ArrayList<>();
			String fill = crossword[i];
			int startPos = fill.indexOf('-');
			Data data = new Data();
			data.i = i;
			data.j = startPos;
			datas.add(data);
			char nextChar = 'x';
			// horizontal tracing
			while (nextChar != '+') {
				if (startPos == fill.length()) {
					break;
				}
				startPos++;
				nextChar = fill.charAt(startPos);
				if (nextChar == '-') {
					data = new Data();
					data.i = i;
					data.j = startPos;
					datas.add(data);
				}
			}
			dataArr.add(datas);
		}
		
		printData(dataArr);

//		String[] wordsArr = words.split(";");
//		String[] emptyPaths = new String[wordsArr.length];
//		for (int i = 0; i < crossword.length; i++) {
//			String fill = crossword[i];
//			int startPos = fill.indexOf('-');
//			if(fill.charAt(startPos + 1) == '+') {
//				// vertical filling
//				if(i > 0 && crossword[i-1].charAt(startPos) == '+') {
//					// first empty index starting here
//					
//				}
//			} else {
//				// horizontal filling
//				
//			}
//			
//		}

//		for (int i = 0; i < crossword.length; i++) {
//			String fill = crossword[i];
//			int startPos = fill.indexOf('-');
//			
//			int endPos = fill.lastIndexOf('-');
//			int length = endPos - startPos + 1;
//			for (int j = 0; j < wordsArr.length; j++) {
//				String wrd = wordsArr[j];
//				if (length == wrd.length()) {
//					String finalStr = fill.replace(fill.substring(startPos, endPos + 1), wrd);
//					crossword[i] = finalStr;
//				}
//			}
//		}
		return crossword;
	}

	private static void printData(ArrayList<ArrayList<Data>> dataArr) {
		for (int i = 0; i < dataArr.size(); i++) {
			for (int j = 0; j < dataArr.get(i).size(); j++) {
				System.out.print(dataArr.get(i).get(j).i + "" + dataArr.get(i).get(j).j + ", ");
			}
			System.out.println();
		}
	}

	static class Data {
		int i;
		int j;
	}

	public static void main(String[] args) throws IOException {
		String[] crossword = { "+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++", "+-+++-++++",
				"+++++-++++", "++------++", "+++++-++++", "+++++-++++" };

		String words = "LONDON;DELHI;ICELAND;ANKARA";

		String[] result = crosswordPuzzle(crossword, words);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

//    +-++++++++
//    +-++++++++
//    +-++++++++
//    +-----++++
//    +-+++-++++
//    +-+++-++++
//    +++++-++++
//    ++------++
//    +++++-++++
//    +++++-++++
//    LONDON;DELHI;ICELAND;ANKARA
}
