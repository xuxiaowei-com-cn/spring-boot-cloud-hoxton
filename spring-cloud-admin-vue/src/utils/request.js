import axios from 'axios'
import {ElMessage} from 'element-plus'

// 创建 axios 服务
const request = axios.create({
    // 携带 Cookie
    withCredentials: true
})

// 响应
request.interceptors.response.use(response => {
    const resp = response.data // 响应数据
    const config = response.config // 配置
    const params = config.params // 请求参数

    if (params) { // 存在请求参数时
        const code = resp.code; // 响应代码
        const msg = resp.msg; // 响应消息
        if (!params.then && code === '00000') { // 请求参数中不存在 then，并且响应代码正确时，自动执行正常弹窗
            ElMessage.success({
                message: msg,
                type: 'success'
            });
        }
        if (!params.catch && code !== '00000') { // 请求参数中不存在 catch，并且响应代码错误时，自动执行错误弹窗
            ElMessage.warning({
                message: msg,
                type: 'warning'
            });
        }
    }

    // 返回数据
    return resp;
})

export default request
