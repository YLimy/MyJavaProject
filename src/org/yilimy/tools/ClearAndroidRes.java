package org.yilimy.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClearAndroidRes {
	public static final String project_Path = "/Users/Orice/Documents/workspace/zhongyou/ZhongYouSpecialPAD/"; 
	public static final String result_Path = "/Users/Orice/result.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(result_Path));
			String line;
			int count = 0;
			while((line = reader.readLine()) != null) {
			    if (line.contains("UnusedResources") && !line.contains("res/value") && !line.contains("appcompat")) {
			        count++;
			        int end = line.indexOf(":");
			        if (end != -1){
			            String file = line.substring(0, end);
			            String f = project_Path +file;
			            System.out.println(f);
			            new File(f).delete();
			        }
			    }
			}
			System.out.println("共计删除陈余资源："+ count + "个");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
