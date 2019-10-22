import axios from 'axios'
import {message, notification} from 'ant-design-vue'
// import store from '@/store'
// import {getToken} from '@/utils/auth'

// create an axios instance
const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 5000 // request timeout
});

// request interceptor
service.interceptors.request.use(
    config => {
        // do something before request is sent

        // if (store.getters.token) {
        //     // let each request carry token
        //     // ['X-Token'] is a custom headers key
        //     // please modify it according to the actual situation
        //     config.headers['X-Token'] = getToken()
        // }
        return config
    },
    error => {
        // do something with request error
        console.log(error) // for debug
        return Promise.reject(error)
    }
)

// response interceptor
service.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */
    response => {
        const res = response.data;

        // if the custom code is not 20000, it is judged as an error.
        if (res.code !== 20000) {
            message.error(res.message || 'Error1', 5 );

            // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
            if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
                // to re-login
                notification.error('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
                    confirmButtonText: 'Re-Login',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    // store.dispatch('user/resetToken').then(() => {
                    location.reload()
                    // })
                })
            }
            return Promise.reject(res.message || 'Error')
        } else {
            return res
        }
    },
    error => {
        console.log('err' + error) // for debug
        message.error(error.message || 'Error2', 5 );
        return Promise.reject(error)
    }
)

export default service
