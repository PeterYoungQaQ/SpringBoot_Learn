import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: localStorage.getItem('token') || ''
  },
  //同步修改state的值
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    }
  },
  //异步调用mutations里的方法
  //context.commit 利用上下文触发mutations某个方法
  //vue代码里面 this.$store.dispatch 触发 action里面定义的方法
  actions: {
    setToken(context,token) {
      context.commit('SET_TOKEN', token)
    },
    clearToken(context){
      context.commit('SET_TOKEN','')
    }
  }

})
