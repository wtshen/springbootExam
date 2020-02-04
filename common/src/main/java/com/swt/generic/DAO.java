package com.swt.generic;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 8:07 PM 2020/2/3.
 * @Modified By:
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);

    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.replace(id, entity);
        }
    }

    public List<T> list() {
        return Lists.newArrayList(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1, 20, "aaa"));
        userDAO.save("2", new User(2, 30, "bbb"));
        userDAO.save("3", new User(3, 40, "ccc"));

        System.out.println(userDAO.list());

        System.out.println(userDAO.get("1"));

        userDAO.update("2", new User(4, 50, "ddd"));
        System.out.println(userDAO.list());

        userDAO.delete("2");
        System.out.println(userDAO.list());

    }
}

@Data
@AllArgsConstructor
class User {
    private Integer id;
    private Integer age;
    private String name;
}
