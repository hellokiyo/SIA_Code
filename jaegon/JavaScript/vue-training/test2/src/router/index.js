import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue' //routes.component

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      // 홈 화면
    {
      path: '/',
      name: 'home',
      component: HomeView,  //첫 화면 미리 불러오기
    },
      // 정보 화면
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),  //요청했을때 불러오기
    },
      // 메뉴 화면
    {
      path: '/menu',
      name: 'menu',
      component: () => import('../views/MenuView.vue'),  //요청했을때 불러오기
    },
    {
      path: '/add',
      name: 'add',
      component: () => import('../views/AddCustomerView.vue'),  //요청했을때 불러오기
    },
  ],
})

export default router
