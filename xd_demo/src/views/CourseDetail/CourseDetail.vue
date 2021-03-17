<template>
  <div>
    <!-- 顶部返回栏组件 -->
    <detail-header :videoinfo="videoinfo"> </detail-header>
    <!-- 视频介绍组件 -->
    <detail-course :videoinfo="videoinfo"></detail-course>
    <!-- 视频tab栏简介目录组件 -->
    <detail-tab
      :chapter_list="chapter_list"
      :videoinfo="videoinfo"
    ></detail-tab>
    <!-- 底部购买按钮 -->
    <footer>
      <router-link :to="{path:'/pay', query: {video_id: this.$route.query.video_id}}" class="user_buy">
        <button >立即购买</button>
      </router-link>
    </footer>
  </div>
</template>

<script>
// 组件引入
import DetailHeader from './Components/Header'
import DetailCourse from './Components/Course'
import DetailTab from './Components/Tab'
//接口方法引入
import { getVideoDetail } from '@/api/getData.js'
export default {
  // 注册组件
  components: {
    DetailHeader,
    DetailCourse,
    DetailTab,
  },
  data() {
    return {
      // 视频信息
      videoinfo: {},
      // 章节信息
      chapter_list: [],
    }
  },
  methods: {
    async getDetail(vid) {
      // 获取视频信息和章节信息
      try {
        const result = await getVideoDetail(vid)
        this.videoinfo = result.data.data
        this.chapter_list = result.data.data.chapter_list
      } catch (error) {
        console.log(error)
      }
    },
  },
  mounted() {
    //渲染完成调用方法获取数据
    this.getDetail(this.$route.query.video_id)
  },
}
</script>

<style lang="scss" scoped>
//底部
footer {
  // fixed固定在底部
  position: fixed;
  bottom: 0;
  width: 100%;
  padding: 8px 0;
  background-color: #fff;
  z-index: 999;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
}
//设置购买按钮样式
button {
  display: block;
  color: #fff;
  margin: 0 auto;
  background-color: #d93f30;
  height: 34px;
  line-height: 34px;
  border-radius: 17px;
  width: 80%;
  border: none;
  font-size: 15px;
  text-align: center;
}
</style>
