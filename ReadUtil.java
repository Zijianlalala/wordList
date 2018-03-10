import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadUtil {
	public static final String REGEX_FOR_WORDLIST = "\\b[a-z]+\\b";
	public static final String REGEX_FOR_READINGLIST = "(\\b|\\w)[a-zA-Z]+(\\b|\\w)";
	public static final String REGEX_FOR_JAVACLASS = "(\\b|\\w)[a-zA-Z0-9]+(\\b|\\w)";
	//读任意文件，并返回一个字符串
	public static String read(String filename) {
		StringBuilder sb = new StringBuilder();

		try{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;
			while((s = in.readLine())!= null) {
				sb.append(s + "\n");
			}
			in.close();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		return sb.toString();
	}
	//读取词汇文件,根据匹配模式不同并返回不同的词汇集合。
	public static Set<String> getSet(String filename, String regex) {
		//使用正则表达式
		String input = read(filename);
		//存放单词的集合
		Set<String> wordSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		//匹配
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while(m.find()) {
			wordSet.add(input.substring(m.start(), m.end()));
		}
		return wordSet;
	}
}