import axios from 'axios'

const request = axios.create({
    // 携带 Cookie
    withCredentials: true
})

export default request
