package net.peter.online_class.dao;

import net.peter.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
     * 查询部分字段
     * @param video
     * @return
     */
    int selectListByXML(Video video);

    /**
     * 根据评分和标题选择视频
     * @param point
     * @param title
     * @return
     */
    List<Video> selectByPointAndTitleLike(@Param("point") double point, @Param("title") String title);

    /**
     * 新增一条视频记录
     * @param video
     */
    int add(Video video);

    /**
     * 批量插入视频记录
     * @param videoList
     * @return
     */
    int addBatch(List<Video> videoList);

    /**
     * 更新视频记录
     * @param video
     * @return
     */
    int updateVideo(Video video);

    /**
     * 选择性更新视频记录
     * @param video
     * @return
     */
    int updateVideoSelective(Video video);

    /**
     * 根据时间和价格删除视频记录
     * @param map
     * @return
     */
    int deleteByCreateTimeAndPrice(Map<String,Object> map);

    /**
     * 根据id查询视频，使用ResultMap的形式
     * @param id
     * @return
     */
    Video selectBaseFieldByIdWithResultMap(@Param("video_id") int id);
}
