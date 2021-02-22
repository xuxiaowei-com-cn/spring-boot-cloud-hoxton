import request from '../../utils/request'

/**
 * 是否在线
 * @param params 参数
 * @returns {Promise<AxiosResponse<any>>}
 */
export function onLineWhether(params) {
    return request({
        url: 'http://localhost:10201/on-line/whether',
        method: 'post',
        params: params
    })
}
