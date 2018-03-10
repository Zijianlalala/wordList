import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
public class Regular {
	public static void main(String[] args) {

		//读文件转换为字符串
		String filePath = "/Users/wuzijian/Desktop/wordList/RegexTest.java";
		Set<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		set = ReadUtil.getSet(filePath, ReadUtil.REGEX_FOR_JAVACLASS);
		System.out.println(set);
	}
}