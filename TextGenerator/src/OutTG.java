import java.util.ArrayList;
import java.util.HashMap;

public class OutTG {

	private HashMap<String, ArrayList<String>> HM = new HashMap<String, ArrayList<String>>();
	
	public OutTG(){
		TextCyrano x = new TextCyrano();
		x.evaluateText();
		ArrayList<String> arr = x.getArr();
		for(int k=0;k<arr.size()-1;k++) {
			if(HM.containsKey(arr.get(k))) {
				ArrayList<String> arl = new ArrayList<String>();
				ArrayList<String> there = HM.get(arr.get(k));
				for(int q=0;q<there.size();q++) {
					arl.add(there.get(q));
				}
				arl.add(arr.get(k+1));
				HM.replace(arr.get(k), arl);
			}
			else {
				ArrayList<String> arl = new ArrayList<String>();
				arl.add(arr.get(k+1));
				HM.put(arr.get(k), arl);
			}
		}
		
		
	}
	
	public HashMap<String, ArrayList<String>> getHash() {
		return HM;
	}
	
	public String make(String startWord, int length) {
		String toReturn = startWord + " ";
		int itt = 1;
		boolean notFinished = true;
		String currentWord = startWord;
		while (notFinished) {
			if(currentWord.equals("Curtain.") || itt >= length) {
				notFinished = false;
			}
			if(itt % 10 == 0) {
				toReturn += "\r\n";
			}
			ArrayList<String> possibleWords = HM.get(currentWord);
			int randNum = (int) (Math.random()*possibleWords.size());
			String newWord = possibleWords.get(randNum);
			toReturn += newWord + " ";
			currentWord = newWord;
			itt++;
		}
		return toReturn;
	}
	
	
	
	
}
