package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.itheima.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@TableName("tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
    // 设置 id 模式是 auto 自增
    // @TableId(type = IdType.AUTO)
    private Long id;
    private String userName ;

    @TableField(
            select = false,  // 查询时不查该值
            fill = FieldFill.INSERT  // 插入数据是填充
    )
    private String password;
    private String name;
    private Integer age;

    // 指定数据库中的字段名 进行映射对应
    @TableField(value = "email")
    private String mail;

    // 数据表中不存在该字段 就不会报错: Unknown column 'address' in 'field list'
    @TableField(exist = false)
    private String address;

    // 乐观锁版本字段
    @Version
    private Integer version;

    // 逻辑删除 1 删除 0 未删除
    @TableLogic
    private Integer deleted;

    // 性别 枚举类
    private SexEnum sex;
}
