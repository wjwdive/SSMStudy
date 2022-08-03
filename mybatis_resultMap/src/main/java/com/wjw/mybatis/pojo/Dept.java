package com.wjw.mybatis.pojo;

/**
 * @Author wjwdive
 * @Date 2022/8/3 1:26
 * @Description:
 */
public class Dept {
    private Integer deptId;
    private String deptName;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
