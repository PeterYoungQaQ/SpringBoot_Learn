<template>
  <div>
    <!-- 轮播图组件 -->
    <home-banner :banners="banners"></home-banner>
    <!-- 视频列表组件 -->
    <video-list :courselist="courselist"></video-list>
    <!-- 底部导航栏组件 -->
    <common-footer></common-footer>
  </div>
</template>

<script>
// 组件引入
import HomeBanner from './Compoments/Banner'
import VideoList from './Compoments/VideoList'
import CommonFooter from '@/components/CommonFooter'
// 接口方法引入
import { getBanner, getVideoList } from '@/api/getData.js'
export default {
  // 注册组件
  components: {
    HomeBanner,
    VideoList,
    CommonFooter,
  },
  data() {
    return {
      banners: [],
      courselist: [],
    }
  },
  methods: {
    async getBannerData() {
      try {
        // 获取轮播图数据并赋值到data字段里
        const result = await getBanner()
        this.banners = result.data.data
      } catch (error) {
        console.log(error)
      }
    },
    async getVlist() {
      // 获取视频列表数据并赋值到data字段里
      try {
        const result = await getVideoList()
        this.courselist = result.data.data
      } catch (error) {
        console.log(error)
      }
    },
  },
  mounted() {
    //页面渲染完成调用方法获取数据
    this.getBannerData()
    this.getVlist()
  },
}
</script>

<style lang="scss" scoped></style>
