package cn.itcast.gjp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author apple
 * @date 2019/8/27 下午6:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class user {
    private int id = 100;
    private String nickName;
    private String mobile;
    private String realName;
}
