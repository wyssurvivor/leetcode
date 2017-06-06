package com.ssdut.wys.Solutions;

/**
 * Created by wangyongshan on 17-6-6.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 */
public class Q071 {

    public String simplifyPath(String path) {
        String result = "";
        List<String> dirs = new ArrayList<String>();
        int start = 0;
        while(start<path.length()) {
            int end = start+1;
            while(end<path.length()&&path.charAt(end) != '/') end++;
            String dir = path.substring(start+1, end);
            if (dir.equals("..")) {
                if(dirs.size() > 0) {
                    dirs.remove(dirs.size()-1);
                }
            } else if(!dir.equals("")&&!dir.equals(".")){
                dirs.add(dir);
            }

            start = end;
        }

        for(int i=0;i<dirs.size();i++) {
            result+="/" + dirs.get(i);
        }

        return result.length()>0 ? result:"/";
    }

    @Test
    public void testSolution() {
        String path = "/../";
        Q071 solution = new Q071();
        System.out.println(solution.simplifyPath(path));
    }
}
