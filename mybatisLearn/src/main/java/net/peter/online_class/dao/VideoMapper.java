package net.peter.online_class.dao;

import net.peter.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoMapper {

    /**
     * 根据视频id查找视频对象
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId);

    /**
     * 查询全部视频列表
     * @return
     */
    @Select("select * from video")
    List<Video> selectList();

    /**
     * 根据评分和标题选择视频
     * @param point
     * @param title
     * @return
     */
    List<Video> selectByPointAndTitleLike(@Param("point") double point, @Param("title") String title);
}
