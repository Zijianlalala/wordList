import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	//
	public static void main(String[] args) {
		//文件路径
		String readingPath = "/Users/wuzijian/Desktop/wordList/read.txt";
		String wordListPath = "/Users/wuzijian/Desktop/wordList/wordList.txt";
		//新建treeSet用来存放四级大纲的单词
		Set<String> wordSet = new TreeSet<String>();
		wordSet = ReadUtil.getSet(wordListPath,ReadUtil.REGEX_FOR_WORDLIST);
		//新建treeSet用来存放四级阅读的单词
		Set<String> readingSet = new TreeSet<String>();
		readingSet = ReadUtil.getSet(readingPath,ReadUtil.REGEX_FOR_READINGLIST);
		//求交集
		//a.retainAll(b) 将a中不包含b的部分移除掉，所剩的部分就是交集
		wordSet.retainAll(readingSet);
		//四级文章的总词数
		int n = readingSet.size();
		//词汇表中所包含的该四级文章的词汇数量
		int m = wordSet.size();
		double result = (n-m)*1.0/n;
		System.out.println(result);
	}

}