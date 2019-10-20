import Vue from 'vue'
import App from './App.vue'
import router from './router'

import {Menu} from 'ant-design-vue';
import {Layout} from 'ant-design-vue';

Vue.component(Menu.name, Menu);
Vue.component(Layout.name, Layout);

Vue.config.productionTip = false;

var Mock = require('mockjs');
Mock.mock("/testMock", "post", {data: "fdsafdsaf"});

new Vue({
    render: h => h(App),
    router
}).$mount('#app');
