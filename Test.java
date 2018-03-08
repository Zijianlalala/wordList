import java.util.*;
import java.lang.*;
import java.io.*;

public class Test {
	//
	public static void main(String[] args) {
		
		//读文件
		String s = "";
		//新建list用来存放四级大纲
		List<String> wordList = new ArrayList<>();
		try {
			s = ReadUtil.read("/Users/wuzijian/Desktop/wordList/read.txt");
			wordList = ReadUtil.readWordList("/Users/wuzijian/Desktop/wordList/wordList.txt");
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		
		//新建list用来存放分离的单词
		List<String> readingList = getReadingList(s);
		
		//将所得数据按照字典的顺序排序
		List<String> newList = sort(readingList);
		//四级文章的总词数
		int n = newList.size();

		//求交集
		//a.retainAll(b) 将a中不包含b的部分移除掉，所剩的部分就是交集
		wordList.retainAll(newList);
		//词汇表中所包含的该四级文章的词汇数量
		int m = wordList.size();

		double result = (n-m)*1.0/n;
		
		System.out.println(result);
	}


	//处理原始数据的方法
	//提取单词的逻辑：如果当前字符是字母，则继续判断下一个字符是否是字母，直到为非字母。
	public static List<String> getReadingList(String s) {
		int n = s.length();
		List<String> list = new ArrayList<>();
		for(int i = 0;i < n; i++) {
			//Character.isLetter(char) 判断一个字符是不是字母并返回boolean型
			if(Character.isLetter(s.charAt(i))) {
				String word = "";
				do{
					word += s.charAt(i);
					i++;
				}while(i < n && Character.isLetter(s.charAt(i)));
				//将大写字母变为小写字母
				if(!Character.isLowerCase(word.charAt(0))) {
					word = word.toLowerCase();
				}
				if(!list.contains(word)) {
					list.add(word);
				}
				
			}
		}
		return list;
	}


	//使用冒泡排序对readingList按照字典顺序排序
	public static List<String> sort(List<String> a) {
		int n = a.size();
		String t;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-i-1; j++) {
				//String.compareTo(String)是按照字典顺序比较大小 返回正数、负数以及0
				if(a.get(j).compareTo(a.get(j+1)) > 0) {
					t = a.get(j+1);
					a.set(j+1, a.get(j));
					a.set(j, t);
				}
			}
		}
		return a;
	}

}