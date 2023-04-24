package com.itheima.mp.simple.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")  // 表名进行映射
public class User {
    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private String email;
}

