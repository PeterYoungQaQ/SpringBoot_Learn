package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 16:46
 * @Description:
 */

import net.peter.ssm.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PlayRecordMapper {

    /**
     * 保存播放记录信息
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);
}
