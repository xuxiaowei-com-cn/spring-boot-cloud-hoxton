import request from '../../utils/request'

/**
 * 登录请求
 * @param params 参数，username、remember-me、password
 * @returns {Promise<AxiosResponse<any>>}
 */
export function login(params) {
    return request.post('http://localhost:10401/login',
        params
    )
}
