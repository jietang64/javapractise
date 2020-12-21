package com.jietang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class p22_括号生成 {

    public static void main(String[] args) {
    }

    //基本思路：递归的插入(), 并使用一个list保存所有状态的字符串，检测是否重复
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuffer asr = new StringBuffer();
        List<String> tmparr = new ArrayList<String>();
        generate(n, res, asr, tmparr);
        return res;
    }

    public static void generate(int size, List<String> res, StringBuffer asr, List<String> tmparr) {
        if (size == 0) {
            res.add(asr.toString());
            return;
        } else {
            int tmp_size = asr.length();
            for (int i = 0; i <= tmp_size; i++) {
                StringBuffer tmpStr = new StringBuffer(asr);
                tmpStr.insert(i, "()");
                if (!tmparr.contains(tmpStr.toString())) {
                    tmparr.add(tmpStr.toString());
                    generate(size - 1, res, tmpStr, tmparr);
                }
            }
        }
    }
}
