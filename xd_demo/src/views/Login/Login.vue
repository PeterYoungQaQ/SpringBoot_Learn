<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      <cube-form-group>
        <!-- 手机号 -->
        <cube-form-item :field="fields[0]"></cube-form-item>
        <!-- 密码 -->
        <cube-form-item :field="fields[1]"></cube-form-item>
      </cube-form-group>
      <cube-form-group>
        <cube-button type="submit">登录</cube-button>
      </cube-form-group>
    </cube-form>
    <router-link to="/register" class="reg"><span>注册</span></router-link>
  </div>
</template>

<script>
//登录接口方法引入
import { loginApi } from '@/api/getData.js'
export default {
  data() {
    return {
      model: {
        phoneValue: '',
        pwdValue: '',
      },
      // 输入框配置
      fields: [
        {
          type: 'input',
          modelKey: 'phoneValue',
          label: '手机号',
          props: {
            placeholder: '请输入手机号',
          },
          rules: {
            required: true,
          },
          messages: {
            required: '手机号不能为空',
          },
        },
        {
          type: 'input',
          modelKey: 'pwdValue',
          label: '密码',
          props: {
            placeholder: '请输入密码',
            type: 'password',
            eye: {
              open: false,
            },
          },
          rules: {
            required: true,
          },
          messages: {
            required: '密码不能为空',
          },
        },
      ],
    }
  },
  methods: {
    //提交表单
    submitHandler(e, model) {
      e.preventDefault()
      //调用登录接口
      loginApi(model.phoneValue, model.pwdValue).then((res) => {
        if (res.data.code === 0) {
          //保存token
          localStorage.setItem('token', res.data.data)
          this.$store.dispatch('setToken',res.data.data)
          this.$router.push({ path: '/personal' })
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
.main {
  padding: 50px 5% 0;
  text-align: center;
}
// 登录
.cube-btn {
  margin-top: 20px;
}
//注册
.reg {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>
