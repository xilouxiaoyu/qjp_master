package cn.itcast.gjp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author apple
 * @date 2019/10/8 上午10:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class testCase {
    private int id;
    private boolean depend;
    private int weights;
    private String caseName;
}
