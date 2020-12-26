package cn.les.springcloud.mybandler;

import cn.les.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2020/12/26 11:04
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }

}
