import java.util.*;
import java.lang.*;
import java.io.*;

public class ReadUtil {

	//读四级阅读文件，并返回一个字符串
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine())!= null) {
			sb.append(s);
		}
		in.close();
		return sb.toString();
	}
	//读取词汇文件,并返回一个词汇列表。
	public static List<String> readWordList(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		List<String> wordList = new ArrayList<>();
		while((s = in.readLine())!= null) {
			s.trim();
			int n = s.indexOf(" ");
			if (n == -1) continue;
			while(n == 0) {
				s = s.trim();
				n = s.indexOf(" ");
			}
			String s2 = s.substring(0, n);
			wordList.add(s2);
		}
		in.close();
		return wordList;
	}
}