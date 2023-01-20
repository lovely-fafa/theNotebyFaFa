package com.itheima.test;

import com.itheima.domain.Movie;

import java.util.Scanner;

public class MoveService {
    private Movie[] movies;
    public Scanner sc = new Scanner(System.in);

    public MoveService(Movie[] movies) {
        this.movies = movies;
    }

    /*
            启动电影管理系统
         */
    public void start() {

        lo:
        while (true) {
            System.out.println("----------电影信息系统----");
            System.out.println("请输入您的选择:");
            System.out.println("1，查询全部电影信息");
            System.out.println("2. 根据id查询电影信息");
            System.out.println("3，退出");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    queryMovieInfos();
                    break;
                case 2:
                    queryMovieInfoById();
                    break;
                case 3:
                    System.out.println("退出");
                    break lo;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    private void queryMovieInfoById() {
        System.out.println("请输入您要查询的电影编号：");
        int id = sc.nextInt();
        for (int i = 0; i <= movies.length; i++) {
            Movie movie = movies[i];
            if (movie.getId() == id){
                System.out.println(movie.getId() + "---" + movie.getTitle() + "---" + movie.getTime() + "---" +
                        movie.getScore() + "---" + movie.getArea() + "---" + movie.getType() + "---" +
                        movie.getDirector() + "---" + movie.getStarting());
                return;
            } else {
                System.out.println("哦豁，没找到...");
            }

        }
    }

    private void queryMovieInfos() {
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.println(movie.getTitle() + "---" + movie.getScore());
        }
    }
}
