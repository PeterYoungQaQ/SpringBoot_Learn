import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home/Home.vue'
import Order from '../views/Order/Order.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/order',
    name: 'Order',
    //下面是懒加载
    //component: () => import('../views/Order/Order.vue'),
    component: Order,
    meta: {requiresAuth: true}
  },
  {
    path: '/personal',
    name: 'Personal',
    //component: () => import( '../views/Personal/Personal.vue')
    component: () => import( '../views/Personal/Personal.vue')
  },
  {
    path: '/coursedetail',
    name: 'detail',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/CourseDetail/CourseDetail.vue')
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Login/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Register/Register.vue')
  },
  {
    path: '/pay',
    name: 'Pay',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Pay/Pay.vue'),
    meta: {requiresAuth: true}
  },
]

const router = new VueRouter({
  routes
})

export default router
