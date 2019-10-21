import Vue from 'vue'
import VueRouter from 'vue-router'
import Album from '../views/Album.vue'

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'Album',
        component: Album
    },
    {
        path: '/folders',
        name: 'Folders',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/Folders.vue')
    },
    {
        path: '/device',
        name: 'Device',
        component: () => import(/* webpackChunkName: "about" */ '../views/Device.vue')
    },
    {
        path: '/scan',
        name:'Scan1',
        component: () => import(/* webpackChunkName: "about" */ '../views/Scan1.vue')
    },
    {
        path: '/log',
        name: 'Log',
        component: () => import(/* webpackChunkName: "about" */ '../views/Log.vue')
    },
    {
        path: '/about',
        name: 'about',
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
];

const router = new VueRouter({
    routes
});

export default router
