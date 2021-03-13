package net.peter.ssm.dao;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 16:31
 * @Description:
 */

import net.peter.ssm.model.entity.Episode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EpisodeMapper {

    /**
     * 通过视频id查询视频第一集，来获得episode的id
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
