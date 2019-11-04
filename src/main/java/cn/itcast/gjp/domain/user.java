package cn.itcast.gjp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author apple
 * @date 2019/8/27 下午6:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder=true)
public class user implements Serializable {
    private int id = 100;
    private String nickName;
    public String mobile;
    private String realName;
}
