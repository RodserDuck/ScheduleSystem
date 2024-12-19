import { createRouter, createWebHashHistory } from 'vue-router'


import Login from '../components/Login.vue'
import Regist from '../components/Regist.vue'
import Header from '../components/Header.vue'
import ShowSchedule from '../components/ShowSchedule.vue'
import pinia from '../pinia'
import { defineUser } from '../store/userStore'

let sysUser = defineUser(pinia)
const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: '/', redirect: '/showSchedule' },
        { path: '/regist', component: Regist },
        { path: '/header', component: Header },
        { path: '/login', component: Login },
        { path: '/showSchedule', component: ShowSchedule }
    ]
})
router.beforeEach((to, from, next) => {
    if(to.path == '/showSchedule'){
        if(sysUser.username == ''){
            next('/login')
        }else{ 
            next()
        }
    }else{ 
        next() 
    }
})

export default router