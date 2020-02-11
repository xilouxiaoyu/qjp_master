package cn.itcast.gjp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author apple
 * @date 2019/8/27 下午6:33
 */
@Data

@NoArgsConstructor
@Builder(toBuilder=true)
public class user implements Serializable {
    private int id ;
    private String nickName;
    public String mobile;
    private String realName;

    public user(int i, String nickName, String mobile, String realName) {
        this.id= i;
        this.nickName = nickName;
        this.mobile =mobile;
        this.realName = realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return id == user.id &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(realName, user.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, mobile, realName);
    }

    public void study(String nickName){
        System.out.println(nickName+" is studing now");
    }
}
