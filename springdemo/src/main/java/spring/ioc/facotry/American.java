package spring.ioc.facotry;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 9:01 AM 2020/2/20.
 * @Modified By:
 */
public class American implements Person {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void say() {
        // TODO Auto-generated method stub
        System.out.println(msg+",我要重返亚太地区");
    }
}
