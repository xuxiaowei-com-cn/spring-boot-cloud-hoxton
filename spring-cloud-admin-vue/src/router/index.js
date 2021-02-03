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

    if (login.value === to.path) {
        // 登录页面，无需进行鉴权
        next()
    } else {
        onLineWhether().then(response => {
            const data = response.data
            if (data != null) {
                if (data.whether === true) {
                    // 已登录，无需操作
                    next()
                } else {
                    // 未登录，强制跳转到登录页面
                    next({
                        path: login.value,
                        query: {redirect: to.fullPath} // 将要跳转路由的path作为参数，传递到登录页面
                    })
                }
            } else {
                // 鉴权时响应数据异常，强制跳转到登录页面
                next({
                    path: login.value,
                    query: {redirect: to.fullPath} // 将要跳转路由的path作为参数，传递到登录页面
                })
            }
        })
    }

})

export default router
