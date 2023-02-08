package com.itheima.regex;

public class StringRegexDemo {
    public static void main(String[] args) {
        String s = "《出师表》是三国时期蜀汉丞相诸葛亮在决定北上伐魏、克复中原 [2]  之前给后主刘禅上书的表文。 [1]  [3]  [20]  这篇表文以议论为主，兼用记叙和抒情。全文以恳切委婉的言辞劝勉后主要广开言路、严明赏罚、亲贤远佞，以此兴复汉室 还于旧都（洛阳） [2]  [4]  ；同时也表达自己以身许国，忠贞不二的思想。文章既不借助于华丽的辞藻，又不引用古老的典故，多以四字句行文。 [5] ";
        s = s.replaceAll(" \\[\\d+] ", "");
        System.out.println(s);
    }
}
