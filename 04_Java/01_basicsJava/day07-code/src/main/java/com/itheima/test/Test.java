package com.itheima.test;

import com.itheima.domain.Movie;

public class Test {
    public static void main(String[] args) {

        Movie movie1 = new Movie(1, "东八区的先生", "2022", 2.1, "中国大陆", "喜剧", "夏睿", "张翰");
        Movie movie2 = new Movie(2,"上海堡垒", "2819", 2.9, "中国大陆", "爱情 战争 科幻", "滕华涛","鹿哈舒淇");
        Movie movie3 = new Movie(3, "纯洁心灵·逐梦演艺圈", "2015", 2.2, "中国大陆","剧情 喜剧", "毕志飞","朱一文 李漫");

        Movie[] movies = {movie1, movie2, movie3};

        MoveService moveService = new MoveService(movies);
        moveService.start();
    }
}
