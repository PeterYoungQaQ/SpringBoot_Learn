<template>
  <div>
    <!-- 视频信息 -->
    <div class="info">
      <p class="info_title">商品信息</p>
      <div class="box">
        <div class="imgdiv">
          <img alt="课程照片" :src="videoinfo.cover_img" />
        </div>
        <div class="textdiv">
          <p class="c_title">{{ videoinfo.title }}</p>
          <p class="price">
            ￥:&nbsp;&nbsp;{{ (videoinfo.price / 100).toFixed(2) }}
          </p>
        </div>
      </div>
    </div>
    <!-- 底部支付 -->
    <div class="footer">
      <p class="money">
        实付:&nbsp;&nbsp;{{ (videoinfo.price / 100).toFixed(2) }}
      </p>
      <!--可以不传把token，在pay方法里面直接获取-->
      <p @click="pay" class="submit">
        立即支付
      </p>
    </div>
  </div>
</template>

<script>
import { getVideoDetail, saveOrder } from '@/api/getData.js'
export default {
  data() {
    return {
      videoinfo: {},
    }
  },
  //  计算属性，响应式依赖 
  //  computed: {
  //   getToken() {
  //     // vue的data和 store里面定义的是响应式依赖
  //     return this.$store.state.token
  //   }
  // },
  methods: {
    async getDetail(vid) {
      try {
        // 获取视频详情信息
        const result = await getVideoDetail(vid)
        this.videoinfo = result.data.data
      } catch (error) {
        console.log(error)
      }
    },
    async pay() {
      //支付
      try {
        const result = await saveOrder(this.$store.state.token, this.$route.query.video_id)
        if (result.data.code === 0) {
          this.$createToast({
            txt: '购买成功',
            type: 'txt',
            time: 2000,
            onTimeout: () => {
              this.$router.push({ path: '/order' })
            },
          }).show()
        }
      } catch (error) {
        console.log(error)
      }
    },
  },
  //页面dom渲染完成会调用mounted， create的话是刚创建vue实例
  mounted() {
    this.getDetail(this.$route.query.video_id)
  },
}
</script>
<!--scoped 是指这个scss样式 只作用于当前组件-->
<style lang="scss" scoped>
// 视频标题
.info_title {
  padding: 10px 20px;
  background-color: #fff;
  border-bottom: 1px solid #d9dde1;
}

.box {
  background-color: #fff;
  box-sizing: border-box;
  padding: 20px;
  display: flex;
  margin-bottom: 15px;
  .imgdiv {
    width: 105px;
    height: 59px;
    flex-shrink: 0;
    img {
      width: 100%;
      height: 100%;
    }
  }

  .textdiv {
    margin-left: 20px;
    height: 59px;
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    .price {
      flex-shrink: 0;
    }
  }
}
//底部
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.1);
  font-size: 16px;
  .money {
    height: 50px;
    line-height: 50px;
    flex: 2;
    text-align: center;
    background-color: #fff;
  }
  .submit {
    height: 50px;
    line-height: 50px;
    flex: 1;
    text-align: center;
    background-color: #ff2d50;
    color: #fff;
  }
}
</style>
