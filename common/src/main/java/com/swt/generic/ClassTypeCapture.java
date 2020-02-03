package com.swt.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 6:35 PM 2020/2/3.
 * @Modified By:
 */
class Building {
}

class Hourse extends Building {
}

public class ClassTypeCapture {
    Class<?> kind;
    Map<String, Class<?>> map;

    public ClassTypeCapture(Class<?> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<?> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object obj) {
        return kind.isInstance(obj);
    }

    public void addType(String type, Class<?> kind) {
        map.put(type, kind);
    }

    public Object createNew(String type) throws IllegalAccessException, InstantiationException {
        if (map.containsKey(type)) {
            return map.get(type).newInstance();
        }
        System.out.println(type + "class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture ctt1 = new ClassTypeCapture(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new Hourse()));

        ClassTypeCapture ctt2 = new ClassTypeCapture(Hourse.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new Hourse()));

        ClassTypeCapture ct = new ClassTypeCapture(Building.class, new HashMap<>());
        ct.addType("Hourse", Hourse.class);
        ct.addType("Building", Building.class);
        System.out.println(ct.map);

        try {
            Building b = (Building) ct.createNew("Building");
            Hourse h = (Hourse) ct.createNew("Hourse");

            System.out.println(b.getClass().getName());
            System.out.println(h.getClass().getName());
            System.out.println("Hourse h is instance Hourse:" + (h instanceof Hourse));
            System.out.println("Hourse h is instance Building:" + (h instanceof Building));
            System.out.println("Building b is instance Hourse:" + (b instanceof Hourse));
            ct.createNew("string");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
