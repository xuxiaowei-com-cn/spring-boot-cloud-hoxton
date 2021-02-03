import {ref} from 'vue'
import {createRouter, createWebHashHistory} from 'vue-router'

import routes from './routes'
import {onLineWhether} from '../api/utils/users'

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

const login = ref('/login')

router.beforeEach((to, from, next) => {

    onLineWhether().then(response => {
        const data = response.data
        const whether = data != null && data.whether === true; // 是否登录

        if (whether) { // 已登录
            if (login.value === to.path) { // 登录页面
                // 强制跳转到登录首页
                location.hash = '/'
            } else { // 非登录页面
                next()
            }
        } else { // 未登录
            if (login.value === to.path) { // 登录页面
                next()
            } else { // 非登录页面
                // 强制跳转到登录页面
                next({
                    path: login.value,
                    query: {redirect: to.fullPath} // 将要跳转路由的path作为参数，传递到登录页面
                })
            }
        }

    })

})

export default router
