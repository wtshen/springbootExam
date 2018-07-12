package com.swt.collection;

import lombok.Data;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 下午9:37 18/3/5.
 * @Modified By:
 */
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;

        UserInfo userInfo = (UserInfo) o;

        return getId() != null ? getId().equals(userInfo.getId()) : userInfo.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
