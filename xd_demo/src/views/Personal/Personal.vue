<template>
  <div>
    <div class="container">
      <div class="p_top">
        <div>
          <img :src="info.head_img || defaultHeadImg" alt="头像" />
          <router-link to="/Login" v-if="getToken === ''">
            <p>立即登录</p>
          </router-link>
          <p v-else>{{ info.name }}</p>
        </div>
      </div>
      <button v-if="getToken !== ''" class="green" @click="signOut">
        退出登录
      </button>
      <common-footer></common-footer>
    </div>
    <common-footer></common-footer>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import CommonFooter from '@/components/CommonFooter'
import defaultHeadImg from '@/assets/logo.png'
import { getUserInfo } from '@/api/getData.js'
export default {
  components: {
    CommonFooter,
  },
  data() {
    return {
      info: {},
      defaultHeadImg: defaultHeadImg,
    }
  },
  computed: {
    getToken() {
      return this.$store.state.token
    }
  },
  methods: {
    
    async getInfo() {
      // 获取用户信息
      try {
        const result = await getUserInfo(this.getToken)
        this.info = result.data.data
      } catch (error) {
        console.log(error)
      }
    },
    async signOut() {
      // 退出登录，清除token
      // this.$store.dispatch 触发 action里面定义的方法
      await this.$store.dispatch('clearToken')
      localStorage.removeItem('token')
      //刷新界面
      location.reload()
    },
  },

//页面dom渲染完成会调用mounted， create的话是刚创建vue实例
  mounted() {
    if (this.getToken) {
      this.getInfo()
    }
  },
}
</script>

<style lang="scss" scoped>
.container {
  // 顶部头像区域
  .p_top {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px 0;
    background-color: #2c3f54;
    div {
      text-align: center;
      img {
        width: 60px;
        height: 60px;
        border-radius: 50px;
      }
      p {
        font-size: 16px;
        color: #fff;
        margin-top: 10px;
      }
    }
  }
}
// 退出登录
.green {
  display: block;
  background-color: #3bb149;
  border: none;
  outline: none;
  width: 80%;
  height: 40px;
  margin: 20px auto 0;
  color: #fff;
  border-radius: 20px;
}
</style>
